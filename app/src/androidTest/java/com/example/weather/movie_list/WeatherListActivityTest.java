package com.example.weather.movie_list;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import com.example.weather.R;

import junit.extensions.ActiveTestSuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

public class WeatherListActivityTest {

    @Rule
    public ActivityTestRule<WeatherListActivity> mActivityTestRule = new ActivityTestRule<WeatherListActivity>(WeatherListActivity.class);

    private WeatherListActivity mActivity =null;
    //Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor()
    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){
        View view = mActivity.findViewById(R.id.button1);
        assertNotNull(view);
    }


    @After
    public void tearDown() throws Exception {
       mActivity=null;
    }
}