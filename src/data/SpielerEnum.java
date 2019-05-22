package data;

public enum SpielerEnum {
    NAME("Name"),
    RUECKENNUMMER("Rueckennummer"),
    POSITION("Position");

    private String name;

    private SpielerEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
