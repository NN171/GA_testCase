package org.example.greenatom.repository;

import org.example.greenatom.dto.FileDto;
import org.example.greenatom.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
    FileDto getFileById(Long id);
    Long getIdByFileDto(FileDto fileDto);
    void createFileByFileDto(FileDto fileDto); //TODO {write jpql queries for create and get}
}
