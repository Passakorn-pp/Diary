package th.ac.su.diary.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DiaryDao {

    @Query("SELECT * FROM diary")
    List<Diary> getAll();

    @Insert
    void insertDiary(Diary diary);
}
