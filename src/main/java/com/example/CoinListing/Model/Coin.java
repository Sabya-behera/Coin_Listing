package com.example.CoinListing.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Coin")
public class Coin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shortname;
    private String fullname;
    private String icon;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "coin")
    private List<CoinAddress> coinAddress;

    public Coin() {
    }

    public Coin(Long id, String shortname, String fullname, String icon, List<CoinAddress> coinAddress) {
        this.id = id;
        this.shortname = shortname;
        this.fullname = fullname;
        this.icon = icon;
        this.coinAddress = coinAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<CoinAddress> getCoinAddress() {
        return coinAddress;
    }

    public void setCoinAddress(List<CoinAddress> coinAddress) {
        this.coinAddress = coinAddress;
    }
}
