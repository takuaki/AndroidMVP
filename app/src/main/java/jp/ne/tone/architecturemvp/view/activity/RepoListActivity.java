package jp.ne.tone.architecturemvp.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import jp.ne.tone.architecturemvp.MyApp;
import jp.ne.tone.architecturemvp.R;
import jp.ne.tone.architecturemvp.model.GitHubModel;
import jp.ne.tone.architecturemvp.presenter.component.ActivityComponent;
import jp.ne.tone.architecturemvp.presenter.module.ActivityModule;
import jp.ne.tone.architecturemvp.view.fragment.RepoListFragment;
import jp.ne.tone.architecturemvp.view.util.EspressoIdingResource;

/**
 * Created by tmori on 2016/06/13.
 */
public class RepoListActivity extends AppCompatActivity implements RepoListFragment.RepoListListener{

    private static final String TAG = RepoListActivity.class.getSimpleName();
    private ActivityComponent activityComponent ;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        activityComponent = ((MyApp)(getApplication())).getApplicationComponent()
                .newActivityComponent(new ActivityModule(this));
        activityComponent.inject(this);

        RepoListFragment viewFragment = new RepoListFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction =  manager.beginTransaction();
        transaction.add(R.id.fragmentContainer,viewFragment);
        transaction.commit();
    }

    /**
     * 画面遷移
     * @param model
     */
    @Override
    public void onRepoClicked(GitHubModel model) {
        Intent intent = new Intent(this,RepoDetailActivity.class);
        startActivity(intent);
    }

    public ActivityComponent getComponent(){
        return activityComponent;
    }

    @VisibleForTesting
    public IdlingResource getCountingForIdlingResource(){
        return EspressoIdingResource.getIdlingResource();
    }

}
