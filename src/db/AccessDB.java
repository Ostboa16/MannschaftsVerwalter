package db;

import data.Spieler;
import sql.SpielerSQL;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class AccessDB {

    public AccessDB() {
    }

    public static AccessDB getInstance() {
        return AccessDB_Holder.INSTANCE;
    }

    private static class AccessDB_Holder {

        private static final AccessDB INSTANCE = new AccessDB();
    }

    /**
     * Instanz Methode *
     */
    private final DBManager dbm = DBManager.getInstance();

    public void clear() throws Exception {
        Statement stmt = dbm.createStatement();
        int affectedRows = stmt.executeUpdate(" DELETE FROM Spieler ");
        System.out.println("Clear affected rows: " + affectedRows);
    }

    public void delete(int r) throws Exception {
        Statement stmt = dbm.createStatement();
        int affectedRows = stmt.executeUpdate(" DELETE FROM Spieler WHERE rueckennummer = " + r);
        System.out.println("Clear affected rows: " + affectedRows);
    }

    public void persistEntity(Spieler e) throws Exception {
        PreparedStatement pstmt = dbm.createPreparedStatement(
                SpielerSQL.PSTMT_INSERT.getSql(),
                Statement.RETURN_GENERATED_KEYS);
        //Spieler-Objekt als Datensatz setzen
        pstmt.setString(1, e.getName());
        pstmt.setInt(2, e.getRueckennummer());
        pstmt.setString(3, e.getPosition());

        int affectedRows = pstmt.executeUpdate();
        System.out.println("persist-affectedRows: " + affectedRows);

        pstmt.close();
    }
}
