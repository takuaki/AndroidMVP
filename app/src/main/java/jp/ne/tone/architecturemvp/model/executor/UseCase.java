package jp.ne.tone.architecturemvp.model.executor;

import java.util.List;

import jp.ne.tone.architecturemvp.model.GitHubModel;
import retrofit2.Callback;

/**
 * Created by tmori on 2016/06/14.
 */
public interface UseCase {
    public void execute(Callback<List<GitHubModel>> callback);
}
