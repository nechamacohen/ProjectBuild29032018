package cohen.nechama.projectbuild.obj;

import android.widget.Spinner;

/**
 * Created by hackeru on 26/03/2018.
 */

public class Neighbor {
    private String name;
    private String phone;
    private String build;


    public Neighbor(String name, String phone, String build) {
        this.name = name;
        this.phone = phone;
        this.build = build;
    }

    public Neighbor() {
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getBuild() {
        return build;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    @Override
    public String toString() {
        return "Neighbor{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", build=" + build +
                '}';
    }
}
