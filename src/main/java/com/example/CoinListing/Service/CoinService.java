package com.example.CoinListing.Service;

import com.example.CoinListing.Model.Coin;
import com.example.CoinListing.Repository.CoinRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinService {

    @Autowired
    private CoinRepo coinRepo;

    public Coin createCoin(Coin coin)
    {
        return coinRepo.save(coin);
    }

    public List<Coin> getAllCoin()
    {
        return coinRepo.findAll();
    }

    public Coin getCoinById(Long id)
    {
        return coinRepo.getById(id);
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
}
