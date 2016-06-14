package jp.ne.tone.architecturemvp.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import jp.ne.tone.architecturemvp.model.GitHubModel;
import jp.ne.tone.architecturemvp.view.RepoListView;

/**
 * Created by tmori on 2016/06/13.
 */
public class RepoListFragment extends ListFragment  implements RepoListView{

    private static final String TAG = RepoListFragment.class.getSimpleName();

    //private UserComponent mUserComponent;

    //@Inject
    //ListViewPresenter presenter;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //mUserComponent = ((RepoListActivity)getActivity()).getComponent().newUserComponent(new UserModule());
        //mUserComponent.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedIntanceState){
        return super.onCreateView(inflater,container,savedIntanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //presenter.setView(this);
        //presenter.showRepoView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    //lifecycle
    @Override
    public void onResume(){
        //presenter.onResume();
    }

    @Override
    public void onPause(){
        //presenter.onPause();
    }
    @Override
    public void onDestroy(){
        //presenter.onDestroy();
    }

    @Override
    public void showRepositories(List<GitHubModel> gitHubModelList) {
        Log.d(TAG,"showRepositories");
        for(GitHubModel model :gitHubModelList){
            Log.d(TAG,"name "+model.getName());
        }
    }

    @Override
    public void showLoading() {
        
    }

    public interface Action{
        void clickRepo(int position);
    }

}
