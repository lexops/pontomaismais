package xyz.lexops.pontomaismais.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    BASIC("B"),
    ADMIN("A");

    private final String code;

    public static Role fromCode(String code) throws IllegalArgumentException {
        for (Role role:Role.values()){
            if (role.getCode().equals(code)){
                return role;
            }
        }
        throw new IllegalArgumentException("Unknown role code:"+code);
    }

}
