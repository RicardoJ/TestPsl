/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author DiazHerrera
 */
public class Printer {
  // Puntos fijos
    private final int[] fixedPoint1; 
    private final int[] fixedPoint2;
    private final int[] fixedPoint3;
    private final int[] fixedPoint4;
    private final int[] fixedPoint5;
    
    static final String verticalCharacter = "|"; 
    static final String horizontalCharacter = "-";
    static final String positionX = "X";
    static final String positionY = "Y";
   
    private int rowsOfEachDigit; 
    private int columnOfEachDigit; 
    private int totalRows;
    private int totalColumn;
    private int size;
    private String[][] printedMatrix;

 
      
 public Printer() {
        // Inicializa variables
        this.fixedPoint1 = new int[2];
        this.fixedPoint2 = new int[2];
        this.fixedPoint3 = new int[2];
        this.fixedPoint4 = new int[2];
        this.fixedPoint5 = new int[2];
        
    }
  /**
     *
     * Metodo encargado de añadir una linea a la matriz de Impresion
     *
     * @param matrix Matriz Impresion
     * @param point Punto Pivote
     * @param fixedStation Posicion Fija
     * @param size Tamaño Segmento
     * @param character Caracter Segmento
     */    
    private void addLine(String[][] matrix, int[] point, String fixedStation,
            int size, String character) {

        if (fixedStation.equalsIgnoreCase(positionX)) 
        {
            for (int y = 1; y <= size; y++) 
            {
                int value = point[1] + y;
               
                matrix[point[0]][value] = character;
            }
        } 
        else 
        {
            for (int i = 1; i <= size; i++) 
            {
                int value = point[0] + i;
                matrix[value][point[1]] = character;
            }
        }
    }
    /**
     *
     * Metodo encargado de un segmento a la matriz de Impresion
     *
     * @param segment Segmento a adicionar
     */  
    private void addsegment(int segment) {

        switch (segment) {
            case 1:
                addLine(this.printedMatrix, this.fixedPoint1, positionY,
                        this.size, verticalCharacter);
              
                break;
            case 2:
                addLine(this.printedMatrix, this.fixedPoint2, positionY,
                        this.size, verticalCharacter);
                break;
            case 3:
                addLine(this.printedMatrix, this.fixedPoint5, positionY,
                        this.size, verticalCharacter);
                break;
            case 4:
                addLine(this.printedMatrix, this.fixedPoint4, positionY,
                        this.size, verticalCharacter);
                break;
            case 5:
                addLine(this.printedMatrix, this.fixedPoint1, positionX,
                        this.size, horizontalCharacter);
                break;
            case 6:
                addLine(this.printedMatrix, this.fixedPoint2, positionX,
                        this.size, horizontalCharacter);
                break;
            case 7:
                addLine(this.printedMatrix, this.fixedPoint3, positionX,
                        this.size, horizontalCharacter);
                break;
            default:
                break;
        }
    }
    
