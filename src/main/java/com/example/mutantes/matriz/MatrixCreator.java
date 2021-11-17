package com.example.mutantes.matriz;

import com.example.mutantes.exceptions.NonSquareMatrixException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@AllArgsConstructor
@Setter
@Getter
public class MatrixCreator {

    public char[][]hacerMatriz(String[] dna) throws NonSquareMatrixException {
        //convierte el array de strings en una matriz de caracteres
        try {
            if(dna.length == dna[0].length()){
                int n = dna.length;
                char[][] dnaMatriz = new char[n][n];
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < n; ++j) {
                        dnaMatriz[i][j] = dna[i].charAt(j % n);
                    }
                }
                return dnaMatriz;
            }else{
                throw new NonSquareMatrixException("La matriz ingresada no es cuadrada");
            }

        }catch(NonSquareMatrixException e){
            throw new NonSquareMatrixException(e.getMessage());
        }
    }
    //metodo sobrecargado
    public char[][] hacerMatriz(int n){

        //genera matriz con valores aleatorios pertenecientes a str, se puede cambiar por cualquier secuencia de caracteres
        String str = "ACGT";
        Random random = new Random();
        char[][] dnaMatriz = new char[n][n];

        //asigna cada valor a la matriz
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int randomInt = random.nextInt(str.length());
                dnaMatriz[i][j] = str.charAt(randomInt);
            }
        }
        return dnaMatriz;
    }
}
