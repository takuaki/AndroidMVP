package jp.ne.tone.architecturemvp.presentation.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import jp.ne.tone.architecturemvp.R;
import jp.ne.tone.architecturemvp.presentation.presenter.component.ActivityComponent;
import jp.ne.tone.architecturemvp.presentation.presenter.module.ActivityModule;
import jp.ne.tone.architecturemvp.presentation.view.MyApp;
import jp.ne.tone.architecturemvp.presentation.view.RepoItem;
import jp.ne.tone.architecturemvp.presentation.view.fragment.RepoListFragment;
import jp.ne.tone.architecturemvp.presentation.view.util.EspressoIdingResource;

/**
 * Created by tmori on 2016/06/13.
 */
public class RepoListActivity extends AppCompatActivity implements RepoListFragment.RepoListListener {

    private static final String TAG = RepoListActivity.class.getSimpleName();
    private ActivityComponent activityComponent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        activityComponent = ((MyApp) (getApplication())).getApplicationComponent()
                .newActivityComponent(new ActivityModule(this));
        activityComponent.inject(this);

        RepoListFragment viewFragment = new RepoListFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fragmentContainer, viewFragment);
        transaction.commit();
    }

    /**
     * 画面遷移
     *
     * @param model
     */
    @Override
    public void onRepoClicked(RepoItem item) {
        Intent intent = new Intent(this, RepoDetailActivity.class);
        startActivity(intent);
    }

    public ActivityComponent getComponent() {
        return activityComponent;
    }

    @VisibleForTesting
    public IdlingResource getCountingForIdlingResource() {
        return EspressoIdingResource.getIdlingResource();
    }

}
