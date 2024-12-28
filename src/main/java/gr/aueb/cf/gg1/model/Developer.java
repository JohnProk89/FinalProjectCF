package gr.aueb.cf.gg1.model;

import gr.aueb.cf.gg1.model.static_data.GamingCompany;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "developers")
public class Developer extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String uuid;

    @Column(name = "is_active")
    private boolean isActive;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "developers_gaming_companies")
    private Set<GamingCompany> gamingCompanies = new HashSet<>();

    public void addGameCompanies(GamingCompany gamingCompany) {
        if (gamingCompanies == null) gamingCompanies = new HashSet<>();
        gamingCompanies.add(gamingCompany);
    }

    public boolean hasGamingCompanies(GamingCompany gamingCompany) {
        return gamingCompanies != null && !gamingCompanies.isEmpty();
    }

    @PrePersist
    public void initializeUUID() {
        if (uuid == null) uuid = UUID.randomUUID().toString();
    }
}
