package th.ac.su.diary.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Diary.class}, exportSchema = false, version = 1)
public abstract class MyDatabase extends RoomDatabase {
    private static final String DB_NAME = "restaurants.db";

    public abstract DiaryDao DiaryDao();

    private static MyDatabase mInstance;

    public static synchronized MyDatabase getInstance(Context context) {
        if (mInstance == null) {
            mInstance = Room
                    .databaseBuilder(
                            context.getApplicationContext(),
                            MyDatabase.class,
                            DB_NAME
                    )
                    .build();
        }
        return mInstance;
    }
}
