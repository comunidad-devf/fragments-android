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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.silmood.project2_fragmentssample.R;
import com.silmood.project2_fragmentssample.ui.MainActivity;
import com.silmood.project2_fragmentssample.ui.domain.Pokemon;

import java.util.Random;

/**
 * Created by Pedro Antonio Hernández on 25/06/2015.
 *
 */
public class MainFragment extends Fragment{

    public static final String LOG_TAG = MainFragment.class.getSimpleName();

    Pokemon[] pokemons;

    OnFragmentInteractionListener listener = null;

    private Button btnInteraction;

    private ImageView image;

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

        if(activity instanceof MainActivity)
            setListener((MainActivity) activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupPokemons();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        LinearLayout layout = (LinearLayout) root.findViewById(R.id.fragment_container);
        btnInteraction = (Button) root.findViewById(R.id.btn_interaction);

        btnInteraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    Random randomizer = new Random();
                    listener.onInteraction(pokemons[randomizer.nextInt(3)]);
                }
            }
        });

        image.setImageResource(R.drawable.pokemon);

        //Acceso a los argumentos
        int color = getArguments().getInt("color");
        layout.setBackgroundColor(color);

        return root;
    }

    private void setupPokemons(){
        pokemons = new Pokemon[3];

        pokemons[0] = new Pokemon("Chikorita");
        pokemons[1] = new Pokemon("Raichu");
        pokemons[2] = new Pokemon("Magickarp");
    }

    public void setListener(OnFragmentInteractionListener listener) {
        this.listener = listener;
    }

    /**
     * Interfaz que tendrá que implementar la clase que quiera escuchar los eventos del fragmento
     * */
    public interface OnFragmentInteractionListener{


        void onInteraction(Pokemon pokemon);
    }
}
