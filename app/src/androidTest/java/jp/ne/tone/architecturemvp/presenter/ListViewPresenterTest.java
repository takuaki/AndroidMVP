package jp.ne.tone.architecturemvp.presenter;

import android.content.Context;
import android.test.AndroidTestCase;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import jp.ne.tone.architecturemvp.model.usecase.RepoListUseCase;
import jp.ne.tone.architecturemvp.view.RepoListView;

import static org.mockito.Mockito.verify;

/**
 * Created by mori on 6/16/16.
 */
public class ListViewPresenterTest extends AndroidTestCase {

    private ListViewPresenter listViewPresenter;

    @Mock
    private Context mockContext;
    @Mock
    private RepoListUseCase useCase;
    @Mock
    private RepoListView listView;

    @Override protected void setUp() throws Exception{
        super.setUp();
        MockitoAnnotations.initMocks(this);
        listViewPresenter = new ListViewPresenter(useCase);
        listViewPresenter.setView(listView);
    }

    @Test
    public void testRepoListWhenResume(){
        listViewPresenter.initialize();
        //listViewPresenter.onResume();
        verify(listView).showLoading();
    }


}
