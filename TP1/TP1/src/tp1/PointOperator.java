package tp1;

import java.util.*;

public final class PointOperator {

    // TODO appliquer la translation sur le vecteur d'entree.
    public static void translate(Double[] vector, Double[] translateVector) {
        // ...
        for(int i = 0; i<vector.length;i++)
        {
            vector[i]=vector[i]+translateVector[i];

        }

    }

    // TODO appliquer la translation sur le vecteur d'entree.
    public static void rotate(Double[] vector, Double[][] rotationMatrix) {
        // ...
        Double[] vectorBis = new Double[vector.length];
        if(vector.length == rotationMatrix.length) {
            for (int i = 0; i < rotationMatrix.length; i++) {
                double sum = 0.0;
                for (int j = 0; j < rotationMatrix.length; j++)
                    sum += rotationMatrix[i][j] * vector[j];
                vectorBis[i]=sum; }
            for(int k = 0; k< vector.length;k++)
            {
                vector[k]=vectorBis[k];
            }
        }
    }

    // TODO appliquer la translation sur le vecteur d'entree.
    public static void divide(Double[] vector, Double divider) {
        // ...
        for(int i = 0; i<vector.length;i++)
        {
            vector[i]=vector[i]/divider;

        }
    }

    // TODO appliquer la translation sur le vecteur d'entree.
    public static void multiply(Double[] vector, Double multiplier) {
        // ...
        for(int i = 0; i<vector.length;i++)
        {
            vector[i]=vector[i]*multiplier;

        }
    }

    // TODO appliquer la translation sur le vecteur d'entree.
    public static void add(Double[] vector, Double adder) {
        // ...
        for(int i = 0; i<vector.length;i++)
        {
            vector[i]=vector[i]+adder;

        }
    }
}
