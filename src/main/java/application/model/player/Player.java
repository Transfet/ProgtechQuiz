package application.model.player;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Transfet on 2017. 04. 29..
 */


@Entity
public class Player implements Serializable {

    private String userName = null;
    private String firstName = null;
    private String lastName = null;
    private String password = null;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double points = 0.0;
    private Double time = 0.0;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getPoints() {
        return points;
    }

    public Double getTime() {
        return time;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }


    @Override
    public String toString() {
        return Long.toString(id) + "  " + "{ User name: " + userName + "}" + " {First name: " + firstName + "}" +
                "{Last name: " + lastName + "}" + "{ Password:# " + password.hashCode() + "}"
                + "{ Point: " + Double.toString(points) + "}";
    }
}
