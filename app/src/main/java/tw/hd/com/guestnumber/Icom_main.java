package tw.hd.com.guestnumber;

public class Icom_main {
    int icon;
    String name;

    public Icom_main() {
    }

    public Icom_main(String name,int icon) {
        this.icon = icon;
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
