package org.example.petProject.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "test_table")
@Data
@AttributeOverrides(@AttributeOverride(name = "id", column = @Column(name = "index")))
public class BaseResponse {
    @Id
    private Long id;

    @Column(name = "value")
    private Integer value;

    @Column(name = "description")
    private String description;

}