        /**
     *
     * Metodo encargado de definir los segmentos que componen un digito y
     * a partir de los segmentos adicionar la representacion del digito a la matriz
     *
     * @param number Digito
     */
    public void addDigit(int number) {

        // Establece los segmentos de cada numero
        List<Integer> segmentList = new ArrayList<>();

        switch (number) {
            case 1:
                segmentList.add(3);
                segmentList.add(4);
                break;
            case 2:
                segmentList.add(5);
                segmentList.add(3);
                segmentList.add(6);
                segmentList.add(2);
                segmentList.add(7);
                break;
            case 3:
                segmentList.add(5);
                segmentList.add(3);
                segmentList.add(6);
                segmentList.add(4);
                segmentList.add(7);
                break;
            case 4:
                segmentList.add(1);
                segmentList.add(6);
                segmentList.add(3);
                segmentList.add(4);
                break;
            case 5:
                segmentList.add(5);
                segmentList.add(1);
                segmentList.add(6);
                segmentList.add(4);
                segmentList.add(7);
                break;
            case 6:
                segmentList.add(5);
                segmentList.add(1);
                segmentList.add(6);
                segmentList.add(2);
                segmentList.add(7);
                segmentList.add(4);
                break;
            case 7:
                segmentList.add(5);
                segmentList.add(3);
                segmentList.add(4);
                break;
            case 8:
                segmentList.add(1);
                segmentList.add(2);
                segmentList.add(3);
                segmentList.add(4);
                segmentList.add(5);
                segmentList.add(6);
                segmentList.add(7);
                break;
            case 9:
                segmentList.add(1);
                segmentList.add(3);
                segmentList.add(4);
                segmentList.add(5);
                segmentList.add(6);
                segmentList.add(7);
                break;
            case 0:
                segmentList.add(1);
                segmentList.add(2);
                segmentList.add(3);
                segmentList.add(4);
                segmentList.add(5);
                segmentList.add(7);
                break;
            default:
                break;
        }

        Iterator<Integer> iterator = segmentList.iterator();

        while (iterator.hasNext()) {
            addsegment(iterator.next());
        }
    }



    /**
     *
     * Metodo encargado de imprimir un numero
     *
     * @param size Tamaño Segmento Digitos
     * @param printedNumber Numero a Imprimir
     * @param space Espacio Entre digitos
     */
    public void printNumber(int size, String printedNumber, int space) {
        
       
        int pivotX = 0;
        char[] digits;

        this.size = size;

        // Calcula el numero de filas cada digito
        this.rowsOfEachDigit = (2 * this.size) + 3;

        // Calcula el numero de columna de cada digito
        this.columnOfEachDigit = this.size + 2;

        // Calcula el total de filas de la matriz en la que se almacenaran los digitos
        this.totalRows = this.rowsOfEachDigit;

        // Calcula el total de columnas de la matriz en la que se almacenaran los digitos
        this.totalColumn = (this.columnOfEachDigit * printedNumber.length())
                + (space * printedNumber.length());

        // crea matriz para almacenar los numero a imprimir
        this.printedMatrix = new String[this.totalRows][this.totalColumn];

        // crea el arreglo de digitos
        digits = printedNumber.toCharArray();

        // Inicializa matriz
       
        initializeMatrix();
        for (char digit : digits) {

            //Valida que el caracter sea un digito
            if (!Character.isDigit(digit)) {
                throw new IllegalArgumentException("Caracter " + digit
                        + " no es un digito");
            }

            int number = Integer.parseInt(String.valueOf(digit));

            //Calcula puntos fijos
          
            this.fixedPoint1[0] = 0;
            this.fixedPoint1[1] = 0 + pivotX;
            

            this.fixedPoint2[0] = (this.rowsOfEachDigit / 2);
            this.fixedPoint2[1] = 0 + pivotX;
            

            this.fixedPoint3[0] = (this.rowsOfEachDigit - 1);
            this.fixedPoint3[1] = 0 + pivotX;
            
            this.fixedPoint4[0] = (this.columnOfEachDigit - 1);
            this.fixedPoint4[1] = (this.rowsOfEachDigit / 2) + pivotX;
            
            this.fixedPoint5[0] = 0;
            this.fixedPoint5[1] = (this.columnOfEachDigit - 1) + pivotX;
           
            pivotX = pivotX + this.columnOfEachDigit + space;

           addDigit(number);
        }

       printMatrix();
    }
       private void printMatrix() {
        // Imprime matriz
        for (int i = 0; i < this.totalRows; i++) {
            for (int j = 0; j < this.totalColumn; j++) {
                System.out.print(this.printedMatrix[i][j]);
            }
            System.out.println();
        }
    }
       
        private void initializeMatrix() {
         for (int i = 0; i < this.totalRows; i++) {
            for (int j = 0; j < this.totalColumn; j++) {
                this.printedMatrix[i][j] = " ";
            }
        }
    }
}

 