package cohen.nechama.projectbuild.obj;

import java.io.Serializable;

/**
 * Created by hackeru on 09/04/2018.
 */

public class Committee implements Serializable{

    private String type;
    private String date;
    private String detailsCommittee;

    public Committee(String type, String date, String detailsCommittee) {
        this.type = type;
        this.date = date;
        this.detailsCommittee = detailsCommittee;
    }

    public Committee() {
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public String getDetailsCommittee() {
        return detailsCommittee;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDetailsCommittee(String detailsCommittee) {
        this.detailsCommittee = detailsCommittee;
    }

    @Override
    public String toString() {
        return "Committee{" +
                "type='" + type + '\'' +
                ", date='" + date + '\'' +
                ", detailsCommittee='" + detailsCommittee + '\'' +
                '}';
    }
}
