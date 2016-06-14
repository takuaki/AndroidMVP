package jp.ne.tone.architecturemvp.presenter.component;

import javax.inject.Singleton;

import dagger.Component;
import jp.ne.tone.architecturemvp.presenter.module.ApplicationModule;

/**
 * Created by mori on 6/13/16.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent{

    ActivityComponent getActivityComponent();

}
