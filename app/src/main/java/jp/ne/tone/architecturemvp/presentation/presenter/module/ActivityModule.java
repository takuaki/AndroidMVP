package jp.ne.tone.architecturemvp.presentation.presenter.module;

import dagger.Module;
import dagger.Provides;
import jp.ne.tone.architecturemvp.domain.interactor.RepositoriesUseCase;
import jp.ne.tone.architecturemvp.domain.interactor.UseCase;
import jp.ne.tone.architecturemvp.presentation.presenter.PerActivity;
import jp.ne.tone.architecturemvp.presentation.view.activity.RepoListActivity;

/**
 * Created by mori on 6/13/16.
 */
@Module
public class ActivityModule {

    private final RepoListActivity activity;

    public ActivityModule(RepoListActivity activity) {
        this.activity = activity;
    }


    @PerActivity
    @Provides
    UseCase provideRepositoryUseCase(RepositoriesUseCase useCase) {
        return useCase;
    }
}
