package app.project.shared.enums;

public enum EPlace {
    ONLINE("Online")
    ,IN_PERSON("In person")
    ;

    private final String place;

    EPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return place;
    }

    public String getName() {
        return place;
    }
}
