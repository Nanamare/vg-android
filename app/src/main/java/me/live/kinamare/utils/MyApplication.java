package me.live.kinamare.utils;

import android.app.Application;
import android.content.Context;

/**
 * Created by kinamare on 2016-12-17.
 */

public class MyApplication extends Application {

	public static final String TAG = MyApplication.class.getSimpleName();
	private static MyApplication sInstance;

	public static synchronized MyApplication getInstance() {
		if (sInstance != null)
			return sInstance;
		return null;
	}

	public Context getContext() {
		return this.getApplicationContext();
	}


	@Override
	protected void attachBaseContext(Context base) {
		super.attachBaseContext(base);

	}


	@Override
	public void onCreate() {
		super.onCreate();
		sInstance = this;
	}



}
