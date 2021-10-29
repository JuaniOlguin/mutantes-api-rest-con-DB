package com.example.mutantes.controllers;

import com.example.mutantes.entities.RegistroDna;
import com.example.mutantes.entities.Stats;
import com.example.mutantes.services.StatsServiceImpl;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.time.LocalDateTime;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(StatsController.class) //test ejecutado mediante un acceso web
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StatsControllerTests {
    @MockBean
    private StatsServiceImpl servicio;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void beforeEach(TestInfo testInfo){
        System.out.println("Comienza: "+ testInfo.getDisplayName());
    }
    @AfterEach
    public void afterEach(TestInfo testInfo){
        System.out.println("Finaliza: "+ testInfo.getDisplayName());
        System.out.println("---------------------------------------");
    }

    @Test
    @Order(1)
    @DisplayName("Controller Calcular Stats")
    public void testStatsControllerCalcular(){
        try{
            LocalDateTime date = LocalDateTime.now();
            Stats stats = new Stats(4, 5, date, (float)0.8);

            when(servicio.calcularStats()).thenReturn(stats);

            mockMvc.perform(get("/api/tpa/stats/calcular/")
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
            verify(servicio).calcularStats();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    @Test
    @Order(2)
    @DisplayName("Controller Calcular Stats Exception")
    public void testStatsControllerCalcularException(){
        try{
            Exception exc;

            when(servicio.calcularStats()).thenThrow(exc = new Exception("Ocurrio un error"));

            mockMvc.perform(get("/api/tpa/stats/calcular/")
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
            verify(servicio).calcularStats();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
