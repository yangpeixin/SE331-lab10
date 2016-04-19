package camt.se331.shoppingcart.entity.transfer;

import java.util.Map;

public class UserTransfer{
    private final String name;
    private final Map<String,Boolean> roles;

    public UserTransfer(String name, Map<String, Boolean> roles) {
        this.name = name;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public Map<String, Boolean> getRoles() {
        return roles;
    }
}
