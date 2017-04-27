package me.live.kinamare.activity;

import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.widget.ListView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.live.kinamare.R;
import me.live.kinamare.adapter.RepoAdapter;
import me.live.kinamare.api.GithubService.GithubService;
import me.live.kinamare.api.GithubService.GithubServiceManager;
import me.live.kinamare.api.GithubService.Model.GitRepository;
import me.live.kinamare.api.GithubService.Model.UserInfo;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {

	@BindView(R.id.gitUserImage) AppCompatImageView gitUserIv;
	@BindView(R.id.gitUserName) AppCompatTextView gitUserTv;
	@BindView(R.id.gitRepoLv) ListView gitRepoLv;

	private List<GitRepository> gitRepoList;
	private RepoAdapter adapter;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

		gitRepoList = new ArrayList<>();
		adapter = new RepoAdapter(this, gitRepoList);
		gitRepoLv.setAdapter(adapter);

		Uri data = getIntent().getData();
		if(data != null) {
			String hostName = data.getLastPathSegment();
			reqeustGitUserApi(hostName);
			reqeustGitRepoApi(hostName);
		}




	}

	private void reqeustGitUserApi(String hostName) {
		GithubServiceManager.getUserInfo(hostName)
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Subscriber<Response<UserInfo>>() {
					@Override
					public void onCompleted() {

					}

					@Override
					public void onError(Throwable e) {

					}

					@Override
					public void onNext(Response<UserInfo> userInfoResponse) {
						setUserInfo(userInfoResponse.body());
					}
				});
	}

	private void setUserInfo(UserInfo userInfo) {

		Glide.with(this)
				.load(userInfo.avatarUrl)
				.placeholder(new ColorDrawable(this.getResources().getColor(R.color.black_7)))
				.into(gitUserIv);

		gitUserTv.setText(userInfo.name);

	}

	private void reqeustGitRepoApi(String hostName) {

		GithubServiceManager.getRepoList(hostName)
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Subscriber<Response<List<GitRepository>>>() {
					@Override
					public void onCompleted() {

					}

					@Override
					public void onError(Throwable e) {
						e.printStackTrace();
					}

					@Override
					public void onNext(Response<List<GitRepository>> contributorResponse) {
						gitRepoList = contributorResponse.body();
						setGitRepoList(gitRepoList);
					}
				});
	}

	private void setGitRepoList(List<GitRepository> gitRepoList) {
//		정렬 만들것
// 		adapter.descendingSort(gitRepoList);
		adapter.setGitRepositoryList(gitRepoList);
		adapter.notifyDataSetChanged();
	}

}
