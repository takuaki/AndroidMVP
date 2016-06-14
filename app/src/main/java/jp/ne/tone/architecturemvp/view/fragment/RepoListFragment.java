package jp.ne.tone.architecturemvp.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.ne.tone.architecturemvp.presenter.ListViewPresenter;
import jp.ne.tone.architecturemvp.presenter.component.FragmentComponent;
import jp.ne.tone.architecturemvp.presenter.module.FragmentModule;
import jp.ne.tone.architecturemvp.view.RepoListView;
import jp.ne.tone.architecturemvp.view.RepoView;
import jp.ne.tone.architecturemvp.view.activity.RepoListActivity;

/**
 * Created by tmori on 2016/06/13.
 */
public class RepoListFragment extends ListFragment  implements RepoListView{

    private static final String TAG = RepoListFragment.class.getSimpleName();

    private FragmentComponent fragmentComponent;

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
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedIntanceState){
        return super.onCreateView(inflater,container,savedIntanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    //lifecycle
    @Override
    public void onResume(){
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


    @Override
    public void showRepositories(List<Map<String, String>> mapList) {
        for(Map<String,String> map:mapList){
            Log.d(TAG,"name:"+map.get("name"));
        }
        SimpleAdapter adapter = new SimpleAdapter(getActivity(),mapList,android.R.layout.simple_expandable_list_item_2
        ,new String[]{RepoView.KEY_NAME,RepoView.KEY_DESC},new int[]{android.R.id.text1,android.R.id.text2});
        setListAdapter(adapter);
    }

    @Override
    public void showLoading() {
        
    }

    public interface Action{
        void clickRepo(int position);
    }

}
