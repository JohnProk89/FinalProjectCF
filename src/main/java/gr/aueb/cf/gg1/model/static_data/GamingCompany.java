package gr.aueb.cf.gg1.model.static_data;

import gr.aueb.cf.gg1.model.Developer;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "gaming_companies")
public class GamingCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "gaming_company_id")
    private GamingCompany gamingCompany;

    @Getter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "gaming_companies")
    private Set<Developer> developers = new HashSet<>();
}
