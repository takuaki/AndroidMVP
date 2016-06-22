package jp.ne.tone.architecturemvp.presentation.view;

import android.app.Application;

import jp.ne.tone.architecturemvp.presentation.presenter.component.ApplicationComponent;
import jp.ne.tone.architecturemvp.presentation.presenter.component.DaggerApplicationComponent;
import jp.ne.tone.architecturemvp.presentation.presenter.module.ApplicationModule;

/**
 * Created by tmori on 2016/06/13.
 */
public class MyApp extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder().
                applicationModule(new ApplicationModule(this)).build();

    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

}
