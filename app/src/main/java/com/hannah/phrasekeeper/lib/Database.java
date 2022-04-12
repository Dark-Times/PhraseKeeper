package com.hannah.phrasekeeper.lib;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.hannah.phrasekeeper.objects.Phrase;

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
        String input = String.format("INSERT INTO Phrases(\"%s\", \"%s\");", phrase.getPhrase(), phrase.getDescription());
        String query = String.format("INSERT INTO `Phrases` (`Phrase`, `Description`) Values(\"%s\",\"%s\");", phrase.getPhrase(), phrase.getDescription());
        database.execSQL(query);
    }

    public List<Phrase> fetch_phrases() {
        Cursor resultSet = database.rawQuery("Select * from Phrases", null);

        List<Phrase> phrases = new ArrayList<>();
        while (resultSet.moveToNext()) {
            String phrase = resultSet.getString(resultSet.getColumnIndex("Phrase"));
            String description = resultSet.getString(resultSet.getColumnIndex("Description"));
            phrases.add(new Phrase(phrase, description));
        }

        return phrases;
    }

    private void create() {
        database = SQLiteDatabase.openOrCreateDatabase(db_name, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS Phrases(Phrase VARCHAR(100),Description VARCHAR(100));");
    }
}
