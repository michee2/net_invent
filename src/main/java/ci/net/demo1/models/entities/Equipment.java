package ci.net.demo1.models.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "equipements")
@Data @NoArgsConstructor
public class Equipment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Transient
    static int nb_equips = 0;

    @Transient
    static int nb_equips_def = 0;

    private String site;

    private String etat;

    private boolean isBon;

    private String name;

    private String type;

    private String location;

    private String provider;

    private String serial_number;


    @OneToMany(mappedBy = "equipment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UpdatingLog> updatingLogs = new ArrayList<>();

    @OneToMany(mappedBy = "sourceEquipment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Link> linksAsSource = new ArrayList<>();

    @OneToMany(mappedBy = "targetEquipment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Link> linksAsTarget = new ArrayList<>();

    public Equipment(String site, String etat){
        Equipment.nb_equips++;
        this.site = site;
        this.etat = etat;

        if (!this.isBon) {
            Equipment.nb_equips_def++;
        }
    }
}
