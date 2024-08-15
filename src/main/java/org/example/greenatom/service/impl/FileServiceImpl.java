package org.example.greenatom.service.impl;

import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import org.example.greenatom.exhandler.FileNotExist;
import org.example.greenatom.mapper.FileMapper;
import org.example.greenatom.model.domain.File;
import org.example.greenatom.model.dto.FileDto;
import org.example.greenatom.repository.FileRepository;
import org.example.greenatom.service.FileService;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {
    private final FileRepository fileRepository;
    private final FileMapper fileMapper;

    public FileServiceImpl(FileRepository fileRepository, FileMapper fileMapper) {
        this.fileRepository = fileRepository;
        this.fileMapper = fileMapper;
    }

    @Override
    @Transactional
    public Long saveFile(FileDto fileDto) {
        File file = fileMapper.toEntity(fileDto);
        return fileRepository.save(file).getId();
    }

    @Override
    public File getFile(Long id) throws FileNotExist {
        return fileRepository.findById(id).orElseThrow(() -> new FileNotExist(id.toString()));
    }
}
