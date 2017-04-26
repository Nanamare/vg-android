package me.live.kinamare.GithubService;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.runner.RunWith;

import java.util.List;

import me.live.kinamare.GithubService.Model.Contributor;
import retrofit2.Response;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.plugins.RxJavaPlugins;
import rx.plugins.RxJavaSchedulersHook;
import rx.schedulers.Schedulers;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by kinamare on 2017-04-26.
 */
@RunWith(AndroidJUnit4.class)
public class Github_InstrumentedTest {

	List<Contributor> contributorList;

	@Before
	public void setup() {

		contributorList = null;

		// Start Current thread
		RxJavaPlugins.getInstance().reset();
		RxJavaPlugins.getInstance().registerSchedulersHook(new RxJavaSchedulersHook() {
			@Override
			public Scheduler getComputationScheduler() {
				return Schedulers.immediate();
			}
		});

	}
	/*
		온라인 기술 면접 사전 네트워크 테스트
	 */
	public void 깃헙_정보_가져오기_테스트(){

			GithubServiceManager.getContributorList("ReactiveX","RxJava")
					.observeOn(AndroidSchedulers.mainThread())
					.subscribe(new Subscriber<Response<List<Contributor>>>() {
						@Override
						public void onCompleted() {

						}

						@Override
						public void onError(Throwable e) {
							e.printStackTrace();
						}

						@Override
						public void onNext(Response<List<Contributor>> contributorResponse) {
								contributorList = contributorResponse.body();
						}
					});

		assertNotNull(contributorList);
		assertTrue(contributorList.size() > 0);

	}

}
