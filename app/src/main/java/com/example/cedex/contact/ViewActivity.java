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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);


        viewText = (TextView) findViewById(R.id.viewText);

        databaseHandler = new DatabaseHandler(this);

        List<Contact> contactList = databaseHandler.viewAll();

       String data = "";

        for(Contact contact: contactList){
            data += contact.getId()+"           "+contact.getName()+"         "+contact.getPhone_number()+"\n";

        }

        viewText.setText(data);


    }
}
