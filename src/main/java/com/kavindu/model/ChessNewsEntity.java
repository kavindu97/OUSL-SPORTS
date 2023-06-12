package com.kavindu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChessNewsEntity {
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
