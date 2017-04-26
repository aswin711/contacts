package com.example.cedex.contact;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cedex on 4/20/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "ContactsManager";

    //Create table name

    private static final String TABLE_CONTACTS = "contacts";

    //Create table coloumns

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_number";

    private Context context;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context; //context passed
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create tables here
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_PH_NO + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);

    }

    //let's add a function for basic insertion

    public void insert(Contact contact){    //get Contact object
        //initialise db
        SQLiteDatabase db = this.getWritableDatabase(); //write to database

        //arrange values
        ContentValues values = new ContentValues();
        values.put(KEY_NAME,contact.getName());
        values.put(KEY_PH_NO,contact.getPhone_number());

        //insert it

        db.insert(TABLE_CONTACTS,null,values);

        //Toast after insertion
        //Toast requires a context

        Toast.makeText(context, "Value inserted", Toast.LENGTH_SHORT).show();

        //close db

        db.close();
    }

   //function to fetch all contacts

    public List<Contact> viewAll(){
        SQLiteDatabase db = this.getReadableDatabase();//read from database

        String sqlQuery = "SELECT * FROM "+TABLE_CONTACTS; //this our query to fetch all data from contacts table

        Cursor cursor = db.rawQuery(sqlQuery,null);  //Look what is cursor in java; Here it just takes value in order ie
                                                                //id,name,phonenumber in the sense of it's datatpe
                                                                    //int,String,String

        List<Contact> contactList = new ArrayList<>();  //initialize a List to save content


        while (cursor.moveToNext()){  //Checks whether cursor has some value

            //save each contact separately

            Contact contact = new Contact();
            contact.setId(cursor.getInt(0));  //This is our first coloum ie id of type integer index is zero;0
            contact.setName(cursor.getString(1));  //This is the second coloumn ie name of type text , index is one;1
            contact.setPhone_number(cursor.getString(2));

            //Now add this contact to the list

            contactList.add(contact);

            //Each contact adds up until cursor becomes null
        }

        //return list

        return contactList;  //fetch method is completed  go to viewAcctivity to implement it
    }






}
