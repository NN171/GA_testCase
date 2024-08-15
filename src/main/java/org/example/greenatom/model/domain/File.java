package org.example.greenatom.model.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Data
@ToString
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "file_data")
    private String fileData;

    @Column
    private String title;

    @Column(name = "creation_date")
    private String creationDate;

    @Column
    private String description;

}
