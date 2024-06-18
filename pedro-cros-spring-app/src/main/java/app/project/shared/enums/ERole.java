package app.project.shared.enums;

public enum ERole {

    ROLE_ADMIN("ADMIN"),
    ROLE_TEACHER("TEACHER"),
    ROLE_STUDENT("STUDENT"),
    ROLE_USER("USER"),
    ROLE_UNASSIGNED("UNASSIGNED")
    ;

    private final String role;

    ERole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return role;
    }

    public static ERole fromString(String role) {
        for (ERole eRole : ERole.values()) {
            if (eRole.toString().equalsIgnoreCase(role)) {
                return eRole;
            }
        }
        throw new IllegalArgumentException("No enum constant app.project.shared.enums.ERole." + role);
    }
}