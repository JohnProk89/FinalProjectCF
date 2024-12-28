package gr.aueb.cf.gg1.dto;

import gr.aueb.cf.gg1.core.enums.GenderType;
import gr.aueb.cf.gg1.core.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


public class UserInsertDTO {

    @NotEmpty (message = "Firstname must not be empty")
    private String firstName;

    @NotEmpty (message = "Lastname must not be empty")
    private String lastName;

    @Email (message = "Invalid Username")
    private String username;

    @Pattern(regexp ="^(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9]).{8,}$")
    private String password;

    private GenderType genderType;

    private Role role;



}