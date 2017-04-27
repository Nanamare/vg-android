package me.live.kinamare.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.live.kinamare.R;
import me.live.kinamare.api.GithubService.Model.GitRepository;

/**
 * Created by kinamare on 2017-04-26.
 */

public class RepoAdapter extends BaseAdapter {

	private Context context;
	private List<GitRepository> gitRepositoryList;

	public RepoAdapter(Context context) {
		this.context = context;
		this.gitRepositoryList = new ArrayList<>();
	}

	@Override
	public int getCount() {
		return gitRepositoryList.size();
	}

	@Override
	public Object getItem(int position) {
		return gitRepositoryList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		final ViewHolder viewHolder;


		if (convertView == null) {

			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.item_git_repo, null);
			viewHolder = new ViewHolder(convertView);
			convertView.setTag(viewHolder);

		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		/*
			set holder
		*/
		viewHolder.gitRepoNameTv.setText(gitRepositoryList.get(position).name);
		viewHolder.gitRepoDescriptionTv.setText(gitRepositoryList.get(position).description);
		viewHolder.gitRepoStarCntTv.setText(String.valueOf(gitRepositoryList.get(position).stargazersCount));

		return convertView;
	}

	public void setGitRepositoryList(List<GitRepository> items) {
		this.gitRepositoryList.clear();
		this.gitRepositoryList = items;
	}


	public static class ViewHolder {

		@BindView(R.id.gitRepoNameTv) AppCompatTextView gitRepoNameTv;

		@BindView(R.id.gitRepoDescriptionTv) AppCompatTextView gitRepoDescriptionTv;

		@BindView(R.id.gitRepoStarCntTv) AppCompatTextView gitRepoStarCntTv;

		public ViewHolder(View view) {
			ButterKnife.bind(this, view);
		}
	}


}
