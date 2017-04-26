package com.example.cedex.contact;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.stetho.Stetho;

public class MainActivity extends AppCompatActivity {

    private DatabaseHandler databaseHandler;

    //Initialise insert button
    private Button insert;
    private Button view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Stetho.initializeWithDefaults(this);  //now run ur application
        //this is my new table now open google chrome browser
        //all datas are visible in google inspect


        //Now create a listview to display the contacts with name
        //reference: https://www.tutorialspoint.com/android/android_list_view.htm

        //Go to ViewActivity


        databaseHandler = new DatabaseHandler(this);

        insert = (Button) findViewById(R.id.insertButton);

        view = (Button) findViewById(R.id.viewButton);


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,InsertActivity.class);
                startActivity(intent);  //Okay application runs smoothly

                //Next we can setup view so go to main activity
            }
        });


        //Create a viewActivity to display contacts

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start new activity here

                Intent intent = new Intent(MainActivity.this,ViewActivity.class);
                startActivity(intent);


            }
        });

        //make a dummy contact

        //Contact contact = new Contact(1,"Ram","+123456789");

        //insert it

        //databaseHandler.insert(contact);



    }


    //create new Activity called InsertActivity
}
