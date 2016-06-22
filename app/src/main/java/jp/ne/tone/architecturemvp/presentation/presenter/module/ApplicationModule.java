package jp.ne.tone.architecturemvp.presentation.presenter.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import jp.ne.tone.architecturemvp.data.executor.JobExecutor;
import jp.ne.tone.architecturemvp.data.net.GitHubApi;
import jp.ne.tone.architecturemvp.data.net.GitHubApiImpl;
import jp.ne.tone.architecturemvp.data.repository.GitHubDataRepository;
import jp.ne.tone.architecturemvp.domain.executor.PostExecutionThread;
import jp.ne.tone.architecturemvp.domain.executor.ThreadExecutor;
import jp.ne.tone.architecturemvp.domain.repository.GitHubRepository;
import jp.ne.tone.architecturemvp.presentation.view.MyApp;
import jp.ne.tone.architecturemvp.presentation.view.executor.UiThread;

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
    GitHubApi provideGitHubApi(GitHubApiImpl gitHubApi) {
        return gitHubApi;
    }

    @Singleton
    @Provides
    GitHubRepository provideGitHubRepository(GitHubDataRepository repository) {
        return repository;
    }

    @Singleton
    @Provides
    PostExecutionThread providePostExecutionThread(UiThread uiThread) {
        return uiThread;
    }

    @Singleton
    @Provides
    ThreadExecutor provideThreadExecutor(JobExecutor executor) {
        return executor;
    }


}
