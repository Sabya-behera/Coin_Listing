package com.example.CoinListing.Repository;

import com.example.CoinListing.Model.CoinAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinAddressRepo extends JpaRepository<CoinAddress,Long> {
}
