package camt.se331.shoppingcart.controller;

import camt.se331.shoppingcart.entity.transfer.TokenTransfer;
import camt.se331.shoppingcart.entity.transfer.UserTransfer;
import camt.se331.shoppingcart.service.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Arthur on 2016/4/19.
 */
@RestController
@RequestMapping("/user")
public class UserAuthenticationController {
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(method = RequestMethod.GET)
    public UserTransfer getUser(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        Object principal=authentication.getPrincipal();
        UserDetails userDetails = (UserDetails) principal;
        return new UserTransfer(userDetails.getUsername(),this.createRoleMap(userDetails));
    }

    private Map<String,Boolean> createRoleMap(UserDetails userDetails) {
        Map<String,Boolean> roles=new HashMap<String, Boolean>();
        for (GrantedAuthority authority : userDetails.getAuthorities()){
            roles.put(authority.getAuthority(),Boolean.TRUE);
        }
        return roles;
    }

    @RequestMapping(value = "/authentication",method = RequestMethod.POST)
    public TokenTransfer anthenticate(@RequestBody String body){
        String[] token=body.split("&");
        String username=token[0].split("=")[1];
        String password=token[1].split("=")[1];
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);
        Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails= this.userDetailsService.loadUserByUsername(username);
        return new TokenTransfer(TokenUtils.createToken(userDetails));
    }
}
