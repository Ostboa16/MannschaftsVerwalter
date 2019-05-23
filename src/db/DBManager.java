package db;

import dbconfig.ConfigEnum;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DBManager {

    private DBPropertiesManager dbpm = DBPropertiesManager.getInstance();
    private Connection con;

    private DBManager() {
        try {
            dbpm.createProperties(ConfigEnum.DERBY);
            Class.forName(dbpm.getDriver()); //Datenbank auswählen!!
            con = DriverManager.getConnection(dbpm.getUrl(),
                    dbpm.getUsername(),
                    dbpm.getPassword());
            System.out.println("Fertig! Geladen und Connection!!");
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static DBManager getInstance() {
        return DBManagerHolder.INSTANCE;
    }

    private static class DBManagerHolder {

        private static final DBManager INSTANCE = new DBManager();
    }

    /* ** Instanz fängt hier an ** */
    //Connection soll nur hier in der Klasse verwendet werden
    public Statement createStatement() throws Exception {
        return con.createStatement();
    }

    public PreparedStatement createPreparedStatement(String sql, int... params) throws Exception {
        switch (params.length) {
            case 0:
                return con.prepareStatement(sql);
            default:
                return con.prepareStatement(sql, params[0]); //immer ersten Param
        }
    }

    public void close() throws Exception {
        con.close();
    }
}
