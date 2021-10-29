package com.example.mutantes.matriz;


import org.junit.jupiter.api.*;

public class MutantDetectorTest {
    MutantDetector detector;
    HintSearch search = new HintSearch();
    @BeforeEach
    public void beforeEach(TestInfo testInfo){
        detector = new MutantDetector(search);
        System.out.println("Comienza: "+ testInfo.getDisplayName());
    }
    @AfterEach
    public void afterEach(TestInfo testInfo){
        System.out.println("Finaliza: "+ testInfo.getDisplayName());
        System.out.println("---------------------------------------");
    }
    @Test
    @Order(1)
    @DisplayName("Detectar un Mutante")
    public void testEncuentraMutante(){
        char[][] matriz = {
            {'A', 'G', 'T', 'A', 'G'},
            {'G', 'T', 'T', 'A', 'A'},
            {'A', 'G', 'A', 'A', 'G'},
            {'A', 'A', 'A', 'A', 'T'},
            {'A', 'A', 'T', 'A', 'G'}
        };
        Assertions.assertTrue(detector.isMutant(matriz));
    }
    @Test
    @Order(2)
    @DisplayName("No Detectar un Mutante")
    public void testNoEncuentraMutante(){
        char[][] matriz = {
            {'A', 'G', 'T', 'G', 'G'},
            {'G', 'T', 'T', 'A', 'A'},
            {'A', 'G', 'T', 'A', 'G'},
            {'A', 'A', 'A', 'T', 'T'},
            {'A', 'A', 'T', 'A', 'G'}
        };

        Assertions.assertFalse(detector.isMutant(matriz));
    }
}
