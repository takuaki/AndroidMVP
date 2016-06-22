package jp.ne.tone.architecturemvp.view;

import javax.inject.Inject;
import javax.inject.Singleton;

import jp.ne.tone.architecturemvp.domain.executor.PostExecutionThread;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;


/**
 * Created by mori on 6/22/16.
 */
@Singleton
public class UIThread implements PostExecutionThread {

    @Inject
    public void UIThread(){}

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
