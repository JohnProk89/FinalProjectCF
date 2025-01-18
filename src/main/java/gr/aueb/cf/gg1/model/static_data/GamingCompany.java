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
    @JoinColumn(name = "platform_id") // Αναφορά στο πεδίο της κλάσης Platform
    private Platform platform;

    @OneToMany(mappedBy = "gamingCompany", cascade = CascadeType.ALL)
    private Set<Developer> developers = new HashSet<>();
}
