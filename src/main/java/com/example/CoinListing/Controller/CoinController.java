package com.example.CoinListing.Controller;

import com.example.CoinListing.DTO.ResponseDTO;
import com.example.CoinListing.Model.Coin;
import com.example.CoinListing.Model.Users;
import com.example.CoinListing.Repository.UserRepo;
import com.example.CoinListing.Service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CoinController {


    @Autowired
    private CoinService coinService;
    @Autowired
    private UserRepo userRepo;

    @PostMapping("/createuser")
    public Users createUser(@Valid @RequestBody Users users)
    {
        return userRepo.save(users);
    }
    @PostMapping("/createcoin")
    public Coin createCoin(@Valid @RequestBody Coin coin)
    {
        return coinService.createCoin(coin);
    }

    @GetMapping("/get")
    public ResponseDTO getAllCoin()
    {
        return coinService.getAllCoin();
    }

    public boolean isValidUser(Long id)
    {
        String username;
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if(authentication.getPrincipal() instanceof UserDetails)
        {
            username=((UserDetails) authentication.getPrincipal()).getUsername();
            if(username!=null)
            {
                Users users=userRepo.findByUsername(username);
                if (users!=null&&users.getId()==id)
                {
                    return true;
                }
            }
        }
        return false;
    }
//    @GetMapping("/getusers")
//    public Object getUsers()
//    {
//        return userRepo.findAll();
//    }
    @GetMapping("/getusers/{id}")
    public Object getUsersById(@PathVariable Long id)
    {
        if (!isValidUser(id))
        {
            System.out.println("User Have  Not Valid Credentials");
            String s = ("User Have not valid Credentials");
            return s;
       }
         else
        return userRepo.findById(id).get();
    }
    @GetMapping("/get/{id}")
    public Coin getCoinById(@PathVariable(name = "id") Long id)
    {
        return coinService.getCoinById(id);
    }

    @PutMapping("/put/{id}")
    public Coin updateCoin(@PathVariable Long id,@Valid @RequestBody Coin coin)
    {
        coinService.updateCoin(id,coin);
        return coin;
    }
    @GetMapping("/getUsers")
    public ResponseDTO getAllUsers()
    {
        return coinService.getAllUsers();
    }

    @GetMapping("/getinnerjoin")
    public List<Users> fetchInnerJoin()

    {
        return coinService.fetchInnerJoin();
    }

    @GetMapping("/getleftjoin")
    public List<Users> fetchLeftJoin()
    {
        return coinService.fetchLeftJoin();
    }

    @GetMapping("/getrightjoin")
    public  List<Users> fetchRightJoin()
    {
        return coinService.fetchRightJoin();
    }

    @GetMapping("/getcrossjoin")
    public List<Users> fetchCrossJoin()
    {
        return coinService.fetchCrossJoin();
    }
}
