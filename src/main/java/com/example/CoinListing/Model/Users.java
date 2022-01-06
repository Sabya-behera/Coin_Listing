package com.example.CoinListing.Model;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 8,message = "There must be 8 characters")
    private String username;
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    private Coin coin;

    public Users() {
    }

    public Users(Long id, String username, String password, Coin coin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.coin = coin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Coin getCoin() {
        return coin;
    }

    public void setCoin(Coin coin) {
        this.coin = coin;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", coin=" + coin +
                '}';
    }
}
