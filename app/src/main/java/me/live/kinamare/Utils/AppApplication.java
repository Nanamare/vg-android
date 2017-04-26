package me.live.kinamare.Utils;

import android.app.Application;
import android.content.Context;



/**
 * Created by nanamare on 2017. 1. 30..
 */
public class AppApplication extends Application {
	private static AppApplication instance;

	@Override
	public void onCreate() {
		super.onCreate();

		this.instance = this;
	}


	public Context getContext() {
		return this.getApplicationContext();
	}

	public static AppApplication getInstance() {
		return instance;
	}
}
