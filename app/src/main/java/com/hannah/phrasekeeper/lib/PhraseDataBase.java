package com.hannah.phrasekeeper.lib;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.hannah.phrasekeeper.objects.Phrase;

import java.util.ArrayList;

public class PhraseDataBase implements IDatabase<Phrase> {
    private static final String DATABASE_NAME = "PhraseDataBase";
    private static final int DATABASE_VERSION = 5;

    private static final String TBNAME = "Phrases";
    public static final String COL_PHRASE_NAME = "phrase_name";
    public static final String COL_DESCRIPTION_NAME = "description_name";

    private SQLiteDatabase mDb;
    private final Context mCtx;


    public PhraseDataBase(Context ctx) {
        this.mCtx = ctx;
    }

    /**
     * DatabaseHelper class.
     *
     * Database helper class to manage connections with the database.
     */
    private static class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String crtsql = "CREATE TABLE If NOT EXISTS " + TBNAME + "(" +
                    COL_PHRASE_NAME + " VARCHAR(100) " + "," + COL_DESCRIPTION_NAME + " VARCHAR(100) " +
                    ")";
            //primary key is auto created for us
            db.execSQL(crtsql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TBNAME);
            onCreate(db);
        }
    }

    public synchronized SQLiteDatabase open(){
        if (mDb == null) {
            DatabaseHelper mDbHealper = new DatabaseHelper(mCtx);
            mDb = mDbHealper.getReadableDatabase();
        }
        return mDb;
    }

    public void close(){
        mDb = null;
    }

    @Override
    public boolean add_item(Phrase phrase) {
        String query = String.format("INSERT INTO `Phrases` (`"+COL_PHRASE_NAME+"`, `"+COL_DESCRIPTION_NAME+"`) Values(\"%s\",\"%s\");", phrase.getPhrase(), phrase.getDescription());

        try {
            mDb.execSQL(query);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean remove_item(Phrase phrase) {
        try {
            mDb.execSQL("DELETE FROM 'Phrase' WHERE rowid =" + phrase.getId());
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<Phrase> fetch_phrases() {
        Cursor resultSet = mDb.rawQuery("Select rowid, "+COL_PHRASE_NAME+", "+COL_DESCRIPTION_NAME+" from Phrases", null);

        ArrayList<Phrase> phrases = new ArrayList<>();
        while (resultSet.moveToNext()) {
            String phrase = resultSet.getString(resultSet.getColumnIndex(COL_PHRASE_NAME));
            String description = resultSet.getString(resultSet.getColumnIndex(COL_DESCRIPTION_NAME));
            Integer id = resultSet.getInt(resultSet.getColumnIndex("rowid"));
            phrases.add(new Phrase(phrase, description, id));
        }

        if (phrases.isEmpty()) {
            phrases.add(new Phrase("No Phrases Exist", ""));
        }

        return phrases;
    }
}
