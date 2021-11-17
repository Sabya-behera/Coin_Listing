package com.example.CoinListing.Repository;

import com.example.CoinListing.Model.Coin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinRepo extends JpaRepository<Coin,Long> {
}
