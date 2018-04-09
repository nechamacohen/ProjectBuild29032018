package cohen.nechama.projectbuild.obj;

import android.widget.EditText;
import android.widget.Spinner;

import java.io.Serializable;

/**
 * Created by 123 on 20/03/2018.
 */

public class Message implements Serializable{


    private String type;
    private String date;
    private String detailsMessage;

    public Message(String type, String date, String detailsMessage) {
        this.type = type;
        this.date = date;
        this.detailsMessage = detailsMessage;
    }

    public Message() {
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public String getDetailsMessage() {
        return detailsMessage;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDetailsMessage(String detailsMessage) {
        this.detailsMessage = detailsMessage;


    }

    @Override
    public String toString() {
        return "Message{" +
                "type='" + type + '\'' +
                ", date='" + date + '\'' +
                ", detailsMessage='" + detailsMessage + '\'' +
                '}';
    }
}
