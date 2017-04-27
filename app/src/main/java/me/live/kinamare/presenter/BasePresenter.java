package me.live.kinamare.presenter;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by kinamare on 2016. 9. 8..
 * mvp[model , view, presenter] pattern lifecycle manager
 */
public class BasePresenter implements IBasePresenter {

	protected CompositeSubscription subscriptions;
	protected boolean active;

	public BasePresenter() {
		subscriptions = new CompositeSubscription();
		active = true;
	}


	protected void addSubscription(Subscription subscription) {
		if (subscriptions != null) {
			subscriptions.add(subscription);
		}
	}

	@Override
	public void destroy() {
		active = false;
		if (subscriptions != null) {
			subscriptions.unsubscribe();
		}
	}

	@Override
	public void resume() {
		subscriptions = new CompositeSubscription();
		active = true;
	}
}
