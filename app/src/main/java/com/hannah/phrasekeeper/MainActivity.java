package com.hannah.phrasekeeper;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.hannah.phrasekeeper.lib.Database;
import com.hannah.phrasekeeper.objects.Phrase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

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
        //Database db = new Database();
        //List<Phrase> phrases = db.fetch_phrases();
        ArrayList<Phrase> phraseList = new ArrayList<Phrase>();
        phraseList.add(new Phrase("Help Me", "Me1"));
        phraseList.add(new Phrase("Help Me1", "Me1"));
        phraseList.add(new Phrase("Help Me1", "Me1"));
        phraseList.add(new Phrase("Help Me1", "Me1"));
        phraseList.add(new Phrase("Help Me1", "Me1"));
        phraseList.add(new Phrase("Help Me1", "Me1"));

        try {
            CustomListViewAdapter<Phrase> arrayAdapter = new CustomListViewAdapter<>(this, phraseList);
            list_of_phrases.setAdapter(arrayAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}