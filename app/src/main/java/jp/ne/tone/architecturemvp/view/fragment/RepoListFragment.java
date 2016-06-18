package jp.ne.tone.architecturemvp.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import jp.ne.tone.architecturemvp.R;
import jp.ne.tone.architecturemvp.model.GitHubModel;
import jp.ne.tone.architecturemvp.presenter.ListViewPresenter;
import jp.ne.tone.architecturemvp.presenter.component.FragmentComponent;
import jp.ne.tone.architecturemvp.presenter.module.FragmentModule;
import jp.ne.tone.architecturemvp.view.RepoListView;
import jp.ne.tone.architecturemvp.view.RepoView;
import jp.ne.tone.architecturemvp.view.activity.RepoListActivity;
import jp.ne.tone.architecturemvp.view.util.EspressoIdingResource;

/**
 * Created by tmori on 2016/06/13.
 */
public class RepoListFragment extends ListFragment  implements RepoListView{

    /**
     * Interface for listening user event
     */
    public interface RepoListListener{
        void onRepoClicked(final GitHubModel model);
    }

    private static final String TAG = RepoListFragment.class.getSimpleName();
    private FragmentComponent fragmentComponent;
    private RepoListListener repoListListener;


    @Bind(R.id.progressBar)
    ProgressBar progressBar;

    @Inject
    ListViewPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        fragmentComponent = ((RepoListActivity)getActivity()).getComponent().newFragmentComponent(
                new FragmentModule());
        fragmentComponent.inject(this);
        presenter.setView(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_list,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof RepoListActivity){
            repoListListener= ((RepoListListener)context);
        }
    }

    //lifecycle
    @Override
    public void onResume(){
        EspressoIdingResource.increment();
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onPause(){
        super.onPause();
        presenter.onPause();
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        presenter.onDestroy();
    }

    /**
     * レポジトリ一覧を見せる。
     * @param mapList
     */
    @Override
    public void showRepositories(List<Map<String, String>> mapList) {
        for(Map<String,String> map:mapList){
            Log.d(TAG,map.get(RepoView.KEY_DESC));
        }
        SimpleAdapter adapter = new SimpleAdapter(getActivity(),mapList,android.R.layout.simple_expandable_list_item_2
        ,new String[]{RepoView.KEY_NAME,RepoView.KEY_DESC},new int[]{android.R.id.text1,android.R.id.text2});
        setListAdapter(adapter);
        //hideLoading();
        //Espresso waiting
        EspressoIdingResource.decrement();
    }

    /**
     * ローディング画面
     */
    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    /**
     * ローディング消す
     */
    @Override
    public void hideLoading(){
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showRepoDetails(GitHubModel model){
        Log.d(TAG,"showRepoDetails");
        if(repoListListener==null) return;
        repoListListener.onRepoClicked(model);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Log.d(TAG,"onListItemClick  position "+position+" repoListListener null? "+(repoListListener==null));
        ListAdapter adapter = l.getAdapter();
        GitHubModel model = (GitHubModel)adapter.getItem(position);
        presenter.onClickRepo(model);
    }
}
