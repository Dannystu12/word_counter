package com.example.danielstewart.wordcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button countWordsBtn;
    private TextView resultsTextView;
    private EditText inputEditTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countWordsBtn = findViewById(R.id.count_btn);
        resultsTextView =findViewById(R.id.results_txt);
        inputEditTextView = findViewById(R.id.input_edit_txt);

        countWordsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countWords(v);
            }
        });
    }

    public void countWords(View v){
        //int count = WordCounter.countWords(inputEditTextView.getText().toString());
        final HashMap<String, Integer> counts = WordCounter.getCountsMap(inputEditTextView.getText().toString());
        StringBuilder sb = new StringBuilder();


        List<String> index = new ArrayList<>(counts.keySet());

        Collections.sort(index, new Comparator<String>() {

            public int compare(String w1, String w2) {
                return counts.get(w2) - counts.get(w1);
            }
        });


        for(String word : index){
            sb.append(word);
            sb.append(": ");
            sb.append(counts.get(word));
            sb.append("\n");
        }

        resultsTextView.setText(sb.toString());
    }

}
