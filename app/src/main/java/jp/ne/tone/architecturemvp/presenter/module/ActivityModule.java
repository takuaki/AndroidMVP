package jp.ne.tone.architecturemvp.presenter.module;

import dagger.Module;
import dagger.Provides;
import jp.ne.tone.architecturemvp.domain.interactor.RepositoriesUseCase;
import jp.ne.tone.architecturemvp.model.usecase.RepoListUseCase;
import jp.ne.tone.architecturemvp.model.usecase.UseCase;
import jp.ne.tone.architecturemvp.presenter.PerActivity;
import jp.ne.tone.architecturemvp.view.activity.RepoListActivity;

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
    UseCase provideRepoListUseCase(RepoListUseCase useCase) {
        return useCase;
    }

    @PerActivity
    @Provides
    jp.ne.tone.architecturemvp.domain.interactor.UseCase
    provideRepositoryUseCase(RepositoriesUseCase useCase){return useCase;}
}
