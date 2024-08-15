package org.example.greenatom.service;

import org.example.greenatom.exhandler.FileNotExist;
import org.example.greenatom.model.domain.File;
import org.example.greenatom.model.dto.FileDto;

import java.io.FileNotFoundException;

public interface FileService {
    Long saveFile(FileDto fileDto);
    FileDto getFile(Long id);
}
