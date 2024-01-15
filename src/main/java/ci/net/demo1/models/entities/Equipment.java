package ci.net.demo1.models.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "equipements")
@Data @NoArgsConstructor
public class Equipment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String site;
    private String etat;

    public Equipment(String site, String etat){
        this.site = site;
        this.etat = etat;
    }
}
