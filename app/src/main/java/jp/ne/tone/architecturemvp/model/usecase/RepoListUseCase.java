package jp.ne.tone.architecturemvp.model.usecase;

import java.util.List;

import javax.inject.Inject;

import jp.ne.tone.architecturemvp.model.GitHubModel;
import jp.ne.tone.architecturemvp.model.service.GitHubService;
import jp.ne.tone.architecturemvp.presenter.PerActivity;
import retrofit2.Callback;

/**
 * Created by tmori on 2016/06/14.
 */
@PerActivity
public class RepoListUseCase implements UseCase{

    GitHubService mGitHubService;

    @Inject
    public RepoListUseCase(GitHubService gitHubService){
        mGitHubService = gitHubService;
    }

    @Override
    public void execute(Callback<List<GitHubModel>> callback) {
        mGitHubService.listRepos("takuaki").enqueue(callback);
    }
}
