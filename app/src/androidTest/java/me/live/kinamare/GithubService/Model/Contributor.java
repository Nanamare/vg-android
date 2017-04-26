package me.live.kinamare.GithubService.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by kinamare on 2017-04-26.
 */

public class Contributor implements Serializable {

		@SerializedName("login") public String mLogin;
		@SerializedName("id") public int mId;
		@SerializedName("avatar_url") public String avatar_url;
		@SerializedName("url") public String url;
		@SerializedName("html_url") public String html_url;
		@SerializedName("followers_url") public String followers_url;
		@SerializedName("following_url") public String following_url;
		@SerializedName("starred_url") public String starred_url;
		@SerializedName("subscriptions_url") public String subscriptions_url;
		@SerializedName("organizations_url") public String organizations_url;
		@SerializedName("repos_url") public String repos_url;
		@SerializedName("events_url") public String events_url;
		@SerializedName("received_events_url") public String received_events_url;
		@SerializedName("type") public String type;
		@SerializedName("site_admin") public boolean site_admin;
		@SerializedName("contributions") public int contributions;


}
