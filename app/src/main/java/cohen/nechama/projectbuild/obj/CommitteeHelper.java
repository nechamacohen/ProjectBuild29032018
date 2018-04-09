package cohen.nechama.projectbuild.obj;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hackeru on 09/04/2018.
 */

public class CommitteeHelper extends SQLiteOpenHelper {


    public CommitteeHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "Committee", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createSqlCommitteeTable = "CREATE TABLE Committee(" +
                "type TEXT," +
                "date TEXT," +
                "detailsCommittee TEXT" +
                ")";
        db.execSQL(createSqlCommitteeTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
