import java.io.Serializable;

/**
 * Ovaj interfejs predstavlja jedno pitanje koje klijent dobija od servera.
 *
 * Pitanje nije udaljeni RMI objekat. Server ga salje klijentu kao obican
 * serijalizovan objekat, pa je dovoljno da interfejs nasledjuje
 * {@link Serializable}.
 */
public interface Pitanje extends Serializable {
    /**
     * Vraca kompletan tekst pitanja zajedno sa ponudjenim odgovorima.
     */
    String vratiTekst();
}
