package jp.ne.tone.architecturemvp.presenter.component;

import dagger.Subcomponent;
import jp.ne.tone.architecturemvp.presenter.PerActivity;
import jp.ne.tone.architecturemvp.presenter.module.ActivityModule;

/**
 * Created by mori on 6/13/16.
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {
}
