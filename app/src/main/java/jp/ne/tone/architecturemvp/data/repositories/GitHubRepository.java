package jp.ne.tone.architecturemvp.data.repositories;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import jp.ne.tone.architecturemvp.data.service.GitHubService;
import jp.ne.tone.architecturemvp.domain.Repositories;
import jp.ne.tone.architecturemvp.model.GitHubModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by mori on 6/21/16.
 */
@Singleton
public class GitHubRepository implements Repositories {

    private static final String baseUrl = "https://api.github.com";

    private GitHubService gitHubService;

    @Inject
    public GitHubRepository(GitHubService service) {
        gitHubService = service;
    }

    @Override
    public Observable<List<GitHubModel>> getRepoList(final String user) {

        return Observable.create(new Observable.OnSubscribe<List<GitHubModel>>() {
            @Override
            public void call(final Subscriber<? super List<GitHubModel>> subscriber) {
                gitHubService.listRepos(user).enqueue(new Callback<List<GitHubModel>>() {
                    @Override
                    public void onResponse(Call<List<GitHubModel>> call, Response<List<GitHubModel>> response) {
                        subscriber.onNext(response.body());
                        subscriber.onCompleted();
                    }
                    @Override
                    public void onFailure(Call<List<GitHubModel>> call, Throwable t) {
                        subscriber.onError(t);
                    }
                });
            }
        });
    }
}
