package trab1.grupo3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestYesNoAnswer {
    @Test
    public void testCheckYes() {
      Answer yes= new YesNoAnswer( true );
      try {
          assertTrue(yes.check("sim"));
          assertFalse(yes.check("nao"));
          InvalidFormatException ex = assertThrows(
                    InvalidFormatException.class,
                    () -> yes.check("ok")
          );
          assertEquals("ok: nem é sim nem é nao",ex.getMessage());
        }
        catch ( InvalidFormatException ex ) {
            Assertions.fail(ex.getMessage());
        }
    }

    @Test
    public void testCheckNo() {
        Answer no = new YesNoAnswer( false );
        try {
            assertTrue(no.check("nao"));
            assertFalse(no.check("sim"));
            InvalidFormatException ex = assertThrows(
                    InvalidFormatException.class,
                    () -> no.check("ok")
            );
            assertTrue(ex.getMessage().contains("ok: nem é sim nem é nao"));
        }
        catch ( InvalidFormatException ex ) {
            Assertions.fail(ex.getMessage());
        }
    }

}
