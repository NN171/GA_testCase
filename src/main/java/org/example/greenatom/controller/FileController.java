package org.example.greenatom.controller;

import org.example.greenatom.model.dto.FileDto;
import org.example.greenatom.service.FileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/greenatom/storage")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping(path = "/get/file")
    public ResponseEntity<FileDto> getFile(@RequestParam(value = "id") Long id) {
        return ResponseEntity.ok(fileService.getFile(id));
    }

    @PostMapping(path = "/create")
    public ResponseEntity<String> createFile(@RequestBody FileDto fileDto) {
        return ResponseEntity.ok(String.format("Файл %s успешно создан", fileService.saveFile(fileDto).toString()));
    }

    @GetMapping(path = "/get")
    public ResponseEntity<List<FileDto>> getFiles(@RequestParam(defaultValue = "0") int pageNum,
                                                  @RequestParam(defaultValue = "5") int pageSize) {
        return ResponseEntity.ok(fileService.getAllFiles(pageNum, pageSize));
    }
}
