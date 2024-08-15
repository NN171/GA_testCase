package org.example.greenatom.controller;

import lombok.SneakyThrows;
import org.example.greenatom.exhandler.FileNotExist;
import org.example.greenatom.model.domain.File;
import org.example.greenatom.model.dto.FileDto;
import org.example.greenatom.service.FileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@RestController
@RequestMapping(path = "api/greenatom/storage")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping(path = "/get")
    public ResponseEntity<?> getFile(@RequestParam(value = "id") Long id) throws FileNotExist {
        return ResponseEntity.ok(fileService.getFile(id));
    }

    @PutMapping(path = "/create")
    public ResponseEntity<?> createFile(@RequestBody FileDto fileDto) {
        return ResponseEntity.ok(fileService.saveFile(fileDto));
    }
}
