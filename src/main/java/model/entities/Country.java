package model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "country")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", length = 45)
    private String name;
    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
    private Collection<City> cities;
}
