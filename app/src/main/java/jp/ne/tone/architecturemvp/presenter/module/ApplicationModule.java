package jp.ne.tone.architecturemvp.presenter.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import jp.ne.tone.architecturemvp.MyApp;
import jp.ne.tone.architecturemvp.model.service.GitHubService;
import jp.ne.tone.architecturemvp.model.service.GitHubServiceImpl;

/**
 * Created by mori on 6/13/16.
 */
@Module
public class ApplicationModule {

    private final MyApp mApplication;

    public ApplicationModule(MyApp application) {
        mApplication = application;
    }

    @Singleton
    @Provides
    Context provideApplicationContext() {
        return mApplication;
    }

    @Singleton
    @Provides
    GitHubService provideGitHubService(GitHubServiceImpl service) {
        return service;
    }


}
