package me.live.kinamare.api.GithubService;


import java.util.List;

import me.live.kinamare.api.GithubService.Model.GitRepository;
import me.live.kinamare.api.GithubService.Model.UserInfo;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;


/**
 * Created by kinamare on 2017-04-26.
 */

public interface GithubService {

	@GET("/users/{owner}/repos")
	Observable<Response<List<GitRepository>>> getRepoList(
			@Path("owner") String owner);

	@GET("/users/{owner}")
	Observable<Response<UserInfo>> getGitUserInfo(
			@Path("owner") String owner);

}
