package jp.ne.tone.architecturemvp.presentation.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tmori on 2016/06/13.
 * <p/>
 * GitHubのデータ形式(モデル)
 * <p/>
 * id:レポジトリのID
 * name:レポジトリの名前
 * description:レポジトリの説明
 */
public class GitHubModel {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("RepositotyResponse{id:%s,name:%s,description:%s}", id, name, description);
    }
}
