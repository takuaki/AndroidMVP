package jp.ne.tone.architecturemvp.view;

import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;

import java.util.Collections;
import java.util.Map;

/**
 * Created by mori on 6/14/16.
 * <p/>
 * View用のデータ
 */
public final class RepoView {

    public static final String KEY_NAME = "name";
    public static final String KEY_DESC = "desc";

    public static Map<String, String> RepoView(@NonNull String name, @NonNull String description) {
        Map<String, String> stringMap = new ArrayMap<String, String>();
        stringMap.put(KEY_NAME, name);
        stringMap.put(KEY_DESC, description);
        return Collections.unmodifiableMap(stringMap);
    }

}
