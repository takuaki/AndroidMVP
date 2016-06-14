package jp.ne.tone.architecturemvp.presenter.component;

import dagger.Subcomponent;
import jp.ne.tone.architecturemvp.presenter.PerFragment;
import jp.ne.tone.architecturemvp.presenter.module.FragmentModule;
import jp.ne.tone.architecturemvp.view.fragment.RepoListFragment;

/**
 * Created by mori on 6/14/16.
 */

@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {

    void inject(RepoListFragment fragment);
}
