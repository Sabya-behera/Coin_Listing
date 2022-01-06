package com.example.CoinListing.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "Coin")
public class Coin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 2,max = 4,message = "The name should be at least 2 letters and between 4")
    @NotBlank(message = "No blank spaces allowed")
    private String shortname;
    @NotEmpty(message = "Enter properly")
    @Size(min = 4 ,message = "enter a minimum of 4 characters")
    private String fullname;
    @NotNull
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
