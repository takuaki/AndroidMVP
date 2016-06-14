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

    RepoListView repoListView;

    UseCase useCase;

    @Inject
    public ListViewPresenter(UseCase useCase){
        this.useCase = useCase;
    }

    public void setView(RepoListView view){
        this.repoListView = view;
    }


    public void onClickRepo(String name){
        //TODO  次の画面がないので未実装。あとからやりましょ
    }

    public void showLoadView(){

    }

    public void showRepoView(){
        useCase.execute(new Callback<List<GitHubModel>>() {
            @Override
            public void onResponse(Call<List<GitHubModel>> call,
                    Response<List<GitHubModel>> response) {
                List<Map<String,String>> viewItems = GitHubMapper.transformer(response.body());
                repoListView.showRepositories(viewItems);
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

    }

    /**
     * useCaseに
     */
    @Override
    public void onResume(){
        Log.d(TAG,"onResume");
        showRepoView();
    }

    @Override
    public void onDestroy(){
        repoListView =null;
    }

}
