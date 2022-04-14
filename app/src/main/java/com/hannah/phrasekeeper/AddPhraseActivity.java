package com.hannah.phrasekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hannah.phrasekeeper.lib.PhraseDataBase;
import com.hannah.phrasekeeper.objects.Phrase;

import java.sql.SQLException;

public class AddPhraseActivity extends AppCompatActivity {
    private PhraseDataBase phreaseDB;

    public AddPhraseActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_phrase);

        phreaseDB = new PhraseDataBase(this);
        phreaseDB.open();
        
        Button addButton = (Button)findViewById(R.id.phraseAddButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPhrase();
            }
        });
    }

    private void addPhrase() {
        EditText phraseContent = (EditText)findViewById(R.id.addPhraseContent);
        EditText descriptionContent = (EditText)findViewById(R.id.addDescriptionContent);
        Phrase phrase = new Phrase(phraseContent.getText().toString(), descriptionContent.getText().toString());
        phreaseDB.add_item(phrase);
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
    }
}