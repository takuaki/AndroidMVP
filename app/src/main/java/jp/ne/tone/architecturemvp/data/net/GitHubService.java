package jp.ne.tone.architecturemvp.data.net;

import java.util.List;

import jp.ne.tone.architecturemvp.presentation.model.GitHubModel;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by mori on 6/23/16.
 */

public class GitHubService {

    public interface Bridge {
        @GET("/users/{user}/repos")
        Call<List<GitHubModel>> listRepos(@Path("user") String name);
    }

    private static final String BASE_URL = "https://api.github.com";
    final Retrofit retrofit;

    public GitHubService() {
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Call<List<GitHubModel>> call(@Path("user") String name) {
        return retrofit.create(Bridge.class).listRepos(name);
    }

}
