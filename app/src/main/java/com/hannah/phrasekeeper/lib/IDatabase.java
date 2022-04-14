package com.hannah.phrasekeeper.lib;

import com.hannah.phrasekeeper.objects.Phrase;

import java.util.ArrayList;

public interface IDatabase<T extends Phrase> {
    boolean add_item(T phrase);
    boolean remove_item(T phrase);
    T getItem(int id);
    ArrayList<T> fetch_phrases();
}
