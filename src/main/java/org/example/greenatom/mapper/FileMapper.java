package org.example.greenatom.mapper;

import org.example.greenatom.model.domain.File;
import org.example.greenatom.model.dto.FileDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FileMapper {
    File dtoToEntity(FileDto dto);
    FileDto fileToDto(File file);
    List<FileDto> entityListToDtoList(List<File> files);
}
