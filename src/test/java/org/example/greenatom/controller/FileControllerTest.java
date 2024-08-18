package org.example.greenatom.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.greenatom.model.domain.File;
import org.example.greenatom.model.dto.FileDto;
import org.example.greenatom.service.FileService;
import org.example.greenatom.service.impl.FileServiceImplTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FileControllerTest {

    @Mock
    private FileService fileService;

    @InjectMocks
    private FileController fileController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(fileController).build();
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    public void controllerGetFile() throws Exception {
        FileDto fileDto = FileServiceImplTest.fileStore().get(0);

        Mockito.when(fileService.getFile(1L)).thenReturn(fileDto);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/greenatom/storage/get/file")
                        .param("id", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(fileService, Mockito.times(1)).getFile(1L);
    }

    @Test
    public void createFile() throws Exception {
        FileDto fileDto = FileServiceImplTest.fileStore().get(0);
        File file = new File(
                1L,
                "firstFileContent",
                "firstFile",
                LocalDateTime.parse("2024-08-16 11:21:13", FileServiceImplTest.df),
                "firstFileDescription");
        String fileDtoJson = objectMapper.writeValueAsString(fileDto);

        Mockito.when(fileService.saveFile(fileDto)).thenReturn(file.getId());
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/greenatom/storage/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(fileDtoJson))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(fileService, Mockito.times(1)).saveFile(fileDto);
    }

    @Test
    public void getFiles() throws Exception {
        List<FileDto> list = FileServiceImplTest.fileStore();

        Mockito.when(fileService.getAllFiles(0, 10)).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/greenatom/storage/get")
                        .param("pageNum", "0")
                        .param("pageSize", "10"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(fileService, Mockito.times(1)).getAllFiles(0, 10);
    }
}
