package th.ac.su.diary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


            Intent intent = getIntent();
            String name = intent.getStringExtra("name");
            String type = intent.getStringExtra("type");

            TextView nameViewDetail = findViewById(R.id.Detail_Name_Text_View);
            nameViewDetail.setText(name);

            TextView descriptionViewDetail = findViewById(R.id.Detail_text_View);
            descriptionViewDetail.setText(type);



    }
}
