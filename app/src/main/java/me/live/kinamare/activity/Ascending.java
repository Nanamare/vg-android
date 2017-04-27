package me.live.kinamare.activity;

import java.util.Comparator;

import me.live.kinamare.api.GithubService.Model.GitRepository;

/**
 * Created by kinamare on 2017-04-27.
 */

public class Ascending implements Comparator<GitRepository> {
	@Override
	public int compare(GitRepository o1, GitRepository o2) {
		if (o1.stargazersCount > o2.stargazersCount) {
			return -1;
		} else if (o1.stargazersCount < o2.stargazersCount) {
			return 1;
		} else {
			return 0;
		}
	}
}
