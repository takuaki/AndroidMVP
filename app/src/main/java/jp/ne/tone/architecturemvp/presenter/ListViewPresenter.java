package jp.ne.tone.architecturemvp.presenter;

import javax.inject.Inject;

import jp.ne.tone.architecturemvp.model.GitHubModel;
import jp.ne.tone.architecturemvp.model.UseCase;
import jp.ne.tone.architecturemvp.view.RepoListView;

/**
 * Created by mori on 6/13/16.
 *
 * Presenterの役割とは？
 * PresenterはViewとModleの橋渡し
 *
 */
@PerActivity
public class ListViewPresenter implements Presenter{

    RepoListView repoListView;
    UseCase useCase;

    @Inject
    public ListViewPresenter(UseCase useCase){
        this.useCase = useCase;
    }

    public void setView(RepoListView view){
        this.repoListView = view;
    }

    public void onClickRepo(){

    }

    public void showLoadView(){

    }

    public void showRepoView(GitHubModel gitHubModel){

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

    }

    @Override
    public void onDestroy(){
        repoListView =null;
    }

}
