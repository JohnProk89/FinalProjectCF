package gr.aueb.cf.gg1.model.static_data;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "platforms")
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Getter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "gaming_company")
    private Set<GamingCompany> gamingCompanies = new HashSet<>();

    public Set<GamingCompany> getAllGamingCompanies() {
        if (gamingCompanies == null) gamingCompanies = new HashSet<>();
        return Collections.unmodifiableSet(gamingCompanies);
    }
}
