package gr.aueb.cf.gg1.mapper;

import gr.aueb.cf.gg1.dto.GamerInsertDTO;
import gr.aueb.cf.gg1.dto.PersonalInfoInsertDTO;
import gr.aueb.cf.gg1.dto.UserInsertDTO;
import gr.aueb.cf.gg1.model.Gamer;
import gr.aueb.cf.gg1.model.PersonalInfo;
import gr.aueb.cf.gg1.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Mapper {

    // private final PasswordEncoder passwordEncoder

    public Gamer mapToGamerEntity(GamerInsertDTO gamerInsertDTO) {
        Gamer gamer = new Gamer();
        gamer.setIsActive(gamerInsertDTO.getIsActive());

        User user = new User();
        UserInsertDTO userInsertDTO = new UserInsertDTO();
        user.setFirstname(userInsertDTO.getFirstName());
        user.setLastname(userInsertDTO.getLastName());
        user.setUsername(userInsertDTO.getUsername());
        user.setPassword(userInsertDTO.getPassword());
        user.setGender(userInsertDTO.getGenderType());
        user.setRole(userInsertDTO.getRole());
        user.setIsActive(userInsertDTO.getIsActive());
        gamer.setUser(user);

        PersonalInfoInsertDTO personalInfoInsertDTO = gamerInsertDTO.getPersonalInfo();
        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setGamingId(personalInfoInsertDTO.getGamingId());
        personalInfo.setCountry(personalInfoInsertDTO.getCountry());
        gamer.setPersonalInfo(personalInfo);
        return gamer;



    }
}
