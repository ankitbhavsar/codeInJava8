package fastcode.model;

public class SmartPhone {
    private SmartPhoneType type;
    private int screensize;
    private boolean waterproof;
    private String osversion;

    private SmartPhone() {
    }

    public SmartPhone(SmartPhoneType type, int screensize, boolean waterproof, String osversion) {
        this.type = type;
        this.screensize = screensize;
        this.waterproof = waterproof;
        this.osversion = osversion;
    }

    public SmartPhoneType getType() {
        return type;
    }

    public void setType(SmartPhoneType type) {
        this.type = type;
    }

    public int getScreensize() {
        return screensize;
    }

    public void setScreensize(int screensize) {
        this.screensize = screensize;
    }

    public boolean isWaterproof() {
        return waterproof;
    }

    public void setWaterproof(boolean waterproof) {
        this.waterproof = waterproof;
    }

    public String getOsversion() {
        return osversion;
    }

    public void setOsversion(String osversion) {
        this.osversion = osversion;
    }

    @Override
    public String toString() {
        return "SmartPhone{" +
                "type=" + type +
                ", screensize=" + screensize +
                ", waterproof=" + waterproof +
                ", osversion='" + osversion + '\'' +
                '}';
    }

}
