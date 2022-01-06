package com.example.CoinListing.Repository;

import com.example.CoinListing.Model.CoinAddress;
import com.example.CoinListing.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CoinAddressRepo extends JpaRepository<CoinAddress,Long> {

    @Query(value = "SELECT * FROM c_address as ca LEFT OUTER JOIN coin as c ON c.id =ca.coin_id LEFT OUTER JOIN users as u ON u.coin_id= c.id",nativeQuery = true)
    List<CoinAddress> fetchLeftJoin();

    @Query(value = "SELECT * FROM c_address as ca RIGHT OUTER JOIN coin as c ON c.id =ca.coin_id RIGHT OUTER JOIN users as u ON u.coin_id= c.id",nativeQuery = true)
    List<CoinAddress> fetchRightJoin();

}
