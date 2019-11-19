package th.ac.su.diary.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "diary")
public class Diary {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "type")
    public String description;

    public Diary(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }


}

