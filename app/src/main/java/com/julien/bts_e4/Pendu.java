package com.julien.bts_e4;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Pendu extends Fragment {
    Button jeuPendu;

    View rootViews;

    public Pendu() {
        // constructeur public vide obligatoire
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootViews = inflater.inflate(R.layout.jeux, container, false);
        game();
        return rootViews;
    }


    public void game() {
        jeuPendu = (Button) rootViews.findViewById(R.id.btn_pendu);
        // Création de la logique d'un bouton
        jeuPendu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Demarrage d'une nouvelle Activity qui a été déclaré dans le Manifest
                Intent intent = new Intent(getActivity(), PenduActivity.class);
                startActivity(intent);
            }
        });


    }
}
