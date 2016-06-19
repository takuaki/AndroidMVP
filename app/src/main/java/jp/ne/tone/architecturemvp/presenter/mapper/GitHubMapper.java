package jp.ne.tone.architecturemvp.presenter.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jp.ne.tone.architecturemvp.model.GitHubModel;
import jp.ne.tone.architecturemvp.view.RepoItem;

/**
 * Created by mori on 6/14/16.
 */
public class GitHubMapper {
    public static List<RepoItem> transformer(List<GitHubModel> gitHubModelList) {
        List<RepoItem> list = new ArrayList<>();
        for (GitHubModel model : gitHubModelList) {
            list.add(new RepoItem(model.getName(), model.getDescription()));
        }
        return Collections.unmodifiableList(list);
    }
}
