package jp.ne.tone.architecturemvp.data.net;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import jp.ne.tone.architecturemvp.model.GitHubModel;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by mori on 6/22/16.
 */
@Singleton
public class GitHubApiImpl implements GitHubApi {

    private static final String baseUrl = "https://api.github.com";
    private static List<GitHubModel> modelList  = new ArrayList<>();
    static{
        GitHubModel model = new GitHubModel();
        model.setName("Android-CleanArchitecture");
        model.setId("id");
        model.setDescription("Android-CleanArchitecture");
        modelList.add(model);
    }

    @Inject
    public GitHubApiImpl() {}

    @Override
    public Observable<List<GitHubModel>> provideRepositories() {
        return Observable.create(
                new Observable.OnSubscribe<List<GitHubModel>>() {
                    @Override
                    public void call(Subscriber<? super List<GitHubModel>> subscriber) {
                        //TODO 未実装 今はから。
                        subscriber.onNext(modelList);
                        subscriber.onCompleted();
                    }
                }
        );
    }
}
