package jp.ne.tone.architecturemvp.data.repository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import jp.ne.tone.architecturemvp.data.net.GitHubApi;
import jp.ne.tone.architecturemvp.domain.repository.GitHubRepository;
import jp.ne.tone.architecturemvp.model.GitHubModel;
import rx.Observable;

/**
 * Created by mori on 6/22/16.
 */
@Singleton
public class GitHubDataRepository implements GitHubRepository {

    private GitHubApi gitHubApi;

    @Inject
    public GitHubDataRepository(GitHubApi gitHubApi){
        this.gitHubApi =gitHubApi;
    }

    @Override
    public Observable<List<GitHubModel>> repos() {
        return gitHubApi.provideRepositories();
    }
}
