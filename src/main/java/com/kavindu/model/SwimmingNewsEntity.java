package com.kavindu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SwimmingNewsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String title;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private  String content;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private  String img;
}
