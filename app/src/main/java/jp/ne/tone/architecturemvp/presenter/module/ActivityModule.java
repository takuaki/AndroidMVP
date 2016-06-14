package jp.ne.tone.architecturemvp.presenter.module;

import dagger.Module;
import dagger.Provides;
import jp.ne.tone.architecturemvp.model.executor.RepoListUseCase;
import jp.ne.tone.architecturemvp.model.executor.UseCase;
import jp.ne.tone.architecturemvp.presenter.PerActivity;

/**
 * Created by mori on 6/13/16.
 */
@Module
public class ActivityModule {

    @PerActivity
    @Provides
    UseCase provideRepoListUseCase(RepoListUseCase useCase){
        return useCase;
    }
}
