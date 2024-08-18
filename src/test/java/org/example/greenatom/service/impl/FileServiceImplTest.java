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
import org.springframework.data.domain.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class FileServiceImplTest {

    public static final DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

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
        Long id = 1L;
        FileDto fileDto = fileStore().get(0);
        File file = new File(
                id,
                "firstFileContent",
                "firstFile",
                LocalDateTime.parse("2024-08-16 11:21:13", df),
                "firstFileDescription");

        Mockito.when(fileRepository.findById(id)).thenReturn(Optional.of(file));
        Mockito.when(fileMapper.fileToDto(file)).thenReturn(fileDto);

        FileDto result = fileService.getFile(id);

        Mockito.verify(fileRepository).findById(id);
        Assertions.assertEquals(result, fileDto);
    }

    @Test
    public void getAllFiles() {
        int pageNo = 0;
        int pageSize = 10;

        List<FileDto> files = fileStore();

        File firstFile = new File(
                1L,
                "firstFileContent",
                "firstFile",
                LocalDateTime.parse("2024-08-16 11:31:13", df),
                "firstFileDescription");

        File secondFile = new File(
                2L,
                "secondFileContent",
                "secondFile",
                LocalDateTime.parse("2024-08-16 11:30:44", df),
                "secondFileDescription");

        File thirdFile = new File(
                3L,
                "thirdFileContent",
                "thirdFile",
                LocalDateTime.parse("2024-08-15 12:05:25", df),
                "thirdFileDescription");

        Page<File> page = new PageImpl<>(List.of(firstFile, secondFile, thirdFile));
        Pageable sortedByDate = PageRequest.of(pageNo, pageSize, Sort.by("creationDate").descending());

        Mockito.when(fileRepository.findAll(sortedByDate)).thenReturn(page);

        List<File> listOfFiles = page.getContent();

        FileDto firstDto = new FileDto(
                "firstFileContent",
                "firstFile",
                LocalDateTime.parse("2024-08-16 11:31:13", df),
                "firstFileDescription");

        FileDto secondDto = new FileDto(
                "secondFileContent",
                "secondFile",
                LocalDateTime.parse("2024-08-16 11:30:44", df),
                "secondFileDescription");


        FileDto thirdDto = new FileDto(
                "thirdFileContent",
                "thirdFile",
                LocalDateTime.parse("2024-08-15 12:05:25", df),
                "thirdFileDescription");

        List<FileDto> listOfDto = List.of(secondDto, firstDto, thirdDto);
        Mockito.when(fileMapper.filesToDtoList(listOfFiles)).thenReturn(listOfDto);

        List<FileDto> result = fileService.getAllFiles(pageNo, pageSize);

        Mockito.verify(fileRepository).findAll(sortedByDate);
        Mockito.verify(fileMapper).filesToDtoList(listOfFiles);
        Assertions.assertEquals(result, listOfDto);
    }

    public static List<FileDto> fileStore() {

        FileDto firstFile = new FileDto(
                "firstFileContent",
                "firstFile",
                LocalDateTime.parse("2024-08-16 11:31:13", df),
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
