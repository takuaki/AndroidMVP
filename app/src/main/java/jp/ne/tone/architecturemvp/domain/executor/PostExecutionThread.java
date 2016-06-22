package jp.ne.tone.architecturemvp.domain.executor;

import rx.Scheduler;

/**
 * Created by mori on 6/22/16.
 */
public interface PostExecutionThread {
    Scheduler getScheduler();
}
