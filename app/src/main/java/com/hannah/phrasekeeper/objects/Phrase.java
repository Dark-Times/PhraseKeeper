package com.hannah.phrasekeeper.objects;

import android.app.ListActivity;

public class Phrase extends ListActivity {
    private String Phrase;
    private String Description;

    public Phrase(String phrase, String description) {
        setPhrase(phrase);
        setDescription(description);
    }

    public void setPhrase(String phrase) {
        Phrase = phrase;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPhrase() {
        return Phrase;
    }

    public String getDescription() {
        return Description;
    }
}
