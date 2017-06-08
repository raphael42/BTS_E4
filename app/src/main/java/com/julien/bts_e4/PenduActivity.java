package com.julien.bts_e4;
import android.support.v7.app.AppCompatActivity;


import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.random;

public class PenduActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout container;
    private Button btn_send;
    private TextView lettres_tapees;
    private TextView score;
    private ImageView image;
    private EditText et_letter;
    private String word;
    private int found;
    private int error;
    private List<Character> ListofLetters = new ArrayList<>();
    private boolean win;
    private List<String> wordList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pendu);

        container = (LinearLayout) findViewById(R.id.world_container);
        btn_send = (Button) findViewById(R.id.btn_send);
        et_letter = (EditText) findViewById(R.id.et_letter);
        image = (ImageView) findViewById(R.id.iv_pendu);
        lettres_tapees = (TextView) findViewById(R.id.tv_lettres_tapees);
        score = (TextView) findViewById(R.id.tv_score);
        initGame();

        btn_send.setOnClickListener(this);
    }

    public void initGame() {

        //word = generateWord();

        word = generateWord();
        win = false;
        error = 0;
        found = 0;
        lettres_tapees.setText("");
        image.setBackgroundResource(R.drawable.first);
        ListofLetters = new ArrayList<>();

        container.removeAllViews();

        for (int i = 0; i < word.length(); i++) {
            TextView oneLetter = (TextView) getLayoutInflater().inflate(R.layout.textview, null);
            container.addView(oneLetter);
        }
    }

    @Override
    public void onClick(View v) {
        String letterFromInput = et_letter.getText().toString().toUpperCase();
        et_letter.setText("");
        int point =0;

        if (letterFromInput.length() > 0) {
            if (!letterAlreadyUsed(letterFromInput.charAt(0), ListofLetters)) {
                ListofLetters.add(letterFromInput.charAt(0));
                checkIfLetterInWord(letterFromInput, word);
            }
            // La partie est gagnée
            if (found == word.length()) {
                win = true;
                Toast.makeText(getApplicationContext(), "Victoire, +10 points !", Toast.LENGTH_SHORT).show();
                point += 10;
                initGame();

            }

            // La lettre n'est pas dans le mot
            if (!word.contains(letterFromInput)) {
                error++;

            }
            setImage(error);
            if (error == 6) {
                win = false;
                Toast.makeText(getApplicationContext(), "PERDU, le mot était : "+ word, Toast.LENGTH_SHORT).show();
                initGame();

            }

            //Affichage des lettres entrées
            showAllLetters(ListofLetters);

        }

    }

    public boolean letterAlreadyUsed(char a, List<Character> listOfLetters) {

        for (int i = 0; i < listOfLetters.size(); i++) {

            if (listOfLetters.get(i) == a) {
                Toast.makeText(getApplicationContext(), "Vous avez déjà entré cette lettre", Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        return false;
    }

    public void checkIfLetterInWord(String letter, String world) {

        for (int i = 0; i < word.length(); i++) {
            if (letter.equals(String.valueOf(word.charAt(i)))) {
                TextView tv = (TextView) container.getChildAt(i);
                tv.setText((String.valueOf(word.charAt(i))));
                found++;
            }
        }

    }

    public void showAllLetters(List<Character> ListOfLetters) {
        String chaine = "";

        for (int i = 0; i < ListofLetters.size(); i++) {
            chaine += ListOfLetters.get(i) + "\n";
        }
        if (!chaine.equals("")) {
            lettres_tapees.setText(chaine);
        }
    }

    public void setImage(int error) {
        switch (error) {
            case 1:
                image.setBackgroundResource(R.drawable.second);
                break;
            case 2:
                image.setBackgroundResource(R.drawable.third);
                break;
            case 3:
                image.setBackgroundResource(R.drawable.fourth);
                break;
            case 4:
                image.setBackgroundResource(R.drawable.fifth);
                break;
            case 5:
                image.setBackgroundResource(R.drawable.sixth);
                break;
            case 6:
                image.setBackgroundResource(R.drawable.seventh);
                break;

        }
    }

    public void creatDialog(boolean win) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Vous avez gagné !");

        if (!win) {
            builder.setTitle("Vous avez perdu !");
            builder.setMessage("Le mot à trouver était :" + word);
        }
        builder.setPositiveButton(getResources().getString(R.string.rejouer), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                initGame();

            }
        });

        builder.create().show();
    }

    public List<String> getListOfWords() {


        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(getAssets().open("pendu_list.txt")));
            String Line;
            while ((Line = buffer.readLine()) != null) {
                wordList.add(Line);

            }
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordList;
    }

    public String generateWord(){
        String wordList[] = {"INFORMATIQUE", "DEVELOPPEMENT", "ORDINATEUR","RESEAU", "INFRASTRUCTURE", "CONCEPTION"};
        Random rand = new Random();
        int nb = 0 + rand.nextInt(5 - 0);
        String word = wordList[nb];
        return word;


        // wordList = getListOfWords();
        //int random = (int) Math.random() = wordList.size();
        // String word = wordList.get(random).trim();
        // return word;
    }

}