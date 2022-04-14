package com.hannah.phrasekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hannah.phrasekeeper.lib.PhraseDataBase;
import com.hannah.phrasekeeper.objects.Phrase;

public class ViewPhraseActivity extends AppCompatActivity {

    private PhraseDataBase phraseDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_phrase);

        phraseDB = new PhraseDataBase(this);
        phraseDB.open();

        String id = getIntent().getStringExtra("ID");

        Phrase item = phraseDB.getItem(Integer.parseInt(id));
        TextView phraseView = this.findViewById(R.id.phraseView);
        phraseView.setText(item.getPhrase());

        TextView descriptionView = this.findViewById(R.id.descriptionView);
        descriptionView.setText(item.getDescription());

        Button deleteButton = this.findViewById(R.id.phraseDelete);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phraseDB.remove_item(item);
                Intent mainIntent = new Intent(v.getContext(), MainActivity.class);
                startActivity(mainIntent);
            }
        });
    }
}