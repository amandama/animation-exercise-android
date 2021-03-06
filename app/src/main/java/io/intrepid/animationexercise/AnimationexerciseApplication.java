package io.intrepid.animationexercise;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import io.intrepid.animationexercise.base.PresenterConfiguration;
import io.intrepid.animationexercise.logging.CrashlyticsReporter;
import io.intrepid.animationexercise.logging.TimberConfig;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class AnimationexerciseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        LeakCanary.install(this);

        CrashlyticsReporter.init(this);

        TimberConfig.init(CrashlyticsReporter.getInstance());
    }

    public PresenterConfiguration getPresenterConfiguration() {
        return new PresenterConfiguration(
                Schedulers.io(),
                AndroidSchedulers.mainThread(),
                CrashlyticsReporter.getInstance()
        );
    }
}
