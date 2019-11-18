package th.ac.su.diary.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Database;

import th.ac.su.diary.db.Diary;

import java.util.List;

import th.ac.su.diary.db.MyDatabase;

public class DiaryRepository {

    private Context mContext;

    public DiaryRepository(Context mContext) {
        this.mContext = mContext;
    }

    public void getDiary(Callback callback) {
        GetTask getTask = new GetTask(mContext, callback);
        getTask.execute();
    }

    public void insertRestautants(Diary item, InsertCallback callback) {
        InsertTask insertTask = new InsertTask(mContext, callback);
        insertTask.execute(item);
    }

    private static class GetTask extends AsyncTask<Void, Void, List<Diary>> {

        private Context mContext;
        private Callback mCallback;

        public GetTask(Context context, Callback callback) {
            this.mContext = context;
            this.mCallback = callback;
        }

        @Override
        protected List<Diary> doInBackground(Void... voids) {
            MyDatabase db = MyDatabase.getInstance(mContext);
            List<Diary> itemList = db.DiaryDao().getAll();
            return itemList;
        }

        @Override
        protected void onPostExecute(List<Diary> DiaryItemList) {
            super.onPostExecute(DiaryItemList);

            mCallback.onGetLedger(DiaryItemList);
        }
    } // ปิด GetTask

    public interface Callback {
        void onGetLedger(List<Diary> itemList);
    }

    private static class InsertTask extends AsyncTask<Diary, Void, Void> {

        private Context mContext;
        private InsertCallback mCallback;

        public InsertTask(Context context, InsertCallback callback) {
            this.mContext = context;
            this.mCallback = callback;
        }

        @Override
        protected Void doInBackground(Diary... ledgerItems) {
            MyDatabase db = MyDatabase.getInstance(mContext);
            db.DiaryDao().insertRestaurants(ledgerItems[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mCallback.onInsertSuccess();
        }
    } // ปิด InsertTask

    public interface InsertCallback {
        void onInsertSuccess();
    }


}
