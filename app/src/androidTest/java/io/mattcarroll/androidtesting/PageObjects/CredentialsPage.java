package io.mattcarroll.androidtesting.PageObjects;

import android.support.annotation.NonNull;

import io.mattcarroll.androidtesting.R;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by anna on 4/10/18.
 */

public class CredentialsPage {


    public CredentialsPage() {
       // verify on the correct page
        onView(withId(R.id.autocompletetextview_email))
                .check(matches(isDisplayed()));
    }


    public CredentialsPage asserHasUserNameError (@NonNull String error){
        onView(withId(R.id.autocompletetextview_email))
                .check(matches(hasErrorText(error)));
        return this;
    }



    public void submit (){
        onView(withId(R.id.button_next))
                .perform(scrollTo(),
                        click()
                );
    }


    public InterestsPage pressBackButton (){
        closeSoftKeyboard();
        pressBack();
        return new InterestsPage();
    }




}
