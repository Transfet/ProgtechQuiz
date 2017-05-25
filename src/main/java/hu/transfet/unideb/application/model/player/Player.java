package hu.transfet.unideb.application.model.player;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Egy jatekost megvalosito osztaly.
 *
 * @author Transfet.
 */
@Entity
public class Player implements Serializable {

    /**
     * A jatekos felhasznaloneve.
     */
    @Column(name = "USER_NAME")
    private String userName;

    /**
     * A jatekos keresztneve.
     */
    @Column(name = "FIRST_NAME")
    private String firstName;

    /**
     * A jatekos vezetekneve.
     */
    @Column(name = "LAST_NAME")
    private String lastName;

    /**
     * A jatekos jelszava.
     */
    @Column(name = "PASSWORD")
    private String password;

    /**
     * A jatekos ID-je az adatbazis tablaban.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    /**
     * A jatekos pontszama.
     */
    @Column(name = "POINT")
    private Double points = 0.0;

    /**
     * A jatekos ideje.
     */
    @Column(name = "TIME")
    private Double time = 0.0 ;


    /**
     * Visszaadja a jatekos ID-jet.
     * @return return Egy ID.
     *
     * */
    public Long getId() {
        return id;
    }

    /**
     * Visszaadja a jatekos keresztnevet.
     * @return A jatekos keresztneve.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Visszaadja a jatekos vezeteknevet.
     *
     * @return A jatekos vezetekneve.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Visszaadja a jatekos felhasznalonevet.
     * @return A jatekos felhasznaloneve.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Beallitja a jatekos keresztnevet.
     * @param firstName A jatekos keresztneve.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Beallitja a jatekos ID-jet.
     * @param id A jatekos ideje.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Beallitja a jatekos vezeteknevet.
     * @param lastName String.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Beallitja a jatekos felhasznalonevet.
     * @param userName Jatekos fehalsznalo neve.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Visszaadja a jatekos aktualis pontszamat.
     * @return A jatekos pontszama.
     */
    public Double getPoints() {
        return points;
    }

    /**
     * Visszaadja a jatekos aktualis idejet.
     * @return A jatekos ideje.
     */
    public Double getTime() {
        return time;
    }

    /**
     * Beallitja a jatekos pontszamat.
     * @param points Jatekos pontszama.
     */
    public void setPoints(Double points) {
        this.points = points;
    }

    /**
     * Beallitja a jatekos idejet.
     * @param time jatekos ideje.
     */
    public void setTime(Double time) {
        this.time = time;
    }

    /**
     * Beallitja a jatekos jelszavat.
     * @param password A jatekos jelszava.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Visszaadja a jatekos jelszavat.
     * @return A jatekos jelszava.
     */
    public String getPassword() {
        return password;
    }


    @Override
    public String toString() {
        return "Player{" +
                "userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                ", points=" + points +
                ", time=" + time +
                '}';
    }
}
