package com.hannah.phrasekeeper.objects;

public class Phrase {
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
