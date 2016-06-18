package jp.ne.tone.architecturemvp.presenter;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import jp.ne.tone.architecturemvp.model.GitHubModel;
import jp.ne.tone.architecturemvp.model.usecase.RepoListUseCase;
import jp.ne.tone.architecturemvp.view.RepoListView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

/**
 * Created by mori on 6/18/16.
 */
public class ListViewPresenterTest {

    private ListViewPresenter listViewPresenter;

    @Mock
    private RepoListView listView;
    @Mock
    private RepoListUseCase useCase;
    @Mock
    private Context context;

    private String fakeRepo = "repo";

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        listViewPresenter = new ListViewPresenter(useCase);
        listViewPresenter.setView(listView);
    }

    @Test
    public void testLoadView() {
        listViewPresenter.initialize();
        verify(listView).showLoading();
        verify(useCase).execute(any(callBack.getClass()));
    }

    @Test
    public void testClickRepo(){
        GitHubModel model = getFakeGitHubModel();
        listViewPresenter.onClickRepo(model);
        verify(listView).showRepoDetails(any(GitHubModel.class));
    }

    private GitHubModel getFakeGitHubModel(){
        GitHubModel fakeModel = new GitHubModel();
        String id = "1";
        String description ="fakeRepository";
        String name = "fake";
        fakeModel.setId(id);
        fakeModel.setDescription(description);
        fakeModel.setName(name);
        return fakeModel;
    }

    /**
     * 単なるClass型をとるため
     */
    Callback<List<GitHubModel>> callBack = new Callback<List<GitHubModel>>() {
        @Override
        public void onResponse(Call<List<GitHubModel>> call, Response<List<GitHubModel>> response) {

        }

        @Override
        public void onFailure(Call<List<GitHubModel>> call, Throwable t) {

        }
    };


}
