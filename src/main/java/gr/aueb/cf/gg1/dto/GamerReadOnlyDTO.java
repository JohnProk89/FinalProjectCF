package gr.aueb.cf.gg1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GamerReadOnlyDTO {

    private Long id;
    private String uuid;
    private Boolean isActive;

    private UserReadOnlyDTO user;
    private PersonalInfoReadOnlyDTO personalInfo;
}
