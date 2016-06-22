package jp.ne.tone.architecturemvp.domain.usecase;

import jp.ne.tone.architecturemvp.domain.executor.PostExecutionThread;
import jp.ne.tone.architecturemvp.domain.executor.ThreadExecutor;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Created by mori on 6/21/16.
 */
public abstract class UseCase {

    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;

    private Subscription subscription = Subscriptions.empty();


    protected UseCase(ThreadExecutor executor, PostExecutionThread postExecutionThread) {
        this.threadExecutor = executor;
        this.postExecutionThread = postExecutionThread;
    }

    /**
     * Builds an {@link rx.Observable}
     */
    protected abstract Observable buildUseCaseObservable();

    public void execute(Subscriber useCaseSubscriber){
        this.subscription = this.buildUseCaseObservable()
            .subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postExecutionThread.getScheduler())
                .subscribe(useCaseSubscriber);
    }

    /**
     * Unsubscribes from current {@link rx.Subscription}.
     */
    public void unsubscribe(){
        if(!subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }
    }

}
