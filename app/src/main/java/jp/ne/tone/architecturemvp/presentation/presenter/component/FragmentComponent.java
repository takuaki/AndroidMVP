package jp.ne.tone.architecturemvp.presentation.presenter.component;

import dagger.Subcomponent;
import jp.ne.tone.architecturemvp.presentation.presenter.PerFragment;
import jp.ne.tone.architecturemvp.presentation.presenter.module.FragmentModule;
import jp.ne.tone.architecturemvp.presentation.view.fragment.RepoListFragment;

/**
 * Created by mori on 6/14/16.
 */

@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {

    void inject(RepoListFragment fragment);
}
