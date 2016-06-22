package jp.ne.tone.architecturemvp.presentation.presenter;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by mori on 6/13/16.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
