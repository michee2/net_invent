package ci.net.demo1.models.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "equipements")
@Data @NoArgsConstructor
public class Equipment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "site_id")
    private Site site;

    private String status;

    private String name;

    private String type;

    private String provider;

    private String serial_number;

    private LocalDate createdAt;

    private LocalDate updatedAt;


    @OneToMany(mappedBy = "equipment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Log> updatingLogs = new ArrayList<>();

    @OneToMany(mappedBy = "sourceEquipment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Link> linksAsSource = new ArrayList<>();

    @OneToMany(mappedBy = "targetEquipment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Link> linksAsTarget = new ArrayList<>();

    public Equipment(String name, String provider, String type, String serial_number, String status,
                     Site site, LocalDate up_date){
        this.name = name;
        this.provider = provider;
        this.type = type;
        this.serial_number = serial_number;
        this.status = status;
        this.site = site;
        this.updatedAt = up_date;
    }

    public Equipment(String name, String provider, String type, String serial_number, String status,
                     Site site, LocalDate create_date, LocalDate up_date){
        this.name = name;
        this.provider = provider;
        this.type = type;
        this.serial_number = serial_number;
        this.status = status;
        this.site = site;
        this.createdAt = create_date;
        this.updatedAt = up_date;
    }
}
