package jp.ne.tone.architecturemvp.view;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mori on 6/19/16.
 */
public class RepoItem {
    @SerializedName("name")
    private String name;
    @SerializedName("desc")
    private String description;

    public RepoItem(final String name, final String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
