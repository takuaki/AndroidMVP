package jp.ne.tone.architecturemvp.view.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import jp.ne.tone.architecturemvp.model.GitHubModel;
import jp.ne.tone.architecturemvp.presenter.ListViewPresenter;
import jp.ne.tone.architecturemvp.view.RepoListView;

/**
 * Created by tmori on 2016/06/13.
 */
public class RepoListFragment extends ListFragment  implements RepoListView{

    @Inject
    ListViewPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedIntanceState){
        return super.onCreateView(inflater,container,savedIntanceState);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.setView(this);
    }

    //lifecycle
    @Override
    public void onResume(){
        presenter.onResume();
    }

    @Override
    public void onPause(){
        presenter.onPause();
    }
    @Override
    public void onDestroy(){
        presenter.onDestroy();
    }


    @Override
    public void showRepositories(List<GitHubModel> gitHubModelList) {
        //setListAdapter();
    }

    public interface Action{
        void clickRepo(int position);
    }

}
