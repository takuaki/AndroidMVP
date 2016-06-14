package jp.ne.tone.architecturemvp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tmori on 2016/06/13.
 *
 * GitHubのデータ形式(モデル)
 *
 * レポジトリの名前
 * レポジトリの説明
 * レポジトリが作られた時間（2016/05/12 みたいな）
 */
public class GitHubModel {
    @SerializedName("id")


    String repo_id;
    String repo_name;
    String repo_summary;
    String time_created;
}
