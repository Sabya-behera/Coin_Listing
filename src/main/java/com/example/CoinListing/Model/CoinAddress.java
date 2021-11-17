package com.example.CoinListing.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "C_Address")
public class CoinAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private enum status{InActive,Active};
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    private Coin coin;

    public CoinAddress() {
    }

    public CoinAddress(Long id, String address, Coin coin) {
        this.id = id;
        this.address = address;
        this.coin = coin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Coin getCoin() {
        return coin;
    }

    public void setCoin(Coin coin) {
        this.coin = coin;
    }
}
