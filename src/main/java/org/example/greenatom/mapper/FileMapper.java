package org.example.greenatom.mapper;

import org.example.greenatom.model.domain.File;
import org.example.greenatom.model.dto.FileDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileMapper {
    File toEntity(FileDto destination);
    FileDto toDto(File source);
}
