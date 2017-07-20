package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class Matrix {
    private double[][] matrix;
    private int rows;
    private int columns;

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        matrix = new double[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = new double[columns];
        }
    }

    /**
     * Input elements of matrix from console
     */
    public void consoleInput() {
        Scanner inputStream = new Scanner(System.in);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                matrix[i][j] = Double.parseDouble(inputStream.nextLine());
            }
        }
    }

    /**
     * Input elements of matrix from the file
     * @param filePath path to file with matrix'es elements
     * @throws IOException
     */
    public void fileInput(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
        int i = 0;
        while (reader.ready()) {
            String[] row = reader.readLine().split(" ");
            for (int j = 0; j < row.length; j++) {
                matrix[i][j] = Double.parseDouble(row[j]);
            }
            i++;
        }
    }

    /**
     * Matrix with random elements
     * @param limit sets limit of generated numbers
     */
    public void randomMatrix(int limit) {
        Random random = new Random();
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                matrix[i][j] = random.nextInt(limit);
            }
        }
    }

    /**
     * Multiply matrix on number
     * @param number
     */
    public void matrixMultiply(double number) {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                this.matrix[i][j] *= number;
            }
        }
    }

    /**
     * Adds two matrix
     * @param matrix
     * @return resulting matrix
     */
    public Matrix addition(Matrix matrix) {
        if(this.rows == matrix.getRows() && this.columns == matrix.getColumns()) {
            Matrix newMatrix = new Matrix(this.rows, this.columns);
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.columns; j++) {
                    newMatrix.getMatrix()[i][j] = this.matrix[i][j] + matrix.getMatrix()[i][j];
                }
            }
            return newMatrix;
        } else {
            int newRows = Math.min(this.rows, matrix.getRows());
            int newColumns = Math.min(this.columns, matrix.getColumns());
            Matrix newMatrix = new Matrix(newRows, newColumns);
            for (int i = 0; i < newRows; i++) {
                for (int j = 0; j < newColumns; j++) {
                    newMatrix.getMatrix()[i][j] = this.matrix[i][j] + matrix.getMatrix()[i][j];
                }
            }
            return newMatrix;
        }
    }

    /**
     * Subtracts one matrix from another
     * @param matrix
     * @return resulting matrix
     */
    public Matrix subtraction(Matrix matrix) {
        if(this.rows == matrix.getRows() && this.columns == matrix.getColumns()) {
            Matrix newMatrix = new Matrix(this.rows, this.columns);
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.columns; j++) {
                    newMatrix.getMatrix()[i][j] = this.matrix[i][j] - matrix.getMatrix()[i][j];
                }
            }
            return newMatrix;
        } else {
            int newRows = Math.min(this.rows, matrix.getRows());
            int newColumns = Math.min(this.columns, matrix.getColumns());
            Matrix newMatrix = new Matrix(newRows, newColumns);
            for (int i = 0; i < newRows; i++) {
                for (int j = 0; j < newColumns; j++) {
                    newMatrix.getMatrix()[i][j] = this.matrix[i][j] - matrix.getMatrix()[i][j];
                }
            }
            return newMatrix;
        }
    }

    /**
     * Transposes a matrix
     * @return transpose matrix
     */
    public Matrix transpose() {
        Matrix newMatrix = new Matrix(this.columns, this.rows);
        for (int i = 0; i < this.columns; i++) {
            for (int j = 0; j < this.rows; j++) {
                newMatrix.getMatrix()[i][j] = this.matrix[j][i];
            }
        }
        return newMatrix;
    }

    /**
     * Print main diagonal of matrix
     */
    public void mainDiagonal() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                if(i == j) System.out.print((int)matrix[i][j] + " ");
            }
        }
    }

    /**
     * Multiplies the matrix by a matrix
     * @param matrix input matrix
     * @return resulting matrix
     */
    public Matrix multiply(Matrix matrix) {
        if(this.columns == matrix.getRows()) {
            Matrix newMatrix = new Matrix(this.rows, matrix.getColumns());
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < matrix.getColumns(); j++) {
                    int sum = 0;
                    for (int k = 0; k < matrix.getRows(); k++) {
                        sum += this.matrix[i][k] * matrix.getMatrix()[k][j];
                        newMatrix.getMatrix()[i][j] = sum;
                    }
                }
            }
            return newMatrix;
        } else {
            throw new NullPointerException("The number of columns of the first matrix must be equals the number of rows of the second matrix.");
        }
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                str += (int)matrix[i][j] + " ";
            }
            str += "\n";
        }
        return str;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + (this.rows + this.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                result = prime * result + (int)matrix[i][j];
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Matrix other = (Matrix) obj;
        if(this.rows != other.getRows()) return false;
        if(this.columns != other.getColumns()) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        Matrix matrix = new Matrix(3, 3);
        matrix.fileInput("resources/file.txt");
        System.out.print(matrix.toString());
    }

}
