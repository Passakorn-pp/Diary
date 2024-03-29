package th.ac.su.diary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import th.ac.su.diary.db.Diary;
import th.ac.su.diary.db.DiaryRepository;

public class InsertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        Intent intent = getIntent();

        Button addButton = findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nameText = findViewById(R.id.add_Name);
                String name = nameText.getText().toString();

                EditText descriptionText = findViewById(R.id.add_Detail);
                String type = descriptionText.getText().toString();


                Diary diary = new Diary(0,name,type);

                DiaryRepository repo = new DiaryRepository(InsertActivity.this);
                repo.insertDiary(diary, new DiaryRepository.InsertCallback() {
                    @Override
                    public void onInsertSuccess() {
                        finish();
                    }
                });
            }
        });

    }
}
