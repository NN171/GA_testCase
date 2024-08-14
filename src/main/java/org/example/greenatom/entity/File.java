package org.example.greenatom.entity;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
