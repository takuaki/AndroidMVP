package jp.ne.tone.architecturemvp.domain.interactor;

import javax.inject.Inject;

import jp.ne.tone.architecturemvp.data.net.GitHubApi;
import jp.ne.tone.architecturemvp.domain.executor.PostExecutionThread;
import jp.ne.tone.architecturemvp.domain.executor.ThreadExecutor;
import jp.ne.tone.architecturemvp.presenter.PerActivity;
import rx.Observable;

/**
 * Created by mori on 6/22/16.
 */

@PerActivity
public class RepositoriesUseCase extends UseCase {

    @Inject
    GitHubApi gitHubApi ;

    @Inject
    public RepositoriesUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return gitHubApi.provideRepositories();
    }

}
