package com.julien.bts_e4;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Contact extends Fragment {


    public Contact() {
        // Constructeur public vide obligatoire
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_away, container, false);
        // Collection d'emails
        String[] email = {
                "julienhivert.tt@gmail.com",
                "petervalery211@gmail.com",
                "dimitriguira@gmail.com",
                "benjamin.96.prost@gmail.com",
                "jose.santiago42400@gmail.com",
                "jordanjayol42@gmail.com",
                "kelignoel42@gmail.com",
                "jimmyseux@gmail.com",
                "raphael.bellon42@gmail.com",
                "chloe.bouet42@gmail.com",
                "denis.peyrelon@gmail.com",
                "fanny.lartaud42@gmail.com",
                "gauthierclementsw@gmail.com",
                "guillaume.brunet4242@gmail.com",
                "jeremiebrison@gmail.com",
                "jdufourt20@gmail.com",
                "batotanaomi@gmail.com",
                "sabrina.benzeghadi.tstmg1@gmail.com",
                "sarah.galichon@gmail.com",
                "sylvain.montana42210@gmail.com",
                "ymoreau42@gmail.com",
        };

        ListView lv = (ListView) view.findViewById(R.id.listView2);

        ArrayAdapter<String> lva = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1, email);
        lv.setAdapter(lva);

        final SwipeRefreshLayout mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.fragment_away);

        mSwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        ((MainActivity) getActivity()).refreshNow();
                        Toast.makeText(getContext(), "Refresh Layout working", Toast.LENGTH_LONG).show();
                    }
                }
        );

        return view;
    }
}
