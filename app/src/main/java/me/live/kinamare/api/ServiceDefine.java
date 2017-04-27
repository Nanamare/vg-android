package me.live.kinamare.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kinamare on 2017-04-26.
 */

public final class ServiceDefine {

	private static final String BASE_URL = "https://api.github.com/";

	private ServiceDefine() {

	}

	public final static Retrofit retrofit = new Retrofit.Builder()
			.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
			.addConverterFactory(GsonConverterFactory.create())
			.baseUrl(BASE_URL)
			.build();

}
