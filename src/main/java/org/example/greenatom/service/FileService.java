package org.example.greenatom.service;

import org.example.greenatom.model.dto.FileDto;

import java.util.List;

public interface FileService {
    Long saveFile(FileDto fileDto);

    FileDto getFile(Long id);

    List<FileDto> getAllFiles(int pageNum, int pageSize);
}
