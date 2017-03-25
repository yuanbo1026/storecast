package de.code.challenge.view.activity;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.code.challenge.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by bo.yuan on 2017/3/25
 */
@RunWith(AndroidJUnit4.class)
public class ImageSearchActivityTest {

    @Rule
    public ActivityTestRule<ImageSearchActivity> mActivityRule = new ActivityTestRule<>(ImageSearchActivity.class);

    @Test
    public void imageRecyclerView_should_display_on_activity_init() {
        onView(withId(R.id.image_recyclerview)).check(matches(isDisplayed()));
    }

    @Test
    public void alertDialog_should_display_when_click_recyclerview_item(){
        onView(withId(R.id.image_recyclerview))
                .perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));
        onView(withId(android.R.id.button1)).check(matches(isDisplayed()));
    }

    @Test
    public void image_recyclerview_should_display_when_search_new_phrase(){
        onView(withId(R.id.search_edit_text)).perform(typeText("water"));
        onView(withId(R.id.search_confirm_button)).perform(click());
        onView(withId(R.id.image_recyclerview)).check(matches(isDisplayed()));
        onView(withId(R.id.image_recyclerview))
                .perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));
        onView(withId(android.R.id.button1)).check(matches(isDisplayed()));
    }



}