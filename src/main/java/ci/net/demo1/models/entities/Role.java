package ci.net.demo1.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<User> users=new ArrayList<>();

    public Role(String libelle){
        this.libelle=libelle;
    }
}
