package cohen.nechama.projectbuild.obj;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 123 on 21/03/2018.
 */

public class MessageHelper extends SQLiteOpenHelper {
    public MessageHelper(Context context) {
        super(context, "Message", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createSqlMessegeTable = "CREATE TABLE Message(" +
                "type TEXT," +
                "date TEXT," +
                "detailsMessage TEXT" +
                ")";
        db.execSQL(createSqlMessegeTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
