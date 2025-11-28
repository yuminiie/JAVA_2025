public class SmartlLight {
    boolean isOn = false;
    int brightness = 50;
    String color = "white";
    SmartlLight(boolean isOn, int brightness, String color){
        this.isOn = isOn;
        this.brightness = brightness;
        this.color = color;
    }

    public boolean getOn() {
        return isOn;
    }
    public void setOn(boolean on) {
        isOn = on;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        if(brightness >= 1 && brightness<= 100){
            this.brightness = brightness;
        } else {
            System.out.println("잘못된 밝기 입니다.");
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    void setting(boolean isOn, int brightness, String color){
        this.isOn = isOn;
        this.brightness = brightness;
        this.color = color;
    }
    void toggle(){
        if(getOn() == false){
            isOn = true;
        } else {
            isOn = false;
        }
    }
    String getStatus(){
        return "[전원] : " + isOn + " [밝기] : " + brightness + " [색상] : " + color;
    }
}
