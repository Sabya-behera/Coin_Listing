package com.example.CoinListing.Controller;


import com.example.CoinListing.Model.CoinAddress;
import com.example.CoinListing.Service.CoinAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class CoinAddressController {
    @Autowired
    private CoinAddressService coinAddressService;

    @PostMapping("/createAddress")
    public CoinAddress createCoinAddress(@Valid @RequestBody CoinAddress coinAddress) {
        return coinAddressService.createCoinAddress(coinAddress);
    }

    @GetMapping("/getAddress")
    //@ResponseStatus(code = HttpStatus.ACCEPTED,reason = "The value is displayed successfully")
    public List<CoinAddress> getAllCoinAddress() {
        return coinAddressService.getAllCoinAddress();
    }
//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity getAllCoinAddress(@RequestHeader(value="Access-key") String accessKey,
//                                  @RequestHeader(value="Secret-key") String secretKey)
//    {
//        try {
//            // see note 1
//            return ResponseEntity
//                    .status(HttpStatus.CREATED)
//                    .body(this.coinAddressService.chkCredentials(accessKey, secretKey, timestamp));
//        }
//        catch(ChekingCredentialsFailedException e)
//        {
//            e.printStackTrace();
//            // see note 2
//            return ResponseEntity
//                    .status(HttpStatus.FORBIDDEN)
//                    .body("Error Message");
//        }
//    }
    @GetMapping("/getAddress/{id}")
    public CoinAddress getCoinAddressById(@PathVariable(name = "id") Long id) {
        return coinAddressService.getCoinAddressById(id);
    }

//    @GetMapping("/getAddress/{id}")
//    public ResponseEntity<CoinAddress> getCoinAddressById(@PathVariable(name = "id") Long id) {
//        CoinAddress coinAddress=coinAddressService.getCoinAddressById(id);
//        if (coinAddress==null) {
//            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//            throw new ResourceNotFoundException("Addresss Not Found");
//        }
//        return ResponseEntity.of(Optional.of(coinAddress));
//    }

    @PutMapping("/putAddress/{id}")
    public CoinAddress updateCoinAddress(@PathVariable(name = "id") Long id, @Valid @RequestBody CoinAddress coinAddress) {
        coinAddressService.updateCoinAddress(id, coinAddress);
        return coinAddress;
    }

    @GetMapping("/getAddressleftjoin")
    public List<CoinAddress> fetchLeftJoin() {
        return coinAddressService.fetchLeftJoin();
    }

    @GetMapping("/getAddressrightjoin")
    public List<CoinAddress> fetchRightJoin() {
        return coinAddressService.fetchRightJoin();
    }


}
