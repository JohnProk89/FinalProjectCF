package gr.aueb.cf.gg1.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonalInfoInsertDTO {

    @NotEmpty(message = "Gaming id must not be empty")
    private String gamingId;

    @NotEmpty(message = "Country must not be empty")
    private String country;



}
