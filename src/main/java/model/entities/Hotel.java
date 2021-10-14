package model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "hotel")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @OneToMany(mappedBy = "hotel", fetch = FetchType.EAGER)
    private Collection<City> cities;
    @Column(name = "name", length = 45)
    private String name;
    @Column(name = "rate")
    private Integer rate;


}
