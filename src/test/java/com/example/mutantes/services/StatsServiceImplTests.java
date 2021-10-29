package com.example.mutantes.services;

import com.example.mutantes.entities.Stats;
import com.example.mutantes.repositories.StatsRepository;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StatsServiceImplTests {
    StatsServiceImpl service;

    @MockBean
    StatsRepository repository;

    @BeforeEach
    public void beforeEach(TestInfo testInfo){
        service = new StatsServiceImpl(repository);
        System.out.println("Comienza: "+ testInfo.getDisplayName());
    }
    @AfterEach
    public void afterEach(TestInfo testInfo){
        System.out.println("Finaliza: "+ testInfo.getDisplayName());
        System.out.println("---------------------------------------");
    }
    @Test
    @Order(1)
    @DisplayName("Test Calcular Stats")
    public void testCalcularStats(){
        Stats stats = new Stats();
        float div = (float)4/5;
        stats.setMutantCount(4);
        stats.setNonMutantCount(5);
        stats.setMutantRatio((div));
        stats.setStatsDate(LocalDateTime.now());

        Assertions.assertEquals(stats.getMutantRatio(), 0.800000011920929);
    }
}
