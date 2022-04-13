package com.hannah.phrasekeeper.lib;

import com.hannah.phrasekeeper.objects.Phrase;

public class DBPhrase extends Database {
    private Phrase currentPhrase;

    public DBPhrase(Phrase phrase) { setPhrase(phrase); }

    public void commit() {
        add_new(currentPhrase);
    }

    public void delete() { delete_phrase(currentPhrase); }

    private void setPhrase(Phrase phrase) {
        currentPhrase = phrase;
    }
}
