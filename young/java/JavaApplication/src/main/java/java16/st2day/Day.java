package java16.st2day;

public enum Day {
    SUN(1),  // 0
    MON(2),  // 1
    TUE(3),
    WED(4),
    THU(5),
    FRI(6),
    STA(7);

    private final int value;

    public int getValue() {
        return value;
    }

    Day(int value) {
        this.value= value;
    }

    public static Day fromId(int id) {
        for (Day type : Day.values()) {
            if (type.getValue() == id) {
                return type;
            }
        }
        return null;
    }
}
