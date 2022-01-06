package com.example.CoinListing.Controller;

import com.example.CoinListing.Helper.JwtHelper;
import com.example.CoinListing.Model.JWTResponse;
import com.example.CoinListing.Model.Users;
import com.example.CoinListing.Service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CoinService coinService;
    @Autowired
    private JwtHelper jwtHelper;

    @RequestMapping(value = "/createtoken",method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody Users users) throws Exception {
        System.out.println(users);
        try {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword()));
        }catch (UsernameNotFoundException e)
        {
            e.printStackTrace();
            throw new Exception("Bad credentials");
        }catch (BadCredentialsException e)
        {
            e.printStackTrace();
            throw new Exception("Bad Credentials");
        }
        //fine area...
        UserDetails userDetails=this.coinService.loadUserByUsername(users.getUsername());
        String token= this.jwtHelper.generateToken(userDetails);
        System.out.println("JWT "+token);

        //{"token":"value"}
        return ResponseEntity.ok(new JWTResponse("token"));

    }
}
