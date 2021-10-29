package com.example.mutantes.services;

import com.example.mutantes.entities.RegistroDna;
import com.example.mutantes.repositories.RegistroDnaRepository;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.mock.mockito.MockBean;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RegistroDnaServiceImplTests {
    RegistroDnaServiceImpl service;

    @MockBean
    RegistroDnaRepository repository;

    @BeforeEach
    public void beforeEach(TestInfo testInfo){
        service = new RegistroDnaServiceImpl(repository);
        System.out.println("Comienza: "+ testInfo.getDisplayName());
    }
    @AfterEach
    public void afterEach(TestInfo testInfo){
        System.out.println("Finaliza: "+ testInfo.getDisplayName());
        System.out.println("---------------------------------------");
    }

    @Test
    @Order(1)
    @DisplayName("Test Servicio Encuentra Mutante")
    public void testServiceEncuentraMutante(){
        String[] array = {"AAGAG","GTTAG","AAAAG","TGGGG","TAAAA"};
        boolean isMutant = false;
        RegistroDna registroDna = new RegistroDna();
        registroDna.setDna(array);

        try{
            isMutant = service.isMutant(registroDna);
            Assertions.assertTrue(isMutant);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    @Test
    @Order(2)
    @DisplayName("Test Servicio No Encuentra Mutante")
    public void testServiceNoEncuentraMutante(){
        String[] array = {"AAGAG","GTTAG","AATAG","TGGGT","TAAAA"};
        boolean isMutant = false;
        RegistroDna registroDna = new RegistroDna();
        registroDna.setDna(array);

        try{
            isMutant = service.isMutant(registroDna);
            Assertions.assertFalse(isMutant);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
