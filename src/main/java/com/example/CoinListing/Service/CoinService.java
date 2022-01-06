package com.example.CoinListing.Service;

import com.example.CoinListing.DTO.ResponseDTO;
import com.example.CoinListing.Model.Coin;
import com.example.CoinListing.Model.Users;
import com.example.CoinListing.Repository.CoinRepo;
import com.example.CoinListing.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoinService implements UserDetailsService {

    @Autowired
    private CoinRepo coinRepo;

    @Autowired
    private UserRepo userRepo;


    public Coin createCoin(Coin coin)
    {
        return coinRepo.save(coin);
    }

    public ResponseDTO getAllCoin()
    {
        ResponseDTO responseDTO= new ResponseDTO();
        try {
            responseDTO.setData(coinRepo.findAll());
        }
        catch (Exception e)
        {
            responseDTO.setCode(HttpStatus.BAD_REQUEST.value());
            responseDTO.setMessage("Coin NOT Found Failure!!!");
        }
        responseDTO.setCode(HttpStatus.OK.value());
        responseDTO.setMessage("Success!!!");
         return responseDTO;
    }

    public Coin getCoinById(Long id)
    {
        return coinRepo.findById(id).get();
    }

    public Coin updateCoin(Long id,Coin coin)
    {
        Coin coin1=coinRepo.getById(id);
        coin1.setFullname(coin.getFullname());
        coin1.setShortname(coin.getShortname());
        coin1.setIcon(coin.getIcon());
        coin1.setCoinAddress(coin.getCoinAddress());
        coinRepo.save(coin1);
        return coin1;
    }
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException
    {
        Users users = userRepo.findByUsername(userName);
        if(users == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(users.getUsername(), users.getPassword(),new ArrayList<>());
    }
    public ResponseDTO getAllUsers()
    {
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            responseDTO.setData(userRepo.findAll());
        } catch (Exception e) {
            responseDTO.setCode(HttpStatus.BAD_REQUEST.value());
            responseDTO.setMessage("Failed");
        }
        responseDTO.setCode(HttpStatus.OK.value());
        responseDTO.setMessage("Success");

        return responseDTO;
    }
    public List<Users> fetchInnerJoin()
    {
        return userRepo.fetchInnerJoin();
    }
    public  List<Users> fetchLeftJoin()
    {
        return userRepo.fetchLeftJoin();
    }
    public  List<Users> fetchRightJoin()
    {
        return userRepo.fetchRightJoin();
    }
    public List<Users> fetchCrossJoin()
    {
        return userRepo.fetchCrossJoin();
    }

}
