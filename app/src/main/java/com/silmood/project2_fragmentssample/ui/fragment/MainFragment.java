package com.silmood.project2_fragmentssample.ui.fragment;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.silmood.project2_fragmentssample.R;

/**
 * Created by Pedro Antonio Hernández on 25/06/2015.
 *
 */
public class MainFragment extends Fragment{

    public static final String LOG_TAG = MainFragment.class.getSimpleName();

    /**
     * Regresar una nueva instancia de la clase {@link MainFragment}
     *
     * @param background color para el background del contenedor principal
     *
     * @return nueva instancia de {@link MainFragment}
     * */
    public static MainFragment getInstance(ColorDrawable background){
        MainFragment fragment = new MainFragment();

        //Bundle construido para pasar argumentos
        Bundle args = new Bundle();
        args.putInt("color", background.getColor());

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        Log.i(LOG_TAG, "onAttach()");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState.containsKey("comprobacion"))
            Log.i(LOG_TAG, savedInstanceState.getString("comprobacion"));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        LinearLayout layout = (LinearLayout) root.findViewById(R.id.fragment_container);

        //Acceso a los argumentos
        int color = getArguments().getInt("color");
        layout.setBackgroundColor(color);

        return root;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("comprobacion", "save instance");
    }
}
