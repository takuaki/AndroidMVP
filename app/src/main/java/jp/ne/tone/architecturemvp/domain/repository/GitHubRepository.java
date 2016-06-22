package jp.ne.tone.architecturemvp.domain.repository;

import jp.ne.tone.architecturemvp.model.GitHubModel;
import rx.Observable;

/**
 * Created by mori on 6/22/16.
 */
public interface GitHubRepository {

    Observable<GitHubModel> repo(final String name);
}
