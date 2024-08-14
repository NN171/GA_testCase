package org.example.greenatom.controller;

import org.example.greenatom.dto.FileDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/greenAtom")
public class FileController {

    @GetMapping(path = "/create")
    public String getFile(@RequestBody FileDto fileDto) {
        return "Hello World";
    };
}
