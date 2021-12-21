package com.example.d20m12y21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/**
 * @author		Harel Leibovich <address @ example.com>
 * @version	1.0 (current version number of program)
 * @since		21/12/2021 (the date of the package the class was added)
 * main program
 */
public class MainActivity extends AppCompatActivity {
    TextView tvCounter;
    EditText nameInput;

    String name = "";
    int count = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvCounter = (TextView) findViewById(R.id.showPoints);
        nameInput = (EditText) findViewById(R.id.name);


    }
    /**
     * load the name and count from saving when the program start.
     * <p>
     */
    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences settings=getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
        count = settings.getInt("count",-1);
        name = settings.getString("name","Error");
        if (count != -1 && !name.equals("Error")){
            tvCounter.setText(String.valueOf(count));
            nameInput.setText(name);
            Log.i("MainActivity","work");
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity","destroyed");
    }
    /**
     * save data when the user leave the app
     * <p>
     */
    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences settings=getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
        name = nameInput.getText().toString();
        SharedPreferences.Editor editor=settings.edit();
        editor.putInt("count",count);
        editor.putString("name",name);
        editor.commit();
    }
    /**
     * add 1 to count valuable.
     * <p>
     *
     * @param	view Description	button.
     */
    public void add(View view) {
        count++;
        tvCounter.setText(String.valueOf(count));
    }
    /**
     * reset the count valuable to 0.
     * <p>
     *
     * @param	view Description	button.
     */
    public void rest(View view) {
        count = 0;
        tvCounter.setText(String.valueOf(count));
    }
    /**
     * exit app.
     * <p>
     *
     * @param	view Description	button.
     */
    public void exitApp(View view) {
        finish();
    }
    /**
     * create the menu.
     * <p>
     *
     */
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    /**
     * move to the credits activity.
     * <p>
     *
     */
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.cridits1){
            Intent si = new Intent(this, creditsActivity.class);
            startActivity(si);
        }
        return true;
    }



}