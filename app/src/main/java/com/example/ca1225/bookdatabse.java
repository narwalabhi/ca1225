package com.example.ca1225;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import static java.time.chrono.ThaiBuddhistChronology.INSTANCE;

@Database(entities = {book.class},version = 2,exportSchema =  false)

public abstract class bookdatabse extends RoomDatabase {
        private static volatile bookdatabse INSTANCE;

        public abstract bookDAO getbookDAO();


        public static  bookdatabse
        getDatabase(Context context){
        if(INSTANCE == null){
        synchronized (bookdatabse.class){
        if(INSTANCE == null){
        INSTANCE = Room.databaseBuilder(context.getApplicationContext(),bookdatabse.class,"person_database")
                .fallbackToDestructiveMigration()
                .addCallback(dabasecallback)
                .build();
        }
        }
        }
        return INSTANCE;
        }


        private static RoomDatabase.Callback dabasecallback = new RoomDatabase.Callback(){
    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db){
        super.onCreate(db);
    }
};
        }



