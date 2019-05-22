package model;

import data.CompSpieler;
import data.Spieler;
import data.SpielerEnum;
import db.AccessDB;
import gui.AddPlayerDlg;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class MannschaftsVerwalterModel extends AbstractTableModel {

    private AccessDB adb = new AccessDB();
    public static List<Spieler> liste = new ArrayList<>();

    @Override
    public int getRowCount() {
        return liste.size();
    }

    @Override
    public int getColumnCount() {
        return SpielerEnum.values().length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Spieler s = liste.get(i);

        SpielerEnum enumIndex = SpielerEnum.values()[i1];
        switch (enumIndex) {
            case NAME:
                return s.getName();
            case RUECKENNUMMER:
                return s.getRueckennummer();
            case POSITION:
                return s.getPosition();
        }
        return "?";
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {
        try{
        if (o instanceof Spieler) {
            liste.set(i, (Spieler) o);
        } else {
            Spieler sAlt = liste.get(i);

            String nameAlt = sAlt.getName();
            int rueckennummerAlt = sAlt.getRueckennummer();
            String positionAlt = sAlt.getPosition();

            SpielerEnum enumIndex = SpielerEnum.values()[i1];
            switch (enumIndex) {
                case NAME:
                    nameAlt = (String) o;
                case RUECKENNUMMER:
                    for (int j = 0; j < liste.size(); j++) {
                        if (liste.get(j).getRueckennummer() != Integer.parseInt((String) o)) { //Überprüfen ob es die Rückennummer schon gibt
                            rueckennummerAlt = Integer.parseInt((String) o);
                        } else {
                            throw new Exception("Es darf keine doppelten Rückennummern geben!");
                        }
                    }
                    break;
                case POSITION:
                    positionAlt = (String) o;
                    break;
            }
            Spieler sNew = new Spieler(nameAlt, rueckennummerAlt, positionAlt);
            liste.set(i, sNew);
            Collections.sort(liste, new CompSpieler());
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Fehler!", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public String getColumnName(int i) {
        return SpielerEnum.values()[i].getName();
    }

    public Spieler getElementAt(int i) {
        return liste.get(i);
    }

    public void add(Spieler s) {
        try {
            for (int i = 0; i < liste.size(); i++) {
                if (liste.get(i).getRueckennummer() != s.getRueckennummer()) { //Überprüfen ob es die Rückennummer schon in der Liste gibt
                } else {
                    throw new Exception("Es darf keine doppelten Rückennummern geben!");
                }
            }
            //Wenn keine Exception geworfen wird Spieler zur Liste und Datenbank hinzufügen
            liste.add(s);
            adb.persistEntity(s);
            fireTableDataChanged();
            Collections.sort(liste, new CompSpieler()); //Nach Rückennummer Sortieren
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Fehler!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void remove(int index) throws Exception {
        //Rückennummer vom Index finden damit man es in der Datenbank löschen kann
        int rn = (int) getValueAt(index,1);
        adb.delete(rn);
        liste.remove(index);
        Collections.sort(liste, new CompSpieler()); //Sortieren
        fireTableDataChanged();
    }

    public void save(File f) throws Exception {
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Spieler s : liste) {
                //Objekte von der Liste in die Datei einfügen
                oos.writeObject(s);
            }
        } catch (EOFException eofex) {
            System.out.println("Speichern abgeschlossen");
        }
    }

    public void load(File f) throws Exception {
        try {
            //Liste und Datenbank clearen
            liste.clear();
            adb.clear();
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true) {
                Spieler s = (Spieler) ois.readObject();
                //Liste und Datenbank mit neuen Daten füllen
                liste.add(s);
                adb.persistEntity(s);
                Collections.sort(liste, new CompSpieler());
            }
        } catch (EOFException eofex) {
            System.out.println("Laden abgeschlossen");
        }
    }

}
