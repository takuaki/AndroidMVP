package jp.ne.tone.architecturemvp.view;

import java.util.List;

/**
 * Created by tmori on 2016/06/13.
 */
public interface RepoListView {
    void showRepositories(List<RepoItem> mapList);

    void showLoading();

    void hideLoading();

    void showRepoDetails(RepoItem item);
}
