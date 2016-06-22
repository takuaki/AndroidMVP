package jp.ne.tone.architecturemvp.data.repository;

import javax.inject.Inject;
import javax.inject.Singleton;

import jp.ne.tone.architecturemvp.domain.repository.GitHubRepository;
import jp.ne.tone.architecturemvp.model.GitHubModel;
import rx.Observable;

/**
 * Created by mori on 6/22/16.
 */
@Singleton
public class GitHubDataRepository implements GitHubRepository {

    @Inject
    public GitHubDataRepository(){}

    @Override
    public Observable<GitHubModel> repo(String name) {
        return null;
    }
}
