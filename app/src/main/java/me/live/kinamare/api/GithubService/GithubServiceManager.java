package me.live.kinamare.api.GithubService;


import java.util.List;

import me.live.kinamare.api.GithubService.Model.GitRepository;
import me.live.kinamare.api.GithubService.Model.UserInfo;
import me.live.kinamare.api.ServiceDefine;
import retrofit2.Response;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by kinamare on 2017-04-26.
 */

public final class GithubServiceManager {

	private static final GithubService SERVICE = ServiceDefine.retrofit.create(GithubService.class);

	public static Observable<Response<List<GitRepository>>> getRepoList(String owner){
		return SERVICE.getRepoList(owner)
				.subscribeOn(Schedulers.io());
	}

	public static Observable<Response<UserInfo>> getUserInfo(String owner){
		return SERVICE.getGitUserInfo(owner)
				.subscribeOn(Schedulers.io());
	}
}
