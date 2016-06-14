package jp.ne.tone.architecturemvp.view;

import java.util.List;
import java.util.Map;

/**
 * Created by tmori on 2016/06/13.
 */
public interface RepoListView {

    void showRepositories(List<Map<String,String>> mapList);
    void showLoading();

}
