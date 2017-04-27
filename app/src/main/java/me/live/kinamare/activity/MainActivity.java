package me.live.kinamare.activity;

import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.live.kinamare.R;
import me.live.kinamare.adapter.RepoAdapter;
import me.live.kinamare.api.GithubService.GithubServiceManager;
import me.live.kinamare.api.GithubService.Model.GitRepository;
import me.live.kinamare.api.GithubService.Model.UserInfo;
import me.live.kinamare.utils.Ascending;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity implements AbsListView.OnScrollListener{

	@BindView(R.id.gitRepoLv) ListView gitRepoLv;

	private AppCompatTextView gitUserTv;
	private AppCompatImageView gitUserIv;

	private List<GitRepository> gitRepoList;

	private RepoAdapter adapter;

	private int lastTopResult = 0;

	private LinearLayout userInfoLayout;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

		initListView();
		addHeaderView();

		Uri data = getIntent().getData();
		if(data != null) {
			String hostName = data.getLastPathSegment();
			reqeustGitUserApi(hostName);
			reqeustGitRepoApi(hostName);
		}

	}

	private void addHeaderView() {

		LayoutInflater inflater = getLayoutInflater();
		ViewGroup header = (ViewGroup) inflater.inflate(R.layout.custom_header, gitRepoLv, false);
		gitRepoLv.addHeaderView(header,null,false);
		userInfoLayout = ButterKnife.findById(header,R.id.userInfoll);
		gitUserIv = ButterKnife.findById(header,R.id.gitUserImage);
		gitUserTv = ButterKnife.findById(header,R.id.gitUserName);
		gitRepoLv.setOnScrollListener(this);

	}

	private void initListView() {
		gitRepoList = new ArrayList<>();
		adapter = new RepoAdapter(this);
		gitRepoLv.setAdapter(adapter);

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

		adapter.setGitRepositoryList(descendingSort(gitRepoList));
		adapter.notifyDataSetChanged();

	}

	public List<GitRepository> descendingSort(List<GitRepository> gitRepoList) {
		Ascending ascending = new Ascending();
		Collections.sort(gitRepoList,ascending);
		return gitRepoList;
	}

	@Override
	public void onScrollStateChanged(AbsListView absListView, int i) {

	}

	@Override
	public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCnt, int totalItemCnt) {
		Rect rect = new Rect();
		userInfoLayout.getLocalVisibleRect(rect);
		if(lastTopResult != rect.top){
			lastTopResult = rect.top;
			userInfoLayout.setY((float) (rect.top/2.0));
		}


	}
}
