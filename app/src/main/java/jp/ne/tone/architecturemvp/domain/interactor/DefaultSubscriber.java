package jp.ne.tone.architecturemvp.domain.interactor;

/**
 * Created by mori on 6/22/16.
 */
public class DefaultSubscriber<T> extends rx.Subscriber<T>{
    @Override
    public void onNext(T t) {

    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }
}
