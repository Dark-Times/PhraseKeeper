package com.hannah.phrasekeeper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hannah.phrasekeeper.objects.Phrase;

import java.util.ArrayList;

public class CustomListViewAdapter<T extends Phrase> extends BaseAdapter {
    private final ArrayList<T> phraseArrayList;
    private final Context mContext;

    public CustomListViewAdapter(Context applicationContext, ArrayList<T> listOfPhrases) throws Exception {
        if (listOfPhrases == null) {
            throw new Exception("Phrase List Can't be null");
        }
        //copy this so that it is immutable inside the class
        this.phraseArrayList = new ArrayList<>(listOfPhrases);
        this.mContext = applicationContext;
    }

    @Override
    public int getCount() {
        return phraseArrayList.size();
    }

    @Override
    public T getItem(int position) {
        return phraseArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(mContext);
            v = vi.inflate(R.layout.list_view, null);
        }

        T item = getItem(position);
        TextView phrase = v.findViewById(R.id.textView);
        TextView description = v.findViewById(R.id.textView2);
        phrase.setText(item.getPhrase());
        description.setText(item.getDescription());
        return v;
    }
}
