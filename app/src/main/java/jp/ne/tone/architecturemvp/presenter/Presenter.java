package jp.ne.tone.architecturemvp.presenter;

/**
 * Created by mori on 6/13/16.
 */
public interface Presenter {
    void onPause();
    void onResume();
    void onDestroy();
}
