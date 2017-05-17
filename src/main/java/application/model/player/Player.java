package application.model.player;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A class that represent a player.
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
     * Create a Player with specified parameteres.
     * @param userName the name of the player
     * @param point the player's point
     * @param time
     */
    public Player(String userName, Double point, Double time){
        this.userName = userName;
        this.points = point;
        this.time = time;
    }

    /**
     * Gets the player's id.
     * @return the player's id
     */
    public Long getId() {
        return id;
    }

    /**
     * Gets the player's first name.
     * @return
     */
    public String getFirstName() {
        return firstName;
    }


    /**
     * Gets the player's last name.
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the player's user name.
     * @return
     */
    public String getUserName() {
        return userName;
    }

    /**
     * set the player's first name.
     * @param firstName the player's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * set the player's  ID.
     * @param id the player's id in the database
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * set the player's last name.
     * @param lastName the player's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * set the player's user name.
     * @param userName the player's last name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * set the player's last name.
     * @return
     */
    public Double getPoints() {
        return points;
    }

    /**
     * set the player's last name.
     * @return
     */
    public Double getTime() {
        return time;
    }

    /**
     * set the player's last name.
     * @param points the player's last name
     */
    public void setPoints(Double points) {
        this.points = points;
    }

    /**
     * set the player's last name.
     * @param time the player's last name
     */
    public void setTime(Double time) {
        this.time = time;
    }

    /**
     * set the player's last name.
     * @param password the player's last name
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * set the player's last name.
     * @return
     */
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
