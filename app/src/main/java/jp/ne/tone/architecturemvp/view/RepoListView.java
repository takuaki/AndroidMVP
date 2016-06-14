package jp.ne.tone.architecturemvp.view;

import java.util.List;

import jp.ne.tone.architecturemvp.model.GitHubModel;

/**
 * Created by tmori on 2016/06/13.
 */
public interface RepoListView {

    void showRepositories(List<GitHubModel> gitHubModelList);
    void showLoading();

}
