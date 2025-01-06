package gr.aueb.cf.gg1.service;

import gr.aueb.cf.gg1.core.exceptions.AppObjectAlreadyExists;
import gr.aueb.cf.gg1.core.exceptions.AppObjectInvalidArgumentException;
import gr.aueb.cf.gg1.dto.GamerInsertDTO;
import gr.aueb.cf.gg1.dto.GamerReadOnlyDTO;
import gr.aueb.cf.gg1.mapper.Mapper;
import gr.aueb.cf.gg1.model.Attachment;
import gr.aueb.cf.gg1.model.Gamer;
import gr.aueb.cf.gg1.model.PersonalInfo;
import gr.aueb.cf.gg1.repository.GamerRepository;
import gr.aueb.cf.gg1.repository.PersonalInfoRepository;
import gr.aueb.cf.gg1.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GamerService {

    private final GamerRepository gamerRepository;
    private final UserRepository userRepository;
    private final PersonalInfoRepository personalInfoRepository;
    private final Mapper mapper;

    @Transactional(rollbackOn = Exception.class)
    public GamerReadOnlyDTO saveGamer(GamerInsertDTO gamerInsertDTO, MultipartFile file)
            throws AppObjectAlreadyExists, AppObjectInvalidArgumentException, IOException {

        if (userRepository.findByUsername(gamerInsertDTO.getUser().getUsername()).isPresent()) {
            throw new AppObjectAlreadyExists("User", "User with username: " + gamerInsertDTO.getUser().getUsername() + " already exists");
        }

        if (personalInfoRepository.findByGamingId(gamerInsertDTO.getPersonalInfo().getGamingId()).isPresent()) {
            throw new AppObjectAlreadyExists("PersonalInfo", "Personal Info with gamingId: " + gamerInsertDTO.getPersonalInfo().getGamingId() + " already exists");
        }

        Gamer gamer = mapper.mapToGamerEntity(gamerInsertDTO);

        saveFile(gamer.getPersonalInfo(), file);

        Gamer savedGamer = gamerRepository.save(gamer);
        return mapper.mapToGamerReadOnlyDTO(savedGamer);

    }

    @Transactional(rollbackOn = Exception.class)
    public void saveFile(PersonalInfo personalInfo, MultipartFile file) throws IOException {

        if (file != null && !file.isEmpty()) {
            String originalFileName = file.getOriginalFilename();
            String savedName = UUID.randomUUID() + getFileExtension(originalFileName);
            String uploadDir = "uploads/";
            Path filePath = Paths.get(uploadDir + savedName);
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, file.getBytes());

            Attachment attachment = new Attachment();
            attachment.setFilename(originalFileName);
            attachment.setSavedName(savedName);
            attachment.setFilePath(filePath.toString());
            attachment.setContentType(file.getContentType());
            attachment.setExtension(getFileExtension(originalFileName));

            personalInfo.setAttachment(attachment);
        }
    }

    public String getFileExtension(String filename) {
        if (filename != null && filename.contains(".")) {
            return filename.substring(filename.lastIndexOf("."));
        }
        return "";
    }

    public Page<GamerReadOnlyDTO> getPaginatedGamers(int page, int size) {
        String defaultSort = "id";
        Pageable pageable = PageRequest.of(page, size, Sort.by(defaultSort).ascending());
        return gamerRepository.findAll(pageable).map(mapper::mapToGamerReadOnlyDTO);
    }

    public Page<GamerReadOnlyDTO> getPaginatedSortedGamers(int page, int size, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        return gamerRepository.findAll(pageable).map(mapper::mapToGamerReadOnlyDTO);
    }
}
