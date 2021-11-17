package com.example.CoinListing.Controller;

import com.example.CoinListing.Model.CoinAddress;
import com.example.CoinListing.Service.CoinAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoinAddressController {
    @Autowired
    private CoinAddressService coinAddressService;

    @PostMapping("/createAddress")
    public CoinAddress createCoinAddress(@RequestBody CoinAddress coinAddress)
    {
        return coinAddressService.createCoinAddress(coinAddress);
    }

    @GetMapping("/getAddress")
    public List<CoinAddress> getAllCoinAddress()
    {
        return coinAddressService.getAllCoinAddress();
    }
    @GetMapping("/getAddress/{id}")
    public CoinAddress getCoinAddressById(@PathVariable(name ="id") Long id)
    {
        return coinAddressService.getCoinAddressById(id);
    }
    @PutMapping("/putAddress/{id}")
    public CoinAddress updateCoinAddress(@PathVariable(name = "id") Long id,@RequestBody CoinAddress coinAddress)
    {
        coinAddressService.updateCoinAddress(id,coinAddress);
        return coinAddress;
    }
}
