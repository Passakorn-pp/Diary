package th.ac.su.diary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

import th.ac.su.diary.adapter.RecyclerViewAdapter;
import th.ac.su.diary.db.Diary;
import th.ac.su.diary.db.DiaryRepository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonAdd = findViewById(R.id.addDiary_button);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InsertActivity.class);
                intent.putExtra("type", 0);
                startActivity(intent);
            }
        });

    }
    protected void onResume () {
        super.onResume();
        reloadData();
    }
    private void reloadData(){
        DiaryRepository repo = new DiaryRepository(MainActivity.this);

        repo.getDiary(new DiaryRepository.Callback() {
            @Override
            public void onGetLedger(List<Diary> itemList) {

                RecyclerView recyclerView = findViewById(R.id.recyclerView);
                RecyclerViewAdapter adapter = new RecyclerViewAdapter(
                        MainActivity.this,
                        R.layout.item_diary,
                        itemList
                );
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(adapter);
            }
        });
    }
}
