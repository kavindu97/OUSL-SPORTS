package com.kavindu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class BadmintonNewsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String content;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String img;
}
