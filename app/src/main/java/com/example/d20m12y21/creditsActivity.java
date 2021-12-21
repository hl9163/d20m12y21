package com.example.d20m12y21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class creditsActivity extends AppCompatActivity {
    /**
     * @author		Harel Leibovich <address @ example.com>
     * @version	1.0 (current version number of program)
     * @since		21/12/2021 (the date of the package the class was added)
     * credits screen
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
    }
    /**
     * return the the first activity.
     * <p>
     *
     */
    public void returnFistAc(View view) {
        finish();
    }
}