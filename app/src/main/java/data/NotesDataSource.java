package data;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by med on 24/11/2015.
 */
public class NotesDataSource  {

    private static final String PREFKEY = "notes";
    private SharedPreferences sharedPreferences;

    public NotesDataSource (Context context) {
        sharedPreferences = context.getSharedPreferences(PREFKEY, Context.MODE_PRIVATE);
    }

    public List<NoteItem> findAll(){

        Map<String,?> notesMap = sharedPreferences.getAll();

        SortedSet<String> keys = new TreeSet<String>(notesMap.keySet());
        List<NoteItem> noteItemList = new ArrayList<NoteItem>();

        for (String key :keys) {
            NoteItem note = new NoteItem();
            note.setKey(key);
            note.setText((String)notesMap.get(key));
            noteItemList.add(note);
        }



        return noteItemList;
    }


    public boolean update(NoteItem note){

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(note.getKey(), note.getText());
        editor.commit();
        return true;
    }

    public boolean remove(NoteItem note)
    {
        if(sharedPreferences.contains(note.getKey())) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.remove(note.getKey());
            editor.commit();
        }
        return true;
    }


}
