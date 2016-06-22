package jp.ne.tone.architecturemvp.domain.usecase;

/**
 * Created by mori on 6/21/16.
 */
public abstract class DefaultSubscriber<T> extends rx.Subscriber<T>{

    @Override
    abstract public void onCompleted();

    @Override
    abstract public void onError(Throwable e);

    @Override
    abstract public void onNext(T t);
}
