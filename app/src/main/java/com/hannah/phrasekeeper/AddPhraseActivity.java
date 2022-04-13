package com.hannah.phrasekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hannah.phrasekeeper.lib.Database;
import com.hannah.phrasekeeper.objects.Phrase;

public class AddPhraseActivity extends AppCompatActivity {
    private final Database db;

    public AddPhraseActivity(Database dbConnectionClass) {
        db = dbConnectionClass;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_phrase);

        Button addButton = (Button)findViewById(R.id.phraseAddButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPhrase();
            }
        });
    }

    private boolean addPhrase() {
        EditText phraseContent = (EditText)findViewById(R.id.addPhraseContent);
        EditText descriptionContent = (EditText)findViewById(R.id.addDescriptionContent);
        Phrase phrase = new Phrase(phraseContent.toString(), descriptionContent.toString());
        try {
            db.add_new(phrase);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
}