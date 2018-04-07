package testpsl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LCDTester {
    //rango para el space 

    private static final int MINIMUM_SPACE_VALUE = 0;
    private static final int MAXIMUM_SPACE_VALUE = 5;

    private static final String CADENA_FINAL = "0,0";

    public static void main(String[] args) {

        // Establece los segmentos de cada numero
        List<String> commandList = new ArrayList<>();
        String command;
        int spaceBetweenNumbers;
        handler.Handler handler = new handler.Handler();
        try {

            try (Scanner reader = new Scanner(System.in)) {

                System.out.print("Espacio entre Digitos (0 a 5): ");
                command = reader.next();

                // Valida si es un numero
                if (handler.isNumeric(command)) {
                    spaceBetweenNumbers = Integer.parseInt(command);

                    // se valida que el espaciado este entre 0 y 5
                    if (spaceBetweenNumbers < MINIMUM_SPACE_VALUE || spaceBetweenNumbers > MAXIMUM_SPACE_VALUE) {
                        throw new IllegalArgumentException("El espacio entre "
                                + "digitos debe estar entre "+MINIMUM_SPACE_VALUE+ " y "+ MAXIMUM_SPACE_VALUE);
                    }

                } else {
                    throw new IllegalArgumentException("Cadena " + command
                            + " no es un entero");
                }

                do {
                    System.out.print("Entrada: ");
                    command = reader.next();
                    if (!command.equalsIgnoreCase(CADENA_FINAL)) {
                        commandList.add(command);
                    }
                } while (!command.equalsIgnoreCase(CADENA_FINAL));
            }

            Iterator<String> iterator = commandList.iterator();
            while (iterator.hasNext()) {
                try {
                    handler.processEntryInTheSizeOfTheSegment(iterator.next(), spaceBetweenNumbers);
                } catch (Exception ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }

}
