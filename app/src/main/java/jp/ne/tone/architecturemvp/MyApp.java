package jp.ne.tone.architecturemvp;

import android.app.Application;

import jp.ne.tone.architecturemvp.presenter.component.ApplicationComponent;
import jp.ne.tone.architecturemvp.presenter.component.DaggerApplicationComponent;
import jp.ne.tone.architecturemvp.presenter.module.ApplicationModule;

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

    public ApplicationComponent getApplicationComponent(){
        return mApplicationComponent;
    }

}
