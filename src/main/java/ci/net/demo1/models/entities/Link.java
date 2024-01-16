package ci.net.demo1.models.entities;

import jakarta.persistence.*;

@Entity
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "source_equipment_id")
    private Equipment sourceEquipment;

    @ManyToOne
    @JoinColumn(name = "target_equipment_id")
    private Equipment targetEquipment;

    private String link_type;
    private String speed;

}
