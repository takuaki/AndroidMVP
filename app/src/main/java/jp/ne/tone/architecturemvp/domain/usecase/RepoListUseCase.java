package jp.ne.tone.architecturemvp.domain.usecase;

import javax.inject.Inject;

import jp.ne.tone.architecturemvp.domain.Repositories;
import jp.ne.tone.architecturemvp.domain.executor.PostExecutionThread;
import jp.ne.tone.architecturemvp.domain.executor.ThreadExecutor;
import jp.ne.tone.architecturemvp.presenter.PerActivity;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by mori on 6/21/16.
 */
@PerActivity
public class RepoListUseCase extends UseCase {

    private Repositories repositories;

    @Inject
    protected RepoListUseCase(Repositories repositories,ThreadExecutor executor, PostExecutionThread postExecutionThread) {
        super(executor, postExecutionThread);
        this.repositories = repositories;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return repositories.getRepoList();
    }

    @Override
    public void execute(Subscriber useCaseSubscriber) {
        super.execute(useCaseSubscriber);
    }

    @Override
    public void unsubscribe() {
        super.unsubscribe();
    }
}
