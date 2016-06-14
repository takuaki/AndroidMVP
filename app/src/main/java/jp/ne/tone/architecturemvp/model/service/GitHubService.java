package jp.ne.tone.architecturemvp.model.service;

import java.util.List;

import jp.ne.tone.architecturemvp.model.GitHubModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by mori on 6/13/16.
 */
public interface GitHubService {
    @GET("/{user}/repos")
    Call<List<GitHubModel>> listRepos(@Path("user") String user);
}
