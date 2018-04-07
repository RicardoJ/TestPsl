package handler;

public class Handler {

    //rango para el size 
    private static final int MINIMUM_SIZE_VALUE = 1;
    private static final int MAXIMUM_SIZE_VALUE = 10;
    private static final String SEPARATOR = ",";

    /**
     *
     * Metodo encargado de procesar la entrada que contiene el size del segmento
     * de los digitos y los digitos a imprimir
     *
     * @param command Entrada que contiene el size del segmento de los digito y
     * el numero a imprimir
     * @param spaceBetweenDigit Espacio Entre digitos
     */
    public void processEntryInTheSizeOfTheSegment(String command, int spaceBetweenDigit) {
        printer.Printer printerdraws = new printer.Printer();
        String[] parameters;
        int size;

        if (!command.contains(SEPARATOR)) {
            throw new IllegalArgumentException("Cadena " + command
                    + " no contiene caracter ,");
        }
        //Se hace el split de la cadena
        parameters = command.split(SEPARATOR);
        //Valida la cantidad de parametros
        if (parameters.length > 2) {
            throw new IllegalArgumentException("Cadena " + command
                    + " contiene mas caracter ,");
        }
        //Valida la cantidad de parametros
        if (parameters.length < 2) {
            throw new IllegalArgumentException("Cadena " + command
                    + " no contiene los parametros requeridos");
        }
        //Valida que el parametro size sea un numerico
        if (isNumeric(parameters[0])) {
            size = Integer.parseInt(parameters[0]);
            // se valida que el size este entre 1 y 10
            if (size < MINIMUM_SIZE_VALUE || size > MAXIMUM_SIZE_VALUE) {
                throw new IllegalArgumentException("El parametro size [" + size
                        + "] debe estar entre "+MINIMUM_SIZE_VALUE +" y "+ MAXIMUM_SIZE_VALUE);
            }
        } else {
            throw new IllegalArgumentException("Parametro Size [" + parameters[0]
                    + "] no es un numero");
        }

        // Realiza la impresion del numero
        printerdraws.printNumber(size, parameters[1], spaceBetweenDigit);
       
    }

    /**
     *
     * Metodo encargado de validar si una cadena es numerica
     *
     * @param string Cadena
     * @return
     */
    public boolean isNumeric(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}
