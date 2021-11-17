package com.example.mutantes.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "stats")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Stats extends Base{

    @Column(name = "mutantCount")
    private float mutantCount;

    @Column(name = "nonMutantCount")
    private float nonMutantCount;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime statsDate;

    @Column(name = "mutantRatio")
    private float mutantRatio;

}
