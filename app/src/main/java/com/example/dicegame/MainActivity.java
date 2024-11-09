package com.example.dicegame;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;

    private TextView kostka1;
    private TextView kostka2;
    private TextView kostka3;
    private TextView kostka4;
    private TextView kostka5;

    private TextView wynik_losowania;
    private TextView wynik_gry;
    private TextView liczba_rzutow;

    private int sumGry = 0;
    private int liczbaRzutow = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.Button1);
        button2 = findViewById(R.id.Button2);
        kostka1 = findViewById(R.id.kostka1);
        kostka2 = findViewById(R.id.kostka2);
        kostka3 = findViewById(R.id.kostka3);
        kostka4 = findViewById(R.id.kostka4);
        kostka5 = findViewById(R.id.kostka5);
        wynik_losowania = findViewById(R.id.wynik_losowania);
        wynik_gry = findViewById(R.id.wynik_gry);
        liczba_rzutow = findViewById(R.id.liczba_rzutow);

        button1.setOnClickListener(v -> rollDice());
        button2.setOnClickListener(v -> resetGame());
    }

    private void rollDice() {
        Random random = new Random();
        ArrayList<Integer> wynLos = new ArrayList<>();
        int sum = 0;


        for (int i = 0; i < 5; i++) {
            wynLos.add(random.nextInt(6) + 1);
        }


        kostka1.setText(String.valueOf(wynLos.get(0)));
        kostka2.setText(String.valueOf(wynLos.get(1)));
        kostka3.setText(String.valueOf(wynLos.get(2)));
        kostka4.setText(String.valueOf(wynLos.get(3)));
        kostka5.setText(String.valueOf(wynLos.get(4)));

        Log.d("wynik los", wynLos.toString());


        for (int i = 0; i < wynLos.size(); i++) {
            int ilosc = 0;

            for (int j = 0; j < wynLos.size(); j++) {
                if (wynLos.get(i).equals(wynLos.get(j)) && i != j) {
                    ilosc++;
                }
            }

            if (ilosc > 0) {
                Log.d("Powtórzenie:", String.valueOf(wynLos.get(i)));
                sum += wynLos.get(i);
            }
        }

        Log.d("suma:", String.valueOf(sum));

        wynik_losowania.setText("Wynik tego losowania: " + sum);

        sumGry += sum;
        Log.d("suma gry:", String.valueOf(sumGry));

        wynik_gry.setText("Wynik gry: " + sumGry);
        liczbaRzutow++;
        liczba_rzutow.setText("Liczba rzutów: " + liczbaRzutow);


        sum = 0;
    }

    private void resetGame() {
        sumGry = 0;
        liczbaRzutow = 0;
        wynik_losowania.setText("Wynik losowania: 0");
        wynik_gry.setText("Wynik gry: 0");
        liczba_rzutow.setText("Liczba rzutów: 0");
        kostka1.setText("?");
        kostka2.setText("?");
        kostka3.setText("?");
        kostka4.setText("?");
        kostka5.setText("?");
    }
}
