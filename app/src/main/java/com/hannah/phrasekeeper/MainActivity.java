package com.hannah.phrasekeeper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hannah.phrasekeeper.lib.PhraseDataBase;
import com.hannah.phrasekeeper.objects.Phrase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private PhraseDataBase phraseDB;

    public MainActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView list_of_phrases = (ListView) findViewById(R.id.list_of_phrases);

        phraseDB = new PhraseDataBase(this);
        phraseDB.open();

        ArrayList<Phrase> phraseList = phraseDB.fetch_phrases();

        FloatingActionButton addPhraseButton = findViewById(R.id.add_new_phrase);

        addPhraseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPhraseIntent(view);
            }
        });

        try {
            CustomListViewAdapter<Phrase> arrayAdapter = new CustomListViewAdapter<>(this, phraseList);
            list_of_phrases.setAdapter(arrayAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }

        list_of_phrases.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                viewPhraseIntent(view);
            }
        });
    }

    public void viewPhraseIntent(View view) {
        Intent viewPhraseIntent = new Intent(this, ViewPhraseActivity.class);
        viewPhraseIntent.putExtra("ID", view.getTag().toString());
        startActivity(viewPhraseIntent);
    }
    public void addPhraseIntent(View view) {
        Intent addPhraseIntent = new Intent(this, AddPhraseActivity.class);
        startActivity(addPhraseIntent);
    }
}