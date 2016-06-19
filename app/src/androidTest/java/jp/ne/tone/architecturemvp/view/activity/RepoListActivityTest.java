package jp.ne.tone.architecturemvp.view.activity;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.test.suitebuilder.annotation.MediumTest;

import org.hamcrest.Description;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Map;

import jp.ne.tone.architecturemvp.R;
import jp.ne.tone.architecturemvp.view.RepoView;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.not;


/**
 * Created by mori on 6/18/16.
 */
@MediumTest
@RunWith(AndroidJUnit4.class)
public class RepoListActivityTest {

    @Rule
    public ActivityTestRule<RepoListActivity> mActivityRule =
            new ActivityTestRule<>(RepoListActivity.class);

    //@Before
    //public void registerIdlingResource(){
    //Espresso.registerIdlingResources(mActivityRule.getActivity().getCountingForIdlingResource());
    //}

    //@After
    //public void unregisterIdlingResource(){
//        Espresso.unregisterIdlingResources(mActivityRule.getActivity().getCountingForIdlingResource());
//    }

    @Ignore
    public void test() {
        RepoListActivity activity = mActivityRule.getActivity();
        FragmentManager manager = activity.getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragmentContainer);
        assertThat(fragment, is(not(null)));
    }

    @Test
    public void testContainsRepoListFragment() {
        Espresso.onView(ViewMatchers.withId(R.id.fragmentContainer)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void testShowRepoList() {
        RepoListActivity activity = mActivityRule.getActivity();
        //Idling 開始
        Espresso.registerIdlingResources(activity.getCountingForIdlingResource());
        // (AndroidMVP)
        Espresso.onData(matcher).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        //Idling 終了
        Espresso.unregisterIdlingResources(activity.getCountingForIdlingResource());

    }

    private BoundedMatcher<Object, Map> matcher = new BoundedMatcher<Object, Map>(Map.class) {
        private final String itemTextMatcher = "AndroidMVP";

        @Override
        protected boolean matchesSafely(Map item) {
            return hasEntry(equalTo(RepoView.KEY_NAME), itemTextMatcher).matches(item);
        }

        @Override
        public void describeTo(Description description) {
            description.appendText("with item context:");
        }
    };

}
