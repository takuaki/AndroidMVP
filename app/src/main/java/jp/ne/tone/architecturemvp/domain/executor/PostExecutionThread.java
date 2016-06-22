package jp.ne.tone.architecturemvp.domain.executor;

import javax.inject.Singleton;

import rx.Scheduler;

/**
 * Created by mori on 6/21/16.
 */
@Singleton
public interface PostExecutionThread {
    Scheduler getScheduler();
}
