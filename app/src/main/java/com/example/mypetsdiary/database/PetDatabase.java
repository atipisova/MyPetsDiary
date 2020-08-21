package com.example.mypetsdiary.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.mypetsdiary.database.entities.Pet;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Pet.class}, version = 1, exportSchema = false)
public abstract class PetDatabase extends RoomDatabase {
    private static volatile PetDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static PetDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PetDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = buildDatabase(context);
                }
            }
        }
        return INSTANCE;
    }

    @NotNull
    private static PetDatabase buildDatabase(@NotNull final Context context) {
        return Room.databaseBuilder(context.getApplicationContext(),
                PetDatabase.class,
                "my-pet_database")
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                            @Override
                            public void run() {
                               // getDatabase(context).categoryDao().insertAll(PetDatabase.populateData());
                            }
                        });
                    }
                })
                .build();
    }
}
