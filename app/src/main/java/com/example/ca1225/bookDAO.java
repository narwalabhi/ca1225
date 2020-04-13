package com.example.ca1225;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao

public interface bookDAO {

    @Insert
    void addPerson(book bk);

    @Delete
    void deletePerson(book bk);

    @Update
    void updatePerson(book bk);


    @Query("DELETE FROM book_table")
    void deleteAllPerson();

    @Query("SELECT * FROM book_table")
    LiveData<List<book>> getAllPerson();


}
