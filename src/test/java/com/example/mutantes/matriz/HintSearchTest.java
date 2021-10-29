package com.example.mutantes.matriz;

import org.junit.jupiter.api.*;

//shift alt d
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HintSearchTest {

    HintSearch search;

    @BeforeEach
    public void beforeEach(TestInfo testInfo){
        search = new HintSearch();
        System.out.println("Comienza: "+ testInfo.getDisplayName());
    }
    @AfterEach
    public void afterEach(TestInfo testInfo){
        System.out.println("Finaliza: "+ testInfo.getDisplayName());
        System.out.println("---------------------------------------");
    }

    @Test
    @Order(1)
    @DisplayName("Encuentra Mutante Horizontal Impar")
    public void testEncuentraMutanteHorizontalImpar(){
        //para matrices impares ej. 5x5
        char[][] matriz = {
            {'A', 'A', 'G', 'A', 'G'},
            {'G', 'T', 'T', 'A', 'G'},
            {'A', 'A', 'A', 'A', 'G'},
            {'T', 'G', 'G', 'G', 'G'},
            {'T', 'A', 'A', 'A', 'A'}
        };
        search.busqHoriz(matriz);
        System.out.println("Contador: "+ search.getContador());
        Assertions.assertEquals(2, search.getContador());
    }
    @Test
    @Order(2)
    @DisplayName("Encuentra Mutante Horizontal Par")
    public void testEncuentraMutanteHorizontalPar(){
        //para matrices pares ej. 6x6
        char[][] matriz = {
            {'A', 'A', 'A', 'T', 'G','A'},
            {'G', 'T', 'T', 'A', 'G','A'},
            {'A', 'A', 'A', 'G', 'G','A'},
            {'A', 'T', 'A', 'A', 'G','A'},
            {'A', 'A', 'G', 'G', 'G','G'},
            {'A', 'T', 'A', 'A', 'A','A'}
        };
        search.busqHoriz(matriz);
        System.out.println("Contador: "+ search.getContador());
        Assertions.assertEquals(2, search.getContador());
    }
    @Test
    @Order(3)
    @DisplayName("No Encuentra Mutante Horizontal Impar")
    public void testNoEncuentraMutanteHorizontal(){
        char[][] matriz = {
            {'A', 'G', 'T', 'A', 'G'},
            {'G', 'T', 'T', 'A', 'G'},
            {'A', 'A', 'T', 'A', 'G'},
            {'A', 'A', 'T', 'A', 'G'},
            {'A', 'A', 'T', 'A', 'G'}
        };
        search.busqHoriz(matriz);
        System.out.println("Contador: "+ search.getContador());
        Assertions.assertFalse(search.getContador() >= 2);
    }
    @Test
    @Order(4)
    @DisplayName("No Encuentra Mutante Horizontal Par")
    public void testNoEncuentraMutanteHorizontalPar(){
        //para matrices pares ej. 6x6
        char[][] matriz = {
            {'A', 'A', 'A', 'T', 'G','A'},
            {'G', 'T', 'T', 'A', 'G','A'},
            {'A', 'A', 'A', 'G', 'G','A'},
            {'A', 'T', 'A', 'A', 'G','A'},
            {'A', 'A', 'G', 'A', 'G','G'},
            {'A', 'T', 'A', 'T', 'A','A'}
        };
        search.busqHoriz(matriz);
        System.out.println("Contador: "+ search.getContador());
        Assertions.assertFalse(search.getContador() >= 2);
    }
    @Test
    @Order(5)
    @DisplayName("Encuentra Mutante Vertical Impar")
    public void testEncuentraMutanteVerticalImpar(){
        char[][] matriz = {
            {'A', 'G', 'G', 'T', 'G'},
            {'A', 'T', 'G', 'A', 'G'},
            {'T', 'A', 'T', 'A', 'G'},
            {'A', 'A', 'T', 'A', 'G'},
            {'G', 'A', 'T', 'A', 'T'}
        };
        search.busqVertical(matriz);
        System.out.println("Contador: "+ search.getContador());
        Assertions.assertEquals(2, search.getContador());
    }
    @Test
    @Order(6)
    @DisplayName("Encuentra Mutante Vertical Par")
    public void testEncuentraMutanteVerticalPar(){
        //para matrices pares ej. 6x6
        char[][] matriz = {
            {'A', 'A', 'A', 'T', 'T','A'},
            {'G', 'T', 'T', 'A', 'T','A'},
            {'A', 'A', 'A', 'G', 'G','A'},
            {'T', 'T', 'A', 'A', 'G','A'},
            {'A', 'A', 'G', 'G', 'G','G'},
            {'A', 'T', 'A', 'A', 'G','A'}
        };
        search.busqVertical(matriz);
        System.out.println("Contador: "+ search.getContador());
        Assertions.assertEquals(2, search.getContador());
    }
    @Test
    @Order(7)
    @DisplayName("No Encuentra Mutante Vertical Impar")
    public void testNoEncuentraMutanteVerticalImpar(){
        char[][] matriz = {
            {'A', 'G', 'G', 'T', 'G'},
            {'T', 'T', 'G', 'A', 'G'},
            {'A', 'A', 'G', 'T', 'T'},
            {'A', 'A', 'T', 'A', 'G'},
            {'G', 'A', 'T', 'A', 'T'}
        };
        search.busqVertical(matriz);
        System.out.println("Contador: "+ search.getContador());
        Assertions.assertFalse(search.getContador() >= 2);
    }
    @Test
    @Order(8)
    @DisplayName("No Encuentra Mutante Vertical Par")
    public void testNoEncuentraMutanteVerticalPar(){
        //para matrices pares ej. 6x6
        char[][] matriz = {
            {'A', 'A', 'A', 'T', 'G','A'},
            {'G', 'T', 'T', 'A', 'G','T'},
            {'A', 'A', 'A', 'G', 'G','C'},
            {'A', 'T', 'A', 'A', 'C','A'},
            {'C', 'A', 'G', 'A', 'C','G'},
            {'A', 'T', 'A', 'T', 'A','A'}
        };
        search.busqVertical(matriz);
        System.out.println("Contador: "+ search.getContador());
        Assertions.assertFalse(search.getContador() >= 2);
    }

    @Test
    @Order(9)
    @DisplayName("Encuentra Mutante Diagonal Impar")
    public void testEncuentraMutanteDiagonalImpar(){
        char[][] matriz = {
            {'A', 'G', 'G', 'T', 'G'},
            {'A', 'A', 'G', 'A', 'G'},
            {'A', 'A', 'T', 'G', 'G'},
            {'A', 'A', 'A', 'A', 'G'},
            {'G', 'A', 'A', 'A', 'T'}
        };
        search.busqDiagonal(matriz);
        System.out.println("Contador: "+ search.getContador());
        Assertions.assertEquals(2, search.getContador());
    }
    @Test
    @Order(10)
    @DisplayName("Encuentra Mutante Diagonal Par")
    public void testEncuentraMutanteDiagonalPar(){
        char[][] matriz = {
            {'A', 'A', 'G', 'T', 'G','A'},
            {'G', 'T', 'G', 'G', 'G','T'},
            {'A', 'A', 'A', 'A', 'G','C'},
            {'A', 'T', 'G', 'A', 'G','G'},
            {'C', 'A', 'A', 'A', 'A','A'},
            {'A', 'T', 'A', 'T', 'G','A'}
        };
        search.busqDiagonal(matriz);
        System.out.println("Contador: "+ search.getContador());
        Assertions.assertEquals(2, search.getContador());
    }
    @Test
    @Order(11)
    @DisplayName("No Encuentra Mutante Diagonal Impar")
    public void testNoEncuentraMutanteDiagonalImpar(){
        char[][] matriz = {
            {'T', 'G', 'G', 'T', 'G'},
            {'A', 'A', 'A', 'A', 'G'},
            {'A', 'G', 'T', 'G', 'G'},
            {'A', 'A', 'A', 'A', 'T'},
            {'G', 'A', 'T', 'G', 'T'}
        };
        search.busqDiagonal(matriz);
        System.out.println("Contador: "+ search.getContador());
        Assertions.assertFalse(search.getContador() >= 2);
    }
    @Test
    @Order(12)
    @DisplayName("No Encuentra Mutante Diagonal Par")
    public void testNoEncuentraMutanteDiagonalPar(){
        char[][] matriz = {
            {'A', 'A', 'G', 'T', 'G','A'},
            {'G', 'T', 'G', 'A', 'G','T'},
            {'A', 'A', 'A', 'A', 'G','C'},
            {'A', 'T', 'G', 'T', 'G','A'},
            {'C', 'A', 'A', 'A', 'A','A'},
            {'A', 'T', 'A', 'T', 'G','T'}
        };
        search.busqDiagonal(matriz);
        System.out.println("Contador: "+ search.getContador());
        Assertions.assertFalse(search.getContador() >= 2);
    }
    @Test
    @Order(13)
    @DisplayName("Encuentra Mutante Diagonal Inversa Impar")
    public void testEncuentraMutanteDiagonalInversaImpar(){
        char[][] matriz = {
            {'T', 'G', 'G', 'T', 'G'},
            {'A', 'T', 'T', 'T', 'G'},
            {'A', 'T', 'G', 'G', 'G'},
            {'T', 'T', 'G', 'A', 'G'},
            {'G', 'G', 'T', 'A', 'A'}
        };
        search.busqDiagonalInv(matriz);
        System.out.println("Contador: "+ search.getContador());
        Assertions.assertEquals(2, search.getContador());
    }
    @Test
    @Order(14)
    @DisplayName("Encuentra Mutante Diagonal Inversa Par")
    public void testEncuentraMutanteDiagonalInversaPar(){
        char[][] matriz = {
            {'A', 'A', 'G', 'T', 'G','A'},
            {'G', 'T', 'T', 'A', 'G','T'},
            {'A', 'T', 'G', 'A', 'G','C'},
            {'T', 'A', 'G', 'T', 'C','A'},
            {'G', 'A', 'G', 'C', 'A','A'},
            {'G', 'T', 'C', 'T', 'G','T'}
        };
        search.busqDiagonalInv(matriz);
        System.out.println("Contador: "+ search.getContador());
        Assertions.assertEquals(2, search.getContador());
    }
    @Test
    @Order(15)
    @DisplayName("No Encuentra Mutante Diagonal Inversa Impar")
    public void testNoEncuentraMutanteDiagonalInversaImpar(){
        char[][] matriz = {
            {'T', 'G', 'G', 'T', 'G'},
            {'A', 'T', 'G', 'A', 'G'},
            {'A', 'T', 'G', 'A', 'G'},
            {'G', 'A', 'G', 'A', 'G'},
            {'G', 'A', 'T', 'A', 'A'}
        };
        search.busqDiagonalInv(matriz);
        System.out.println("Contador: "+ search.getContador());
        Assertions.assertFalse(search.getContador() >= 2);
    }
    @Test
    @Order(16)
    @DisplayName("No Encuentra Mutante Diagonal Inversa Par")
    public void testNoEncuentraMutanteDiagonalInversaPar(){
        char[][] matriz = {
            {'A', 'A', 'G', 'T', 'G','A'},
            {'G', 'T', 'G', 'A', 'G','T'},
            {'A', 'T', 'G', 'A', 'G','C'},
            {'G', 'A', 'G', 'T', 'G','A'},
            {'G', 'A', 'G', 'C', 'A','A'},
            {'G', 'T', 'G', 'T', 'G','T'}
        };
        search.busqDiagonalInv(matriz);
        System.out.println("Contador: "+ search.getContador());
        Assertions.assertFalse(search.getContador() >= 2);
    }
}
