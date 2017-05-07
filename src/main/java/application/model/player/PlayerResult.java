package application.model.player;

/**
 * Created by Transfet on 2017. 05. 07..
 */
public class PlayerResult {

    private String username;
    private Double point;
    private Double time;

    public PlayerResult(String name, Double point, Double time){
        this.username = name;
        this.point = point;
        this.time = time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getTime() {

        return time;
    }

    public Double getPoint() {
        return point;
    }

    public String getUsername() {
        return username;
    }
}
