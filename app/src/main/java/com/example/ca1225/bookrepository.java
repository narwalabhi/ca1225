package com.example.ca1225;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.List;

public class bookrepository {

    private bookDAO mbookDAO;
    private static final String TAG = "Repo Log";
    private LiveData<List<book>> mAllbooks;

    bookrepository(Application application){
        bookdatabse database = bookdatabse.getDatabase(application);
        mbookDAO = database.getbookDAO();
        mAllbooks = mbookDAO.getAllPerson();
        Log.d(TAG, "PersonRepository: " + mAllbooks.toString());
    }

    public void insert(book bk){
        new InsertPersonAsynctask(mbookDAO).execute(bk);
    }

    public void update(book bk){
        new UpdatePersonAsynctask(mbookDAO).execute(bk);
    }

    public void delete(book bk){
        new DeletePersonAsyncTask(mbookDAO).execute(bk);
    }

    public void deleteAll(){
        new DeleteAllPerson(mbookDAO).execute();
    }
    LiveData<List<book>> getAllbooks(){
        return  mAllbooks;
    }

    class InsertPersonAsynctask extends AsyncTask<book,Void,Void>{

        bookDAO bookDAO;

        public InsertPersonAsynctask(bookDAO bookDAO) {
            this.bookDAO = bookDAO;
        }

        @Override
        protected Void doInBackground(book... people) {
            bookDAO.addPerson(people[0]);
            return null;
        }
    }

    class UpdatePersonAsynctask extends AsyncTask<book,Void,Void>{

        bookDAO bookDAO;

        public UpdatePersonAsynctask(bookDAO mbookDAO) {
            this.bookDAO = mbookDAO;
        }

        @Override
        protected Void doInBackground(book... people) {
            bookDAO.updatePerson(people[0]);
            return null;
        }
    }

    class DeletePersonAsyncTask extends AsyncTask<book,Void,Void>{

        bookDAO bookDAO;

        public DeletePersonAsyncTask(bookDAO mbookDAO) {
            this.bookDAO = mbookDAO;
        }

        @Override
        protected Void doInBackground(book... people) {
            bookDAO.deletePerson(people[0]);
            return null;
        }
    }

    class DeleteAllPerson extends AsyncTask<Void,Void,Void>{

        bookDAO bookDAO;

        public DeleteAllPerson(bookDAO mpersonDAO) {
            this.bookDAO = mbookDAO;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            bookDAO.deleteAllPerson();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }


}
