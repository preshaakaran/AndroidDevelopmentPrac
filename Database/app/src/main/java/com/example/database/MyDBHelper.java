package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ContactsDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_CONTACT = "contacts";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE_NO = "phone_no";


    public MyDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);//OR directly write 1 instead of database_version
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //CREATE TABLE contacts(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phone_no TEXT);
        db.execSQL("CREATE TABLE " + TABLE_CONTACT +
                "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_NAME + " TEXT, " + KEY_PHONE_NO + " TEXT " + ")");

//        SQLiteDatabase database = this.getWritableDatabase();
//        database.update(KEY_ID, KEY_NAME, KEY_PHONE_NO);
        //insert,update,execute,rawquery
//        database.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACT);
        onCreate(db);

    }

    //INSERT
    public void addContact(String name, String phone_no) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_PHONE_NO, phone_no);
        db.insert(TABLE_CONTACT, null, values);

    }

    //SELECT
    public ArrayList<ContactModel> fetchContacts() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_CONTACT, null);
        ArrayList<ContactModel> arrContacts = new ArrayList<>();

        while (cursor.moveToNext()) {
            ContactModel contact = new ContactModel();
            contact.id = cursor.getInt(0);
            contact.name = cursor.getString(1);
            contact.phone_no = cursor.getString(2);

            arrContacts.add(contact);

        }

        return arrContacts;
    }

    public void updateContact(ContactModel contactModel){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contactModel.name);
        values.put(KEY_PHONE_NO, contactModel.phone_no);
//        database.update(TABLE_CONTACT, values, KEY_ID + " = ?", new String[]{String.valueOf(contactModel.id)});
        database.update(TABLE_CONTACT, values, KEY_ID + " = "+contactModel.id, null );

    }

    public void deleteContact(int id){
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(TABLE_CONTACT, KEY_ID + " = ?", new String[]{String.valueOf(id)});
    }





}
