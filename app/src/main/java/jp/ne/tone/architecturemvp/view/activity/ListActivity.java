package jp.ne.tone.architecturemvp.view.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import jp.ne.tone.architecturemvp.R;
import jp.ne.tone.architecturemvp.view.fragment.ListViewFragment;

/**
 * Created by tmori on 2016/06/13.
 */
public class ListActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        ListViewFragment viewFragment = new ListViewFragment();

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction =  manager.beginTransaction();
        transaction.add(R.id.fragmentContainer,viewFragment);
        transaction.commit();
    }

}
