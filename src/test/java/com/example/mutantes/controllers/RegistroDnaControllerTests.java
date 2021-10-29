package com.example.mutantes.controllers;



import com.example.mutantes.entities.RegistroDna;
import com.example.mutantes.services.RegistroDnaServiceImpl;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;



//mock when(repository.metodo(param)).thenReturn(retorno)

@WebMvcTest (RegistroDnaController.class) //test ejecutado mediante un acceso web
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RegistroDnaControllerTests {

    @MockBean
    private RegistroDnaServiceImpl servicio;

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
    @DisplayName("Controller Detect Encuentra Mutante")
    public void testDetectEncuentraMutante(){

        String json = "{ \"dna\": [\"AAGAG\",\"GTTAG\",\"AAAAG\",\"TGGGG\",\"TAAAA\"] }";

        try{
            when(servicio.isMutant(any(RegistroDna.class))).thenReturn(true);

            mockMvc.perform(post("/api/tpa/mutant/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());
            verify(servicio).isMutant(any(RegistroDna.class));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    @Test
    @Order(2)
    @DisplayName("Controller Detect No Encuentra Mutante")
    public void testDetectNoEncuentraMutante(){
        String json = "{ \"dna\": [\"AAGAG\",\"GTTAG\",\"AACAT\",\"TGTGG\",\"TAAAT\"], \"mutant\": false }";

        try{
            when(servicio.isMutant(any(RegistroDna.class))).thenReturn(false);

            mockMvc.perform(post("/api/tpa/mutant/")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json))
                .andExpect(MockMvcResultMatchers.status().isForbidden());
            System.out.println("Mutante no encontrado");
            verify(servicio).isMutant(any(RegistroDna.class));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    @Test
    @Order(3)
    @DisplayName("Controller Detect Arroja Excepcion")
    public void testDetectArrojaExcepcion(){
        String json = "{}";
        Exception exc;
        try{
            when(servicio.isMutant(any(RegistroDna.class))).thenThrow(exc = new Exception("Ocurrio un error"));

            mockMvc.perform(post("/api/tpa/mutant/")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
            System.out.println(exc.getMessage());
            verify(servicio).isMutant(any(RegistroDna.class));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
