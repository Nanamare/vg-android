package me.live.kinamare.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.live.kinamare.R;

public class IntentActivity extends AppCompatActivity {

	@BindView(R.id.intentBtn) AppCompatButton intentBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intent);

		ButterKnife.bind(this);

		intentBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.addCategory(Intent.CATEGORY_DEFAULT);
				intent.addCategory(Intent.CATEGORY_BROWSABLE);
				intent.setData(Uri.parse("testapp://repos/nanamare"));
				startActivity(intent);

			}
		});

	}
}
