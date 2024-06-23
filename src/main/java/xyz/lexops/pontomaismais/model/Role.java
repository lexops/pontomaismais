package xyz.lexops.pontomaismais.model;

public enum Role {
    BASIC("B"),
    ADMIN("A"),
    EMPLOYEE("E");

    private final String code;

    Role(String code) {
        this.code = code;
    }

    public static Role fromCode(String code) throws IllegalArgumentException {
        for (Role role:Role.values()){
            if (role.getCode().equals(code)){
                return role;
            }
        }
        throw new IllegalArgumentException("Unknown role code:"+code);
    }

    public String getCode() {
        return code;
    }
}
