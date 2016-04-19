package camt.se331.shoppingcart.entity.transfer;

/**
 * Created by Arthur on 2016/4/19.
 */
public class TokenTransfer {
    private final String token;

    public TokenTransfer(String token) {
        this.token = token;
    }

    public String getToken(){
        return this.token;
    }
}

