package jp.ne.tone.architecturemvp.view.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import jp.ne.tone.architecturemvp.view.LoadDataView;

/**
 * Created by tmori on 2016/06/13.
 */
public class ListViewFragment extends ListFragment implements LoadDataView{

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        String[] data = {"a","b","c"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,data);
        setListAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedIntanceState){
        return super.onCreateView(inflater,container,savedIntanceState);

    }

    //View Interaction
    @Override
    public void renderData(){

    }

}
