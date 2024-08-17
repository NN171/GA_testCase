package org.example.greenatom.service.impl;

import org.example.greenatom.mapper.FileMapper;
import org.example.greenatom.model.domain.File;
import org.example.greenatom.model.dto.FileDto;
import org.example.greenatom.repository.FileRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FileServiceImplTest {

    private final DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Mock
    private FileRepository fileRepository;

    @Mock
    private FileMapper fileMapper;

    @InjectMocks
    private FileServiceImpl fileService;

    @BeforeEach
    public void setUp() {
        fileService = new FileServiceImpl(fileRepository, fileMapper);
    }

    @Test
    public void saveFile() {
        FileDto fileDto = fileStore().get(0);
        File file = new File(
                null,
                "firstFileContent",
                "firstFile",
                LocalDateTime.parse("2024-08-16 11:21:13", df),
                "firstFileDescription");

        Mockito.when(fileMapper.dtoToEntity(fileDto)).thenReturn(file);
        Mockito.when(fileRepository.save(file)).thenReturn(new File(
                1L,
                "firstFileContent",
                "firstFile",
                LocalDateTime.parse("2024-08-16 11:21:13", df),
                "firstFileDescription"));

        Long id = fileService.saveFile(fileDto);

        Mockito.verify(fileRepository).save(file);
        Assertions.assertEquals(id, file.getId());
    }

    @Test
    public void getFile() {

    }

    public List<FileDto> fileStore() {

        FileDto firstFile = new FileDto(
                "firstFileContent",
                "firstFile",
                LocalDateTime.parse("2024-08-16 11:21:13", df),
                "firstFileDescription");

        FileDto secondFile = new FileDto(
                "secondFileContent",
                "secondFile",
                LocalDateTime.parse("2024-08-16 11:30:44", df),
                "secondFileDescription");

        FileDto thirdFile = new FileDto(
                "thirdFileContent",
                "thirdFile",
                LocalDateTime.parse("2024-08-15 12:05:25", df),
                "thirdFileDescription");
        return List.of(firstFile, secondFile, thirdFile);
    }
}
