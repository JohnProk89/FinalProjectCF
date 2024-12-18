package gr.aueb.cf.gg1.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "gamers")
public class Gamer extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String uuid;

    private Boolean isActive;

    @PrePersist
    public void initializeUUID() {
        if (uuid == null) uuid =UUID.randomUUID().toString();
    }
}
