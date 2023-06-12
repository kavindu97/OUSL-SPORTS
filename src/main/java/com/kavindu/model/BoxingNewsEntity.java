package com.kavindu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class BoxingNewsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String title;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String content;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String img;

}
