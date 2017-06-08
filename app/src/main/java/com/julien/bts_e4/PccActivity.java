package com.julien.bts_e4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Antoine on 14/05/2017.
 */

public class PccActivity extends Fragment {
    public int var_a = 0;
    public int var_b = 0;
    private Button ciseaux;
    private Button papier;
    private Button pierre;
    private Button stat;
    private TextView res;
    private TextView ordi;
    private TextView resultat;
    private String random;
    private String rep;
    View rootView;
    // Utilisation de la bibliothèque Fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.jeux, container, false);
        initJeux();
        jeux();
        return rootView;
    }
    private void initJeux(){
        ciseaux = (Button) rootView.findViewById(R.id.btn_ciseaux);
        papier = (Button) rootView.findViewById(R.id.btn_papier);
        pierre = (Button) rootView.findViewById(R.id.btn_pierre);
        stat = (Button) rootView.findViewById(R.id.btn_résultats);

        res = (TextView) rootView.findViewById(R.id.tv_joueur_1);
        ordi = (TextView) rootView.findViewById(R.id.tv_joueur_2);
        resultat = (TextView) rootView.findViewById(R.id.tv_résultat);

    }
    private void jeux(){
        ciseaux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res.setText("Ciseaux");
                Random choix = new Random();
                int a = choix.nextInt(3);
                if (a == 1) {
                    rep = "Ciseaux";
                } else {
                    if (a == 2){
                        rep = "Pierre";
                    }else{
                        rep = "Papier";
                    }
                }
                ordi.setText(rep);
                if (rep.equals("Ciseaux")) {
                    random = "Egalité";
                } else {
                    if (rep.equals("Pierre")){
                        random = "L'ordinateur à gagné";
                        var_b=var_b+1;
                    }else{
                        random = "Le joueur à gagné";
                        var_a=var_a+1;
                    }

                }
                resultat.setText(random);


            }
        });
        pierre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res.setText("Pierre");
                Random choix = new Random();
                int a = choix.nextInt(3);
                if (a == 1) {
                    rep = "Ciseaux";
                } else {
                    if (a == 2){
                        rep = "Pierre";
                    }else{
                        rep = "Papier";
                    }
                }
                ordi.setText(rep);
                if (rep.equals("Pierre")) {
                    random = "Egalité";
                } else {
                    if (rep.equals("Papier")){
                        random = " L'ordinateur à gagné";
                        var_b=var_b+1;

                    }else{
                        random = "Le joueur à gagné";
                        var_a=var_a+1;
                    }
                }
                resultat.setText(random);
            }
        });
        papier.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          res.setText("Papier");
                                          Random choix = new Random();
                                          int a = choix.nextInt(3);
                                          if (a == 1) {
                                              rep = "Ciseaux";
                                          } else {
                                              if (a == 2){
                                                  rep = "Pierre";
                                              }else{
                                                  rep = "Papier";
                                              }
                                          }
                                          ordi.setText(rep);
                                          if (rep.equals("Papier")) {
                                              random = "Égalité";
                                          } else {
                                              if (rep.equals("Ciseaux")){
                                                  random = " L'ordinateur à gagné";
                                                  var_b=var_b+1;
                                              }else{
                                                  random = "Le joueur à gagné";
                                                  var_a=var_a+1;
                                              }
                                          }
                                          resultat.setText(random);
                                      }
                                  }
        );
        /*
        stat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), jeux2.class);
                intent.putExtra("var_a", var_a);
                intent.putExtra("var_b", var_b);

                startActivity(intent);
                //startActivity(new Intent(MainActivity.this, SecondActivity.class));

            }
        });*/


    }

}