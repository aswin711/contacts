package com.example.cedex.contact;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InsertActivity extends AppCompatActivity {

    private EditText name;
    private EditText phoneNumber;
    private Button insertButton;

    private DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        name = (EditText) findViewById(R.id.insertName);

        //instead of clicking red bulb press Alt+Enter

        phoneNumber = (EditText) findViewById(R.id.insertPhNum);
        insertButton = (Button) findViewById(R.id.insert);

        databaseHandler = new DatabaseHandler(this);

        //When button clicks all values must be binded to a contact object and call the function insert

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get values of name and phone number

                String fetchName = String.valueOf(name.getText());
                String fetchPhoneNumber = String.valueOf(phoneNumber.getText());

                Contact contact = new Contact(); // since contact doen't have a default constructor , we have to create a new one

                contact.setName(fetchName);
                contact.setPhone_number(fetchPhoneNumber);

                insert(contact);   //now create intent in main activity to this activity
            }
        });
    }

    //write a function to insert

    public void insert(Contact contact){
        databaseHandler.insert(contact);
    }
}
