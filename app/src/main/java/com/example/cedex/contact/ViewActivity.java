package com.example.cedex.contact;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;

public class ViewActivity extends AppCompatActivity {

    private TextView viewText;
    private DatabaseHandler databaseHandler;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        listView = (ListView) findViewById(R.id.listview);


        databaseHandler = new DatabaseHandler(this);

        List<Contact> contactList = databaseHandler.viewAll();

       //We are going to display contact in a listview

        //We have to initialize an array adapter

        //we have a problem here
        // arrayadapter can handle only string
        //contact list is a list of contacts
        //So we have to define an array of string which holds contact name only


        //initialize string array
        String[] contactnames = new String[contactList.size()];

        //Now define an iterator, that iterates over each conatct in the list

        Iterator<Contact> iterator = contactList.iterator();
        int i = 0;
        while (iterator.hasNext()){
            Contact contact = iterator.next();

            //store contact name to array
            contactnames[i++] = contact.getName();
        }

        //Check whether we have go the string array

        Log.d("check",contactnames.toString()); //Logging values in android monitor

        //hence we have got some value which is encoded , now pass the string array to adapter

        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.activity_view,contactnames);

        //the layout must contain only textview


        //attach adapter with listview

        listView.setAdapter(adapter);

        //So we have to implement viewAllContacts in databasehandler
    }
}
