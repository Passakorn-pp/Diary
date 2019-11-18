package th.ac.su.diary.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DiaryDao {

    @Query("SELECT * FROM restaurants")
    List<Diary> getAll();

    @Insert
    void insertRestaurants(Diary restaurants);
}
