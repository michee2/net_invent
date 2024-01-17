package ci.net.demo1.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    static int nbusers = 0;

    private String firstname;

    private String lastname;

    private String username;

    private String password;

    @ManyToOne
    @JoinColumn(name = "site_id")
    private Site site;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UpdatingLog> updatingLogs = new ArrayList<>();



    public User(String firstname, String lastname, String username, String password){
        User.nbusers++;
        this.firstname=firstname;
        this.lastname=lastname;
        this.username=username;
        this.password=password;
    }

    public User(String firstname, String lastname, String username, String password, Site site, Role role){
        User.nbusers++;
        this.firstname=firstname;
        this.lastname=lastname;
        this.username=username;
        this.password=password;
        this.site=site;
        this.role=role;
    }



}
