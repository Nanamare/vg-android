package me.live.kinamare.GithubService;

import java.util.List;

import me.live.kinamare.GithubService.Model.Contributor;
import me.live.kinamare.api.ServiceDefine;
import retrofit2.Response;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by kinamare on 2017-04-26.
 */

public final class GithubServiceManager {

	private static final GithubService SERVICE = ServiceDefine.retrofit.create(GithubService.class);

	public static Observable<Response<List<Contributor>>> getContributorList(String owner, String repo){
		return SERVICE.repoContributors(owner, repo)
				.subscribeOn(Schedulers.io());
	}
}
