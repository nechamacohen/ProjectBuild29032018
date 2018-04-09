package cohen.nechama.projectbuild.obj;

/**
 * Created by 123 on 21/03/2018.
 */

public class Contant {
    private String name;
    private String address;
    private String phone;
    private int image;

    public Contant(String name, String address, String phone, int image) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.image = image;
    }

    public Contant() {
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Contant{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", image=" + image +
                '}';
    }
}
