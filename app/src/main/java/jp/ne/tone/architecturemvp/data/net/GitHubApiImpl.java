package jp.ne.tone.architecturemvp.data.net;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import jp.ne.tone.architecturemvp.presentation.model.GitHubModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by mori on 6/22/16.
 */
@Singleton
public class GitHubApiImpl implements GitHubApi {

    @Inject
    public GitHubApiImpl() {
    }

    @Override
    public Observable<List<GitHubModel>> provideRepositories() {
        return Observable.create(
                new Observable.OnSubscribe<List<GitHubModel>>() {
                    @Override
                    public void call(final Subscriber<? super List<GitHubModel>> subscriber) {

                        GitHubService service = new GitHubService();
                        service.call("takuaki").enqueue(new Callback<List<GitHubModel>>() {
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
                }
        );
    }
}
