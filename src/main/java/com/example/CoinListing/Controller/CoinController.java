package com.example.CoinListing.Controller;

import com.example.CoinListing.Model.Coin;
import com.example.CoinListing.Service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CoinController {
    @Autowired
    private CoinService coinService;

    @PostMapping("/create")
    public Coin createCoin(@RequestBody Coin coin)
    {
        return coinService.createCoin(coin);
    }

    @GetMapping("/get")
    public List<Coin> getAllCoin()
    {
        return coinService.getAllCoin();
    }

    @GetMapping("/get/{id}")
    public Coin getCoinById(@PathVariable(name = "id") Long id)
    {
        return coinService.getCoinById(id);
    }

    @PutMapping("/put/{id}")
    public Coin updateCoin(@PathVariable Long id,@RequestBody Coin coin)
    {
        coinService.updateCoin(id,coin);
        return coin;
    }
}
