package gr.aueb.cf.gg1.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "personal_information")
public class PersonalInfo extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "attachment_id")
    private Attachment attachment;

    private String gamingId;
    private int age;
    private String platform;
    private String country;

    public PersonalInfo(LocalDateTime createdAt, LocalDateTime updatedAt,
                        String country, Long id, String platform, int age) {
        this.country = country;
        this.id = id;
        this.platform = platform;
        this.age = age;
    }
}
