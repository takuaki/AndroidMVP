package jp.ne.tone.architecturemvp.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import jp.ne.tone.architecturemvp.MyApp;
import jp.ne.tone.architecturemvp.R;
import jp.ne.tone.architecturemvp.presenter.ListViewPresenter;
import jp.ne.tone.architecturemvp.presenter.component.ActivityComponent;
import jp.ne.tone.architecturemvp.presenter.module.ActivityModule;

/**
 * Created by tmori on 2016/06/13.
 */
public class RepoListActivity extends AppCompatActivity {

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

        //RepoListFragment viewFragment = new RepoListFragment();

        //FragmentManager manager = getSupportFragmentManager();
        //FragmentTransaction transaction =  manager.beginTransaction();
        //transaction.add(R.id.fragmentContainer,viewFragment);
        //transaction.commit();
    }

    public ActivityComponent getComponent(){
        return activityComponent;
    }



}
