package cohen.nechama.projectbuild.obj;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by 123 on 20/03/2018.
 */

public class DAO {

    private SQLiteDatabase db;

    public void addMessege(Message m){
        String sql = "INSERT INTO Message(type,date,detailsMessage) VALUES(" +
                "'" + m.getType() +
                "','" + m.getDate() +
                "','" + m.getDetailsMessage() +
                "')";

        db.execSQL(sql);
    }

    private DAO(Context context){
        MessageHelper helper=new MessageHelper(context);
        this.db = helper.getWritableDatabase();
    }

    private static DAO sharedInstance = null;

    public static DAO getInstance(Context context){
        if (sharedInstance==null){
            sharedInstance=new DAO(context);
        }
        return sharedInstance;
    }

    public ArrayList<Message> getMessage(){
        ArrayList<Message> result = new ArrayList<>();
        String sql="SELECT * FROM [Message]";
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();

        do {
            String type = cursor.getString(0);
            String date = cursor.getString(1);
            String detailsMessage = cursor.getString(2);
            result.add(new Message(type, date, detailsMessage));
        }while (cursor.moveToNext());
            cursor.close();
            return result;


    }


}
