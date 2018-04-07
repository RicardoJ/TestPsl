/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import handler.Handler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import junit.framework.AssertionFailedError;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author DiazHerrera
 */
@RunWith(value = Parameterized.class)
public class PrinterTest {

    @Parameters
    public static Iterable<Object[]> getData() {
        return Arrays.asList(new Object[][]{
            {"2,9", true},{"86", true},{"khk,9", true},{"2,8", false}
        });
        /* List<Object[]> obj = new ArrayList<>();
      obj.add(new Object[]{"12", true});
        obj.add(new Object[]{"86", true});
        obj.add(new Object[]{"0", true});
        obj.add(new Object[]{"ejhod", false});
        obj.add(new Object[]{"*3$#", false});
          obj.add(new Object[]{"2,8", false});

        return obj;*/
    }
    handler.Handler handler = new handler.Handler();
    printer.Printer print = new printer.Printer();

    String stringOfWord;
    boolean expected;

    public PrinterTest(String stringOfWord, boolean expected) {
        this.stringOfWord = stringOfWord;
        this.expected = expected;
    }

    @Test
    public void testisNumeric() {
        boolean actual = handler.isNumeric(stringOfWord);
        assertEquals(expected, actual);
    }
   

  
}
