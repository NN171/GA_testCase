package org.example.greenatom.service;

import org.example.greenatom.model.domain.File;
import org.example.greenatom.model.dto.FileDto;

public interface FileService {
    Long saveFile(FileDto fileDto);
    File getFile(Long id);
}
