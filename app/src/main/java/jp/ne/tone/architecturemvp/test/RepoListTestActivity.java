package jp.ne.tone.architecturemvp.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import jp.ne.tone.architecturemvp.R;
import jp.ne.tone.architecturemvp.model.GitHubModel;
import jp.ne.tone.architecturemvp.model.service.GitHubService;
import jp.ne.tone.architecturemvp.model.service.GitHubServiceImpl;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tmori on 2016/06/14.
 *
 * テストがまだ書けないので、Acitivytでテスト
 * かっこわるいなぁーー...
 */
public class RepoListTestActivity extends Activity {

    private static String TAG = RepoListTestActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedIntanceState){
        super.onCreate(savedIntanceState);
        setContentView(R.layout.activity_layout);
        GitHubService gitHubService = new GitHubServiceImpl();
        Log.d(TAG,"onCrate");

        Call<List<GitHubModel>> call = gitHubService.listRepos("takuaki");
        call.enqueue(new Callback<List<GitHubModel>>() {
            @Override
            public void onResponse(Call<List<GitHubModel>> call,
                    Response<List<GitHubModel>> response) {
                Log.d(TAG,"onSuccess "+response.body().toString());
            }

            @Override
            public void onFailure(Call<List<GitHubModel>> call, Throwable t) {
                Log.d(TAG,"onFailure");
            }
        });


    }

}
