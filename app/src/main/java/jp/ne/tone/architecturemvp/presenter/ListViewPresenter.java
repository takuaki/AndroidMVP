package jp.ne.tone.architecturemvp.presenter;

import android.util.Log;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.ne.tone.architecturemvp.model.GitHubModel;
import jp.ne.tone.architecturemvp.model.usecase.UseCase;
import jp.ne.tone.architecturemvp.presenter.mapper.GitHubMapper;
import jp.ne.tone.architecturemvp.view.RepoListView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mori on 6/13/16.
 *
 * Presenterの役割とは？
 * PresenterはViewとModleの橋渡し
 *
 */
@PerActivity
public class ListViewPresenter implements Presenter{

    private static final String TAG = ListViewPresenter.class.getSimpleName();

    private RepoListView repoListView;

    UseCase useCase;

    @Inject
    public ListViewPresenter(UseCase useCase){
        this.useCase = useCase;
    }

    public void setView(RepoListView view){
        this.repoListView = view;
    }


    public void onClickRepo(GitHubModel model){
        repoListView.showRepoDetails(model);
    }

    public void initialize(){
        showLoadView();
        showRepoView();
    }

    private void showLoadView(){
        repoListView.showLoading();
    }

    private void hideLoadView(){
        repoListView.hideLoading();
    }

    private void showRepoView(){
        useCase.execute(new Callback<List<GitHubModel>>() {
            @Override
            public void onResponse(Call<List<GitHubModel>> call,
                    Response<List<GitHubModel>> response) {
                Log.d(TAG,"response "+response.toString());
                List<Map<String,String>> viewItems = GitHubMapper.transformer(response.body());
                repoListView.showRepositories(viewItems);
                hideLoadView();
            }
            @Override
            public void onFailure(Call<List<GitHubModel>> call, Throwable t) {
                Log.d(TAG,"onFailure");
            }
        });
    }

    /**
     * LifeCycle管理
     */
    @Override
    public void onPause(){
        Log.d(TAG,"onPause");
    }

    /**
     * useCaseに
     */
    @Override
    public void onResume(){
        Log.d(TAG,"onResume");
        initialize();
    }

    @Override
    public void onDestroy(){
        Log.d(TAG,"onDestroy");
        repoListView =null;
    }

}
