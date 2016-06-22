package jp.ne.tone.architecturemvp.data.net;

import java.util.List;

import jp.ne.tone.architecturemvp.model.GitHubModel;
import rx.Observable;

/**
 * Created by mori on 6/22/16.
 */
public interface GitHubApi{

    Observable<List<GitHubModel>> provideRepositories();

}
