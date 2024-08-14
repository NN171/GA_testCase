package org.example.greenatom.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileDto {
    private String fileData;

    @JsonProperty("title")
    private String title;

    @JsonProperty("creation_date")
    private String creationDate;

    @JsonProperty("description")
    private String description;
}
