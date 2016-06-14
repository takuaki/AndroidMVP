package jp.ne.tone.architecturemvp.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import jp.ne.tone.architecturemvp.MyApp;
import jp.ne.tone.architecturemvp.R;
import jp.ne.tone.architecturemvp.model.GitHubModel;
import jp.ne.tone.architecturemvp.presenter.ListViewPresenter;
import jp.ne.tone.architecturemvp.presenter.component.ActivityComponent;
import jp.ne.tone.architecturemvp.presenter.module.ActivityModule;
import jp.ne.tone.architecturemvp.view.RepoListView;

/**
 * Created by tmori on 2016/06/13.
 */
public class RepoListActivity extends AppCompatActivity implements RepoListView{

    private static final String TAG = RepoListActivity.class.getSimpleName();
    private ActivityComponent activityComponent ;

    @Inject
    ListViewPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        activityComponent = ((MyApp)(getApplication())).getApplicationComponent()
                .newActivityComponent(new ActivityModule());
        activityComponent.inject(this);
        presenter.setView(this);
        //RepoListFragment viewFragment = new RepoListFragment();

        //FragmentManager manager = getSupportFragmentManager();
        //FragmentTransaction transaction =  manager.beginTransaction();
        //transaction.add(R.id.fragmentContainer,viewFragment);
        //transaction.commit();
    }

    @Override
    public void onResume(){
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onPause(){
        super.onPause();
        presenter.onPause();
    }

    @Override
    public void onDestroy(){
        presenter.onDestroy();
        super.onDestroy();
    }

    public ActivityComponent getComponent(){
        return activityComponent;
    }

    @Override
    public void showLoading(){

    }

    @Override
    public void showRepositories(List<GitHubModel> gitHubModelList) {
        Log.d(TAG,"showRepositories");
        for(GitHubModel model :gitHubModelList){
            Log.d(TAG,"name "+model.getName());
        }
    }




}
