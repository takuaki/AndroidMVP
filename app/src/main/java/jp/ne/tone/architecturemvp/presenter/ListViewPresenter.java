package jp.ne.tone.architecturemvp.presenter;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import jp.ne.tone.architecturemvp.domain.usecase.DefaultSubscriber;
import jp.ne.tone.architecturemvp.domain.usecase.UseCase;
import jp.ne.tone.architecturemvp.model.GitHubModel;
import jp.ne.tone.architecturemvp.view.RepoItem;
import jp.ne.tone.architecturemvp.view.RepoListView;

/**
 * Created by mori on 6/13/16.
 * <p/>
 * Presenterの役割とは？
 * PresenterはViewとModleの橋渡し
 */
@PerActivity
public class ListViewPresenter implements Presenter {

    private static final String TAG = ListViewPresenter.class.getSimpleName();

    private RepoListView repoListView;

    UseCase useCase;

    @Inject
    public ListViewPresenter(UseCase useCase) {
        this.useCase = useCase;
    }

    public void setView(RepoListView view) {
        this.repoListView = view;
    }


    public void onClickRepo(RepoItem item) {
        repoListView.showRepoDetails(item);
    }

    public void initialize() {
        showLoadView();
        showRepoView();
    }

    private void showLoadView() {
        repoListView.showLoading();
    }

    private void hideLoadView() {
        repoListView.hideLoading();
    }

    private void showRepoView() {
        useCase.execute(new ListViewSubscriber());
    }

    /**
     * LifeCycle管理
     */
    @Override
    public void onPause() {
        Log.d(TAG, "onPause");
    }

    /**
     * useCaseに
     */
    @Override
    public void onResume() {
        Log.d(TAG, "onResume");
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
        repoListView = null;
        useCase.unsubscribe();
    }

    private final class ListViewSubscriber extends DefaultSubscriber<List<GitHubModel>>{
        @Override
        public void onCompleted() {
            hideLoadView();
        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG,e.getMessage());
        }

        @Override
        public void onNext(List<GitHubModel> gitHubModelList) {

        }
    }
}
