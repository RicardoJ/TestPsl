package handler;
import printer.Printer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class handler { 
    //rango para el size 
    private static final int MINIMUM_SIZE_VALUE = 1;
    private static final int MAXIMUM_SIZE_VALUE = 10;
     /**
     *
     * Metodo encargado de procesar la entrada que contiene el size del segmento
     * de los digitos y los digitos a imprimir
     *
     * @param command Entrada que contiene el size del segmento de los digito
     * y el numero a imprimir
     * @param spaceBetweenDigit Espacio Entre digitos
     */  
    public void process(String command, int spaceBetweenDigit) {
        printer.Printer printerdraws = new printer.Printer();
        String[] parametros;
        
        int size;

        if (!command.contains(",")) {
            throw new IllegalArgumentException("Cadena " + command
                    + " no contiene caracter ,");
        }
        
        //Se hace el split de la cadena
        parametros = command.split(",");
        
        //Valida la cantidad de parametros
        if(parametros.length>2)
        {
           throw new IllegalArgumentException("Cadena " + command
                    + " contiene mas caracter ,"); 
        }
        
        //Valida la cantidad de parametros
        if(parametros.length<2)
        {
           throw new IllegalArgumentException("Cadena " + command
                    + " no contiene los parametros requeridos"); 
        }
        
        //Valida que el parametro size sea un numerico
        if(isNumeric(parametros[0]))
        {
            size = Integer.parseInt(parametros[0]);
            
            // se valida que el size este entre 1 y 10
            if(size <MINIMUM_SIZE_VALUE || size >MAXIMUM_SIZE_VALUE)
            {
                throw new IllegalArgumentException("El parametro size ["+size
                        + "] debe estar entre 1 y 10");
            }
        }
        else
        {
            throw new IllegalArgumentException("Parametro Size [" + parametros[0]
                    + "] no es un numero");
        }

        // Realiza la impresion del numero
       printerdraws.printNumber(size, parametros[1],spaceBetweenDigit);

    }

    /**
     *
     * Metodo encargado de validar si una cadena es numerica
     *
     * @param cadena Cadena
     */  
  public  boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}
