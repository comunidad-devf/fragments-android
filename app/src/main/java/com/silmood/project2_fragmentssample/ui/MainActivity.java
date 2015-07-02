package com.silmood.project2_fragmentssample.ui;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.silmood.project2_fragmentssample.R;
import com.silmood.project2_fragmentssample.ui.domain.Pokemon;
import com.silmood.project2_fragmentssample.ui.fragment.MainFragment;


public class MainActivity extends AppCompatActivity implements MainFragment.OnFragmentInteractionListener {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(LOG_TAG, "onCreate()");
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null){
            setupMainFragment();
        }

    }

    private void setupMainFragment(){
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, MainFragment.getInstance(new ColorDrawable(Color.CYAN)))
                .commit();
    }

    @Override
    public void onInteraction(Pokemon pokemon) {
        Snackbar.make(getWindow().getDecorView(), pokemon.toString(), Snackbar.LENGTH_SHORT).show();
    }
}
