package application.model.player;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Transfet on 2017. 04. 29..
 */

/**
 * This class provides ...
 */
@Entity
public class Player implements Serializable {

    private String userName;
    private String firstName;
    private String lastName;
    private String password ;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double points = 0.0;
    private Double time = 0.0 ;

    /**
     * Create a Player.
     */
    public Player(){

    }

    /**
     *Create a Player with specified parameteres
     * @param userName the name of the player
     * @param firstName the player's first name
     * @param lastName the player's last name
     * @param password the player's password
     * @throws IllegalArgumentException if one of parameteres is empty
     */
    public Player(String userName, String firstName, String lastName, String password){
        if((userName.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || password.isEmpty()))
            throw new IllegalArgumentException();

        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;


    }

    /**
     * Create a Player with specified paramteres.
     * @param userName the name of the player
     * @param point the player's point
     * @param time timme
     */
    public Player(String userName, Double point, Double time){
        this.userName = userName;
        this.points = point;
        this.time = time;
    }

    /**
     * Gets the player's id.
     * @return return the player's id
     */
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

    public Double getPoints() {
        return points;
    }

    public Double getTime() {
        return time;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    public void setTime(Double time) {
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
