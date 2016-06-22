package jp.ne.tone.architecturemvp.domain.executor;

import java.util.concurrent.Executor;

/**
 * Created by mori on 6/21/16.
 *
 * Executor implementation can be based on different framework
 * execution, but every implementation will execute the
 * {@link jp.ne.tone.architecturemvp.domain.usecase.UseCase} out of UI thread.
 */
public interface ThreadExecutor extends Executor{}
