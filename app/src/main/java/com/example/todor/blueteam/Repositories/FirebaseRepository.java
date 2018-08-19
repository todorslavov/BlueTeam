package com.example.todor.blueteam.Repositories;

import android.os.Build;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;
import java.util.function.Consumer;

public class FirebaseRepository<T> implements Repositoriable<T> {
    private final FirebaseFirestore mDb;
    private final Class<T> mClazz;
    private final String mCollectionName;

    public FirebaseRepository(Class<T> clazz){
        mDb = FirebaseFirestore.getInstance();
        mClazz=clazz;
        mCollectionName= clazz.getSimpleName().toLowerCase()+"s";
    }
    @Override
    public void getAll(Consumer<List<T>> action) {
        mDb.collection(mCollectionName)
                .get()
                .addOnCompleteListener(task-> {
                    List<T> items = task.getResult()
                            .toObjects(mClazz);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        action.accept(items);
                    }
                });

    }

    @Override
    public void add(T item) {

    }
}
