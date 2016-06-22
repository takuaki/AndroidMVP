package jp.ne.tone.architecturemvp.domain.interactor;

import jp.ne.tone.architecturemvp.data.net.GitHubApi;
import jp.ne.tone.architecturemvp.data.net.GitHubApiImpl;
import jp.ne.tone.architecturemvp.domain.executor.PostExecutionThread;
import jp.ne.tone.architecturemvp.domain.executor.ThreadExecutor;
import rx.Observable;

/**
 * Created by mori on 6/22/16.
 */
public class RepositoriesUseCase extends UseCase {

    private GitHubApi gitHubApi ;

    protected RepositoriesUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        gitHubApi = new GitHubApiImpl();

    }

    @Override
    protected Observable buildUseCaseObservable() {
        return gitHubApi.provideRepositories();
    }

}
