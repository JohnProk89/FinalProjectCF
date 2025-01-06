package gr.aueb.cf.gg1.mapper;

import gr.aueb.cf.gg1.dto.*;
import gr.aueb.cf.gg1.model.Gamer;
import gr.aueb.cf.gg1.model.PersonalInfo;
import gr.aueb.cf.gg1.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Mapper {

    // private final PasswordEncoder passwordEncoder

    public GamerReadOnlyDTO mapToGamerReadOnlyDTO(Gamer gamer) {
        var dto = new GamerReadOnlyDTO();

        dto.setId(gamer.getId());
        dto.setUuid(gamer.getUuid());
        dto.setIsActive(gamer.getIsActive());

        // map to UserReadOnlyDTO
        var userDTO = new UserReadOnlyDTO();
        userDTO.setFirstname(gamer.getUser().getFirstname());
        userDTO.setLastname(gamer.getUser().getLastname());
        dto.setUser(userDTO);

        // map to PersonalInfoDTO
        var personalInfoDTO = new PersonalInfoReadOnlyDTO();
        personalInfoDTO.setGamingId(gamer.getPersonalInfo().getGamingId());
        dto.setPersonalInfo(personalInfoDTO);

        return dto;

    }

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
