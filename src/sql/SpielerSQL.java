package sql;

public enum SpielerSQL {
    PSTMT_INSERT(" INSERT INTO Spieler ( "
            + " name, rueckennummer, position ) "
            + " VALUES (?, ?, ? )");

    private String sql;

    private SpielerSQL(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }

}
