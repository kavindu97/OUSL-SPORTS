package com.kavindu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CricketNewsEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String content;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String img;
}

