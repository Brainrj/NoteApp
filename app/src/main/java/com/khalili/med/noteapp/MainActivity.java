package com.khalili.med.noteapp;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import java.util.List;

import data.NoteItem;
import data.NotesDataSource;

public class MainActivity extends ListActivity {
    private NotesDataSource notesDataSource;
    List<NoteItem> notesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notesDataSource = new NotesDataSource(this);

      // refreshDisplay();
        


    }

    private void refreshDisplay() {
        try {
            notesList = notesDataSource.findAll();
            ArrayAdapter<NoteItem> adapter = new ArrayAdapter<NoteItem>(this, android.R.layout.simple_list_item_1, notesList);
            setListAdapter(adapter);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
