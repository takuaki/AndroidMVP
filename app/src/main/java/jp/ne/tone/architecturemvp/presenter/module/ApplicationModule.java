package jp.ne.tone.architecturemvp.presenter.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import jp.ne.tone.architecturemvp.MyApp;
import jp.ne.tone.architecturemvp.data.executor.JobExecutor;
import jp.ne.tone.architecturemvp.data.repositories.GitHubRepository;
import jp.ne.tone.architecturemvp.data.service.GitHubService;
import jp.ne.tone.architecturemvp.data.service.GitHubServiceImpl;
import jp.ne.tone.architecturemvp.domain.Repositories;
import jp.ne.tone.architecturemvp.domain.executor.PostExecutionThread;
import jp.ne.tone.architecturemvp.domain.executor.ThreadExecutor;
import jp.ne.tone.architecturemvp.view.UIThread;

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

    @Singleton
    @Provides
    PostExecutionThread providePostExecutionThread(UIThread uiThread){
        return uiThread;
    }

    @Singleton
    @Provides
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return  jobExecutor;
    }

    @Singleton
    @Provides
    Repositories provideGitHubFetch(GitHubRepository gitHubRepository){
        return gitHubRepository;
    }
}
