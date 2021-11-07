package org.example.petProject.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "photo_table")
@Data
@AttributeOverrides(@AttributeOverride(name = "id", column = @Column(name = "id")))
public class PhotoResponse {
    @Id
    private Long id;

    @Column(name = "path_to_photo")
    private String pathToPhoto;

}