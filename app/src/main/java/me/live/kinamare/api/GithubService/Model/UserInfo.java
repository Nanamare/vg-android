package me.live.kinamare.api.GithubService.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by kinamare on 2017-04-27.
 */

public class UserInfo implements Serializable{


	@SerializedName("login")
	public String login;
	@SerializedName("id")
	public int id;
	@SerializedName("avatar_url")
	public String avatarUrl;
	@SerializedName("gravatar_id")
	public String gravatarId;
	@SerializedName("url")
	public String url;
	@SerializedName("html_url")
	public String htmlUrl;
	@SerializedName("followers_url")
	public String followersUrl;
	@SerializedName("following_url")
	public String followingUrl;
	@SerializedName("gists_url")
	public String gistsUrl;
	@SerializedName("starred_url")
	public String starredUrl;
	@SerializedName("subscriptions_url")
	public String subscriptionsUrl;
	@SerializedName("organizations_url")
	public String organizationsUrl;
	@SerializedName("repos_url")
	public String reposUrl;
	@SerializedName("events_url")
	public String eventsUrl;
	@SerializedName("received_events_url")
	public String receivedEventsUrl;
	@SerializedName("type")
	public String type;
	@SerializedName("site_admin")
	public Boolean siteAdmin;
	@SerializedName("name")
	public String name;
	@SerializedName("company")
	public String company;
	@SerializedName("blog")
	public String blog;
	@SerializedName("location")
	public String location;
	@SerializedName("email")
	public String email;
	@SerializedName("hireable")
	public Object hireable;
	@SerializedName("bio")
	public Object bio;
	@SerializedName("public_repos")
	public Integer publicRepos;
	@SerializedName("public_gists")
	public Integer publicGists;
	@SerializedName("followers")
	public Integer followers;
	@SerializedName("following")
	public Integer following;
	@SerializedName("created_at")
	public String createdAt;
	@SerializedName("updated_at")
	public String updatedAt;

}
