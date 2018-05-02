package com.ik.testablecode;


import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class MainActivityTest {

    Repository mRepository;
    ApiService apiService = mock(ApiService.class);
    MyDatabase database = mock(MyDatabase.class);

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(
            MainActivity.class,
            true,
            false
    );

    @Before
    public void setup() {
        mRepository = Repository.getRepository(apiService, database);

    }

    @Test
    public void testIsFetchedDataShown() {
        String testStr = "Test Data";

        when(apiService.getData()).thenReturn(testStr);
        when(database.getStoredApiValue()).thenReturn(testStr);

        mainActivityActivityTestRule.launchActivity(null);

        onView(withText(testStr)).check(matches(isDisplayed()));
    }
}
