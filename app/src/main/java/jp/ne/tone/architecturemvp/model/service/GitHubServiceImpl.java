package jp.ne.tone.architecturemvp.model.service;

import java.util.List;

import jp.ne.tone.architecturemvp.model.GitHubModel;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Path;

/**
 * Created by mori on 6/13/16.
 */
public class GitHubServiceImpl implements GitHubService {

    private static final String baseUrl = "https://api.github.com/users/";

    private final Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).
            addConverterFactory(GsonConverterFactory.create()).build();

    @Override
    public Call<List<GitHubModel>> listRepos(@Path("user") String user) {
        return retrofit.create(GitHubService.class).listRepos(user);
    }
}
