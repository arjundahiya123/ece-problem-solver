package ece2238.eceproblemsolver;

public class ComplexNumber {

    private double real, imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public String toString() {
        return real + " + " + imaginary + "i";
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double newReal = this.real * other.real - this.imaginary * other.imaginary;
        double newImaginary = this.real * other.imaginary + this.imaginary * other.real;

        if(newReal == -0){newReal = 0;}
        return new ComplexNumber(newReal, newImaginary);
    }

    public ComplexNumber add(ComplexNumber other) {
        double newReal = this.real + other.real;
        double newImaginary = this.imaginary + other.imaginary;
        return new ComplexNumber(newReal, newImaginary);
    }

    //Add check that there are the same number of columns in every row of the matrix
    public static ComplexNumber[][] compMatrixMultiplication(ComplexNumber[][] mat1, ComplexNumber[][] mat2){

        if (mat1[0].length != mat2.length) {
            throw new IllegalArgumentException("Matrix multiplication is not possible. Column count of first matrix must match row count of second matrix.");
        }

        ComplexNumber[][] productMatrix = new ComplexNumber[mat1.length][mat2[0].length];

        for(int a = 0; a < mat1.length; a++){
            for(int b = 0; b < mat2[0].length; b++){
                ComplexNumber sum = new ComplexNumber(0,0);
                for(int c = 0; c < mat1[0].length; c++){
                    sum = sum.add(mat1[a][c].multiply(mat2[c][b]));
                }
                productMatrix[a][b] = sum;
            }
        }

        return productMatrix;
    }
}
