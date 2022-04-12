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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public MainActivity() {
//        Database db = new Database();
////        Phrase test = new Phrase("Help me", "I'm trapped in here");
////        Phrase test1 = new Phrase("Help me", "I'm trapped in here4");
////        Phrase test2 = new Phrase("Help me", "I'm trapped in here2");
////        db.add_new(test);
////        db.add_new(test1);
////        db.add_new(test2);
//        List<Phrase> phrases = db.fetch_phrases();
//        System.out.println(phrases);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListView list_of_phrases = (ListView) findViewById(R.id.list_of_phrases);
        Database db = new Database();
        List<Phrase> phrases = db.fetch_phrases();
        List<String> items = new ArrayList<>();
        for (Phrase phrase : phrases) {
            items.add(phrase.getPhrase());
        }

        // I dunno why this shit isn't working - even the sodding simplified string-only list examples online don't work here
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this, R.id.list_of_phrases, items);
        list_of_phrases.setAdapter(arrayAdapter);

        FloatingActionButton fab = findViewById(R.id.add_new_phrase);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}