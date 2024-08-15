package org.example.greenatom.controller;

import lombok.SneakyThrows;
import org.example.greenatom.model.domain.File;
import org.example.greenatom.model.dto.FileDto;
import org.example.greenatom.service.FileService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/greenAtom/storage")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @SneakyThrows
    @GetMapping(path = "/get")
    public File getFile(@RequestParam(value = "id") Long id) {
        return fileService.getFile(id);
    }

    @GetMapping(path = "/create")
    public Long createFile(@RequestBody FileDto fileDto) {
        return fileService.saveFile(fileDto);
    }
}
