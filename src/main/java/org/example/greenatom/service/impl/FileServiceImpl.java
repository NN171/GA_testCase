package org.example.greenatom.service.impl;

import jakarta.transaction.Transactional;
import org.example.greenatom.exhandler.FileNotExist;
import org.example.greenatom.mapper.FileMapper;
import org.example.greenatom.model.domain.File;
import org.example.greenatom.model.dto.FileDto;
import org.example.greenatom.repository.FileRepository;
import org.example.greenatom.service.FileService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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
        File file = fileMapper.dtoToEntity(fileDto);
        fileRepository.save(file);
        return file.getId();
    }

    @Override
    public FileDto getFile(Long id) {
        File file = fileRepository.findById(id).orElseThrow(() -> new FileNotExist(String.format("Файл %s не существует", id)));
        return fileMapper.fileToDto(file);
    }

    @Override
    public List<FileDto> getAllFiles(int pageNum, int pageSize) {
        Pageable sortedByDateCreation = PageRequest.of(pageNum, pageSize, Sort.by("creationDate").descending());
        Page<File> page = fileRepository.findAll(sortedByDateCreation);
        return fileMapper.filesToDtoList(page.getContent());
    }
}
