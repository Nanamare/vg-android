package me.live.kinamare.api.GithubService.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by kinamare on 2017-04-26.
 */

public class GitRepository implements Serializable {


	@SerializedName("id")
	public Integer id;
	@SerializedName("name")
	public String name;
	@SerializedName("full_name")
	public String fullName;
	@SerializedName("owner")
	public Owner owner;
	@SerializedName("private")
	public Boolean _private;
	@SerializedName("html_url")
	public String htmlUrl;
	@SerializedName("description")
	public String description;
	@SerializedName("fork")
	public Boolean fork;
	@SerializedName("url")
	public String url;
	@SerializedName("forks_url")
	public String forksUrl;
	@SerializedName("keys_url")
	public String keysUrl;
	@SerializedName("collaborators_url")
	public String collaboratorsUrl;
	@SerializedName("teams_url")
	public String teamsUrl;
	@SerializedName("hooks_url")
	public String hooksUrl;
	@SerializedName("issue_events_url")
	public String issueEventsUrl;
	@SerializedName("events_url")
	public String eventsUrl;
	@SerializedName("assignees_url")
	public String assigneesUrl;
	@SerializedName("branches_url")
	public String branchesUrl;
	@SerializedName("tags_url")
	public String tagsUrl;
	@SerializedName("blobs_url")
	public String blobsUrl;
	@SerializedName("git_tags_url")
	public String gitTagsUrl;
	@SerializedName("git_refs_url")
	public String gitRefsUrl;
	@SerializedName("trees_url")
	public String treesUrl;
	@SerializedName("statuses_url")
	public String statusesUrl;
	@SerializedName("languages_url")
	public String languagesUrl;
	@SerializedName("stargazers_url")
	public String stargazersUrl;
	@SerializedName("contributors_url")
	public String contributorsUrl;
	@SerializedName("subscribers_url")
	public String subscribersUrl;
	@SerializedName("subscription_url")
	public String subscriptionUrl;
	@SerializedName("commits_url")
	public String commitsUrl;
	@SerializedName("git_commits_url")
	public String gitCommitsUrl;
	@SerializedName("comments_url")
	public String commentsUrl;
	@SerializedName("issue_comment_url")
	public String issueCommentUrl;
	@SerializedName("contents_url")
	public String contentsUrl;
	@SerializedName("compare_url")
	public String compareUrl;
	@SerializedName("merges_url")
	public String mergesUrl;
	@SerializedName("archive_url")
	public String archiveUrl;
	@SerializedName("downloads_url")
	public String downloadsUrl;
	@SerializedName("issues_url")
	public String issuesUrl;
	@SerializedName("pulls_url")
	public String pullsUrl;
	@SerializedName("milestones_url")
	public String milestonesUrl;
	@SerializedName("notifications_url")
	public String notificationsUrl;
	@SerializedName("labels_url")
	public String labelsUrl;
	@SerializedName("releases_url")
	public String releasesUrl;
	@SerializedName("deployments_url")
	public String deploymentsUrl;
	@SerializedName("created_at")
	public String createdAt;
	@SerializedName("updated_at")
	public String updatedAt;
	@SerializedName("pushed_at")
	public String pushedAt;
	@SerializedName("git_url")
	public String gitUrl;
	@SerializedName("ssh_url")
	public String sshUrl;
	@SerializedName("clone_url")
	public String cloneUrl;
	@SerializedName("svn_url")
	public String svnUrl;
	@SerializedName("homepage")
	public Object homepage;
	@SerializedName("size")
	public Integer size;
	@SerializedName("stargazers_count")
	public int stargazersCount;
	@SerializedName("watchers_count")
	public Integer watchersCount;
	@SerializedName("language")
	public String language;
	@SerializedName("has_issues")
	public Boolean hasIssues;
	@SerializedName("has_projects")
	public Boolean hasProjects;
	@SerializedName("has_downloads")
	public Boolean hasDownloads;
	@SerializedName("has_wiki")
	public Boolean hasWiki;
	@SerializedName("has_pages")
	public Boolean hasPages;
	@SerializedName("forks_count")
	public Integer forksCount;
	@SerializedName("mirror_url")
	public Object mirrorUrl;
	@SerializedName("open_issues_count")
	public Integer openIssuesCount;
	@SerializedName("forks")
	public Integer forks;
	@SerializedName("open_issues")
	public Integer openIssues;
	@SerializedName("watchers")
	public Integer watchers;
	@SerializedName("default_branch")
	public String defaultBranch;

	public static class Owner implements Serializable{

		@SerializedName("login")
		public String login;
		@SerializedName("id")
		public Integer id;
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

	}

}
