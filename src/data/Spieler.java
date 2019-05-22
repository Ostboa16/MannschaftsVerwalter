package data;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Spieler implements Serializable {

    private String name;
    private int rueckennummer;
    private String position;

    public Spieler(String name, int rueckennummer, String position) {
        this.name = name;
        this.rueckennummer = rueckennummer;
        this.position = position;
    }

    public Spieler(ResultSet rs) throws SQLException {
        this.name = rs.getString("name");
        this.rueckennummer = rs.getInt("rueckennummer");
        this.position = rs.getString("position");
    }

    public String getName() {
        return name;
    }

    public int getRueckennummer() {
        return rueckennummer;
    }

    public String getPosition() {
        return position;
    }

    public void setRueckennummer(int rueckennummer) {
        this.rueckennummer = rueckennummer;
    }

    @Override
    public String toString() {
        return "Spieler{" + "name=" + name + ", rueckennummer=" + rueckennummer + ", position=" + position + '}';
    }

}
