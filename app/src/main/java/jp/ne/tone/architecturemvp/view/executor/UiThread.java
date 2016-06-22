package jp.ne.tone.architecturemvp.view.executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import jp.ne.tone.architecturemvp.domain.executor.PostExecutionThread;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by mori on 6/22/16.
 */
@Singleton
public class UiThread implements PostExecutionThread {

    @Inject
    public UiThread(){}

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
