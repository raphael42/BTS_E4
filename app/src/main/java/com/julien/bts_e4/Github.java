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
public class Github extends Fragment {
    private Button btn;
    private View rootViews;
    public Github() {
        // constructeur public vide obligatoire
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         rootViews = inflater.inflate(R.layout.fragment_btn_github, container, false);
        initBtn();
        return rootViews;
    }
    public void initBtn(){
        btn = (Button) rootViews.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GithubListActivity.class);
                startActivity(intent);
            }
        });
    }
}


