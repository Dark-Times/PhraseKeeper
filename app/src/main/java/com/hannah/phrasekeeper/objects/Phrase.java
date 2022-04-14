package com.hannah.phrasekeeper.objects;

import android.app.ListActivity;

public class Phrase extends ListActivity {
    private String Phrase;
    private String Description;
    private Integer Id;

    private void init(String phrase, String description) {
        setPhrase(phrase);
        setDescription(description);
    }

    public Phrase(String phrase, String description) {
        init(phrase, description);
    }

    public Phrase(String phrase, String description, Integer id) {
        setId(id);
        init(phrase, description);
    }

    public void setPhrase(String phrase) {
        Phrase = phrase;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getPhrase() {
        return Phrase;
    }

    public String getDescription() {
        return Description;
    }

    public Integer getId() {
        return Id;
    }
}
