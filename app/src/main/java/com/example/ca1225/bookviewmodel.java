package com.example.ca1225;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class bookviewmodel extends AndroidViewModel {
        private bookrepository bkrpstry;
        private LiveData<List<book>> mAllbooks;

        public bookviewmodel(@NonNull Application application) {
            super(application);
            bkrpstry = new bookrepository(application);
            mAllbooks = bkrpstry.getAllbooks();
        }

        LiveData<List<book>> getmAllbooks() {
            return mAllbooks;
        }

        public void insert(book bk) {
            bkrpstry.insert(bk);
        }

        public void update(book bk) {
            bkrpstry.update(bk);
        }

        public void delete(book bk) {
            bkrpstry.delete(bk);
        }

        public void deleteAll() {
            bkrpstry.deleteAll();
        }
}

