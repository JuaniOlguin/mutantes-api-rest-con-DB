package com.example.mutantes.matriz;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MatrixCreatorTest {
    MatrixCreator matrixCreator;

    @BeforeEach
    public void beforeEach(TestInfo testInfo){
        matrixCreator = new MatrixCreator();
        System.out.println("Comienza: "+ testInfo.getDisplayName());
    }
    @AfterEach
    public void afterEach(TestInfo testInfo){
        System.out.println("Finaliza: "+ testInfo.getDisplayName());
        System.out.println("---------------------------------------");
    }

    @Test
    @Order(1)
    @DisplayName("Crear Matriz A Partir de un String[]")
    public void testCreaMatrizConStringArray(){
        String[] array = {"AAGAG","GTTAG","AAAAG","TGGGG","TAAAA"};
        char[][] matriz = {
            {'A', 'A', 'G', 'A', 'G'},
            {'G', 'T', 'T', 'A', 'G'},
            {'A', 'A', 'A', 'A', 'G'},
            {'T', 'G', 'G', 'G', 'G'},
            {'T', 'A', 'A', 'A', 'A'}
        };
        char[][] matrizTest = matrixCreator.hacerMatriz(array);
        Assertions.assertArrayEquals(matriz, matrizTest);
    }
    @Test
    @Order(2)
    @DisplayName("Crear Matriz Aleatoria")
    public void testCrearMatrizAleatoria(){
        int n = 5;
        char[][] matriz = {
            {'A', 'A', 'G', 'A', 'G'},
            {'G', 'T', 'T', 'A', 'G'},
            {'A', 'A', 'A', 'A', 'G'},
            {'T', 'G', 'G', 'G', 'G'},
            {'T', 'A', 'A', 'A', 'A'}
        };
        char[][] matrizTest = matrixCreator.hacerMatriz(n);
        Assertions.assertEquals(matriz.length, matrizTest.length);
    }
}
