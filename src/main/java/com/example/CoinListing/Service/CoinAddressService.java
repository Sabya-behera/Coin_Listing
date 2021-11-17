package com.example.CoinListing.Service;

import com.example.CoinListing.Model.Coin;
import com.example.CoinListing.Model.CoinAddress;
import com.example.CoinListing.Repository.CoinAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinAddressService {
    @Autowired
    private CoinAddressRepo coinAddressRepo;


    public CoinAddress createCoinAddress(CoinAddress coinAddress)
    {
        return coinAddressRepo.save(coinAddress);
    }

    public List<CoinAddress> getAllCoinAddress()
    {
        return coinAddressRepo.findAll();
    }

    public CoinAddress getCoinAddressById(Long id)
    {
        return coinAddressRepo.getById(id);
    }

    public CoinAddress updateCoinAddress(Long id,CoinAddress coinAddress)
    {
        CoinAddress coinAddress1=coinAddressRepo.getById(id);
        coinAddress1.setAddress(coinAddress.getAddress());
        coinAddress1.setCoin(coinAddress.getCoin());
        coinAddressRepo.save(coinAddress1);
        return coinAddress1;
    }

}
