package org.example.greenatom.mapper;

import org.example.greenatom.model.domain.File;
import org.example.greenatom.model.dto.FileDto;
import org.mapstruct.Mapper;

@Mapper
public interface FileMapper {
    FileDto sourceToDestination(File source);
    File destinationToSource(FileDto destination);
}
