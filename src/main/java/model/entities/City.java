package model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Table(name = "city")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id", nullable = false)
    private Hotel hotel;
    @Column(name = "name", length = 45)
    private String name;
    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
    private Country country;
    @OneToMany(mappedBy = "city", fetch = FetchType.EAGER)
    private Collection<Place> places;
}
