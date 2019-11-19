package th.ac.su.diary.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import th.ac.su.diary.DetailActivity;
import th.ac.su.diary.R;
import th.ac.su.diary.db.Diary;

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.MyViewHolder> {
    private Context mContext;
    private int mResource;
    private List<Diary> mRestaurantsList;

    public RecyclerViewAdapter2(Context mContext, int mResource, List<Diary> mRestaurantsList) {
        this.mContext = mContext;
        this.mResource = mResource;
        this.mRestaurantsList = mRestaurantsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(mResource, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Diary diary= mRestaurantsList.get(position);

        holder.diary = diary;
        holder.NameTextView.setText(diary.name);
        holder.ImageDirary.setImageResource(R.drawable.book1);

    }

    @Override
    public int getItemCount() {
        return mRestaurantsList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView ImageDirary;
        private TextView NameTextView;
        private Diary diary;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.ImageDirary = itemView.findViewById(R.id.Diary_imageView);
            this.NameTextView = itemView.findViewById(R.id.Name_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, DetailActivity.class);
                    intent.putExtra("name", diary.name);
                    intent.putExtra("type",diary.type);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}