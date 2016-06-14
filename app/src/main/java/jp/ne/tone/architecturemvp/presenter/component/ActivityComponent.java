package jp.ne.tone.architecturemvp.presenter.component;

import dagger.Subcomponent;
import jp.ne.tone.architecturemvp.presenter.PerActivity;
import jp.ne.tone.architecturemvp.presenter.module.ActivityModule;
import jp.ne.tone.architecturemvp.presenter.module.FragmentModule;
import jp.ne.tone.architecturemvp.view.activity.RepoListActivity;

/**
 * Created by mori on 6/13/16.
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(RepoListActivity activity);

    FragmentComponent newFragmentComponent(FragmentModule module);
}
