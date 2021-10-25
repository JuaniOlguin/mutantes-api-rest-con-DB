package com.example.mutantes.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "stats")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
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
