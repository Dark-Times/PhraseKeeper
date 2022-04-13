package com.hannah.phrasekeeper;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hannah.phrasekeeper.lib.Database;
import com.hannah.phrasekeeper.objects.Phrase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListView list_of_phrases = (ListView) findViewById(R.id.list_of_phrases);
        Database db = new Database();
        ArrayList<Phrase> phraseList = db.fetch_phrases();

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
    }

    public void addPhraseIntent(View view) {
        Intent addPhraseIntent = new Intent(this, AddPhraseActivity.class);
        startActivity(addPhraseIntent);
    }
}