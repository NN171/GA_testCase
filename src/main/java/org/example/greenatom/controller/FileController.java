package org.example.greenatom.controller;

import org.example.greenatom.dto.FileDto;
import org.example.greenatom.repository.FileRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/greenAtom/storage")
public class FileController {

    private final FileRepository fileRepository;

    public FileController(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @GetMapping(path = "/get")
    public FileDto getFile(@RequestParam(value = "id") Long id) {
        return fileRepository.getFileById(id);
    }

    @GetMapping(path = "/create")
    public Long createFile(@RequestBody FileDto fileDto) {
        fileRepository.createFileByFileDto(fileDto);
        return fileRepository.getIdByFileDto(fileDto);
    }
}
