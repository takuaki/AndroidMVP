package jp.ne.tone.architecturemvp.presenter.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import jp.ne.tone.architecturemvp.MyApp;
import jp.ne.tone.architecturemvp.data.executor.JobExecutor;
import jp.ne.tone.architecturemvp.data.repository.GitHubDataRepository;
import jp.ne.tone.architecturemvp.domain.executor.PostExecutionThread;
import jp.ne.tone.architecturemvp.domain.executor.ThreadExecutor;
import jp.ne.tone.architecturemvp.domain.repository.GitHubRepository;
import jp.ne.tone.architecturemvp.model.service.GitHubService;
import jp.ne.tone.architecturemvp.model.service.GitHubServiceImpl;
import jp.ne.tone.architecturemvp.view.executor.UiThread;

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
    GitHubRepository provideGitHubRepository(GitHubDataRepository repository){
        return repository;
    }

    @Singleton
    @Provides
    PostExecutionThread providePostExecutionThread(UiThread uiThread){
        return uiThread;
    }

    @Singleton
    @Provides
    ThreadExecutor provideThreadExecutor(JobExecutor executor){
        return executor;
    }
}
