package com.hannah.phrasekeeper.lib;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.hannah.phrasekeeper.objects.Phrase;

import java.io.File;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private String db_name = "/data/data/com.hannah.phrasekeeper/local_storage";
    private SQLiteDatabase database;

    public Database() {
        create();
    }

    public void add_new(Phrase phrase) {
        String query = String.format("INSERT INTO `Phrases` (`Phrase`, `Description`) Values(\"%s\",\"%s\");", phrase.getPhrase(), phrase.getDescription());
        database.execSQL(query);
    }

    public ArrayList<Phrase> fetch_phrases() {
        Cursor resultSet = database.rawQuery("Select * from Phrases", null);

        ArrayList<Phrase> phrases = new ArrayList<>();
        while (resultSet.moveToNext()) {
            String phrase = resultSet.getString(resultSet.getColumnIndex("Phrase"));
            String description = resultSet.getString(resultSet.getColumnIndex("Description"));
            Integer id = resultSet.getInt(resultSet.getColumnIndex("Id"));
            phrases.add(new Phrase(phrase, description, id));
        }

        return phrases;
    }

    public void delete_phrase(Phrase phrase) {

    }

    private void create() {
        //SQLiteDatabase.deleteDatabase(new File(db_name));
        database = SQLiteDatabase.openOrCreateDatabase(db_name, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS Phrases(Phrase VARCHAR(100),Description VARCHAR(100), Id integer primary key);");
    }
}
