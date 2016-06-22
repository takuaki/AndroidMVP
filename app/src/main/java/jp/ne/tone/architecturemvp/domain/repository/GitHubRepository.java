package jp.ne.tone.architecturemvp.domain.repository;

import java.util.List;

import jp.ne.tone.architecturemvp.presentation.model.GitHubModel;
import rx.Observable;

/**
 * Created by mori on 6/22/16.
 */
public interface GitHubRepository {

    Observable<List<GitHubModel>> repos();
}
