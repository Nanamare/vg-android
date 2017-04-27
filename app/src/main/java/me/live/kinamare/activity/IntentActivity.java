package me.live.kinamare.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.live.kinamare.R;

public class IntentActivity extends AppCompatActivity {

	@BindView(R.id.intentJakeTv) AppCompatTextView intentJakeTv;
	@BindView(R.id.intentNanaTv) AppCompatTextView intentNanaTv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intent);

		ButterKnife.bind(this);


	}

	@OnClick({R.id.intentJakeTv,R.id.intentNanaTv})
	void onSomeThingClick(View view){

		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.addCategory(Intent.CATEGORY_DEFAULT);
		intent.addCategory(Intent.CATEGORY_BROWSABLE);

		switch (view.getId()){
			case R.id.intentJakeTv : {
				intent.setData(Uri.parse("testapp://repos/jakewharton"));
				startActivity(intent);
				break;
			}
			case R.id.intentNanaTv : {
				intent.setData(Uri.parse("testapp://repos/nanamare"));
				startActivity(intent);
				break;
			}
		}
	}

}
