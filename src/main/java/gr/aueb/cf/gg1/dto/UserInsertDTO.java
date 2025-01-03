package gr.aueb.cf.gg1.dto;

import gr.aueb.cf.gg1.core.enums.GenderType;
import gr.aueb.cf.gg1.core.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

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

    @Pattern(regexp ="^(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[!@#$%^&*]).{8,}$", message = "Invalid Password")
    private String password;

    @NotNull(message = "Date of birth must not be null")
    private LocalDate dateOfBirth;

    @NotNull(message = "Gender must not be null")
    private GenderType genderType;

    @NotNull(message = "Role must not be null")
    private Role role;

    @NotNull(message = "Is active must not be null")
    private Boolean isActive;



}