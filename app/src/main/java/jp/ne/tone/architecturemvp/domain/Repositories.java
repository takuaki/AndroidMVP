package jp.ne.tone.architecturemvp.domain;

import java.util.List;

import javax.inject.Singleton;

import jp.ne.tone.architecturemvp.model.GitHubModel;
import rx.Observable;

/**
 * Created by mori on 6/21/16.
 */
@Singleton
public interface Repositories  {
    Observable<List<GitHubModel>>  getRepoList(final String user);
}
