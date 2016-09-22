package com.hive9.worklist;

import android.content.ContentValues;
import android.content.Context;
import android.content.SearchRecentSuggestionsProvider;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by hIVE9 on 04/08/2016.
 */
public class UserDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "USERINFO.DB";
    private static final int DATABASE_VERSION = 4;
    private static final String CREATE_QUERY =
            "CREATE TABLE "+UserContract.NewUserInfo.TABLE_NAME+"("+ UserContract.NewUserInfo.USER_NAME+" TEXT,"+
                    UserContract.NewUserInfo.USER_DEVICE+" TEXT,"+ UserContract.NewUserInfo.USER_REPAIR+" TEXT,"+
                    UserContract.NewUserInfo.USER_STATUS+" TEXT,"+ UserContract.NewUserInfo.USER_PRIORITY+" TEXT,"+
                    UserContract.NewUserInfo.USER_BOOKED+" TEXT);";

    public UserDbHelper(Context context)
    {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS","Database created / opened...");

    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS","Table Created...");
    }

    public void addInformations(String name, String device,String repair,String status,String priority,String booked, SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();

        contentValues.put(UserContract.NewUserInfo.USER_NAME,name);
        contentValues.put(UserContract.NewUserInfo.USER_DEVICE,device);
        contentValues.put(UserContract.NewUserInfo.USER_REPAIR,repair);
        contentValues.put(UserContract.NewUserInfo.USER_STATUS,status);
        contentValues.put(UserContract.NewUserInfo.USER_PRIORITY,priority);
        contentValues.put(UserContract.NewUserInfo.USER_BOOKED,booked);

        db.insert(UserContract.NewUserInfo.TABLE_NAME,null,contentValues);
        Log.e("DATABASE OPERATIONS","One row inserted...");

    }

    public Cursor GetInformations(SQLiteDatabase db)
    {
        Cursor cursor;
        String[] projections = {UserContract.NewUserInfo.USER_NAME,UserContract.NewUserInfo.USER_DEVICE,
                UserContract.NewUserInfo.USER_REPAIR,UserContract.NewUserInfo.USER_STATUS,UserContract.NewUserInfo.USER_PRIORITY,
                UserContract.NewUserInfo.USER_BOOKED};
        cursor= db.query(UserContract.NewUserInfo.TABLE_NAME, projections,null,null,null,null,null);
        return cursor;
    }

    public Cursor getContact(String user_name,SQLiteDatabase sqLiteDatabase){

        String[] projections = {UserContract.NewUserInfo.USER_DEVICE, UserContract.NewUserInfo.USER_REPAIR,
                UserContract.NewUserInfo.USER_STATUS,UserContract.NewUserInfo.USER_PRIORITY,UserContract.NewUserInfo.USER_BOOKED};
        //How to search
        String selection = UserContract.NewUserInfo.USER_NAME+" LIKE ?";
        String[] selection_arg = {user_name};
        Cursor cursor = sqLiteDatabase.query(UserContract.NewUserInfo.TABLE_NAME,projections,selection,selection_arg,null,null,null);
        return cursor;


    }

    public int updateInformation(String old_name,String new_name, String new_device, String new_repair, String new_status, String new_priority,
                                 String new_booked, SQLiteDatabase sqLiteDatabase)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserContract.NewUserInfo.USER_NAME,new_name);
        contentValues.put(UserContract.NewUserInfo.USER_DEVICE,new_device);
        contentValues.put(UserContract.NewUserInfo.USER_REPAIR,new_repair);
        contentValues.put(UserContract.NewUserInfo.USER_STATUS,new_status);
        contentValues.put(UserContract.NewUserInfo.USER_PRIORITY,new_priority);
        contentValues.put(UserContract.NewUserInfo.USER_BOOKED,new_booked);
        String selection = UserContract.NewUserInfo.USER_NAME+" LIKE ?";
        String[] selection_arg = {old_name};
        int count = sqLiteDatabase.update(UserContract.NewUserInfo.TABLE_NAME,contentValues,selection,selection_arg);
        return count;


    }

    public void deleteInformation(String user_name,SQLiteDatabase sqLiteDatabase)
    {
        String selection = UserContract.NewUserInfo.USER_NAME+" LIKE ?";
        String[] selection_arg = {user_name};
        sqLiteDatabase.delete(UserContract.NewUserInfo.TABLE_NAME,selection,selection_arg);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {

    }
}
