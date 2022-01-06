package com.example.CoinListing.Repository;

import com.example.CoinListing.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<Users,Long> {
    public Users findByUsername(String username);

    @Query(value = "select * from coin",nativeQuery = true)
    public List<Users> getAll();

      @Query(value = "SELECT * FROM ((users as u INNER JOIN coin as c ON c.id = u.coin_id) INNER JOIN c_address as a ON a.coin_id = c.id)",nativeQuery = true)
      List<Users> fetchInnerJoin();
      @Query(value = "SELECT * FROM ((users as u LEFT OUTER JOIN coin as c ON c.id = u.coin_id) LEFT OUTER JOIN c_address as a ON a.coin_id= c.id)",nativeQuery = true)
      List<Users> fetchLeftJoin();
      @Query(value ="SELECT * FROM ((users as u RIGHT OUTER JOIN coin as c ON c.id = u.coin_id) RIGHT OUTER JOIN c_address as a ON a.coin_id= c.id)",nativeQuery = true)
      List<Users> fetchRightJoin();
      @Query(value = "(SELECT * FROM users as u LEFT OUTER JOIN coin as c ON c.id = u.coin_id LEFT OUTER JOIN c_address as a ON a.coin_id= c.id) union (SELECT * FROM users as u RIGHT OUTER JOIN coin as c ON c.id = u.coin_id RIGHT OUTER JOIN c_address as a ON a.coin_id= c.id)",nativeQuery = true)
      List<Users> fetchCrossJoin();


}
