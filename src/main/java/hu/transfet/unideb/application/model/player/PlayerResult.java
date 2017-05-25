package hu.transfet.unideb.application.model.player;

/**
 * Egy jatekos eredmenyeit megvalosito osztaly.
 *
 * @see Player
 */
public class PlayerResult {

    /**
     * Jatekos felhasznalo neve.
     */
    private String username;

    /**
     * A jatekos pontszama.
     */
    private Double point;

    /**
     * A jatekos ideje.
     */
    private Double time;

    /**
     * Parameterezett konstruktor, mellyel egy {@code PlayerResult} objektumot hozunk letre.
     * @param name A jatekos felhasznalo neve.
     * @param point A jatekos elert pontszama.
     * @param time A jatekos ideje.
     */
    public PlayerResult(String name, Double point, Double time){
        this.username = name;
        this.point = point;
        this.time = time;
    }

    /**
     * Beallitja a jatekos eredmenyenek idejet.
     * @param time Egy Double ertek.
     */
    public void setTime(Double time) {
        this.time = time;
    }

    /**
     * Beallitja a jatekos eredmenyenek pontszamat.
     * @param point Egy Double ertek.
     */
    public void setPoint(Double point) {
        this.point = point;
    }

    /**
     * Visszaadja a jatekos eredmenyek idejet.
     * @return Egy Double ertek
     */
    public Double getTime() {

        return time;
    }

    /**
     * Visszaadja a jatekos eredmenyenek pontszamat.
     * @return Egy Double ertek
     */
    public Double getPoint() {
        return point;
    }


    /**
     * Beallitja a jatekos felhasznlo nevet.
     * @param username Egy String, mely a jatekos felhasznlo nevet kepviseli.
     */
    public void setUsername(String username){
        this.username = username;
    }

    /**
     * Visszaadja a jatekos felhasznlo nevet.
     * @return Egy String, mely a jatekos felhasznalo nevet tartalmazza.
     */
    public String getUsername(){
        return username;
    }

}
