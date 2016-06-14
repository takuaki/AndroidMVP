package jp.ne.tone.architecturemvp.presenter.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import jp.ne.tone.architecturemvp.model.GitHubModel;
import jp.ne.tone.architecturemvp.view.RepoView;

/**
 * Created by mori on 6/14/16.
 */
public class GitHubMapper {
    public static List<Map<String,String>>transformer(List<GitHubModel> gitHubModelList){
        List<Map<String,String>> list = new ArrayList<>();
        for(GitHubModel model:gitHubModelList){
            list.add(RepoView.RepoView(model.getName(),model.getDescription()));
        }
        return Collections.unmodifiableList(list);
    }
}
