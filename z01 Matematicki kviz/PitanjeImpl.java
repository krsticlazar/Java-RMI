/**
 * Konkretna implementacija jednog pitanja.
 *
 * Objekat ove klase cuva tekst pitanja i tri ponudjena odgovora. Kada server
 * vrati pitanje klijentu, klijent poziva samo metodu {@code vratiTekst()} i
 * prikazuje rezultat na konzoli.
 */
public class PitanjeImpl implements Pitanje {
    private static final long serialVersionUID = 1L;

    // Tekst matematickog pitanja, na primer "1+1= ?".
    private final String tekst;
    // Vrednost koja se prikazuje uz opciju "a".
    private final String odgovorA;
    // Vrednost koja se prikazuje uz opciju "b".
    private final String odgovorB;
    // Vrednost koja se prikazuje uz opciju "c".
    private final String odgovorC;

    /**
     * Formira pitanje od zadatog teksta i tri odgovora.
     */
    public PitanjeImpl(String tekst, String odgovorA, String odgovorB, String odgovorC) {
        this.tekst = tekst;
        this.odgovorA = odgovorA;
        this.odgovorB = odgovorB;
        this.odgovorC = odgovorC;
    }

    @Override
    public String vratiTekst() {
        // Klijent ocekuje gotov tekst spreman za stampu u konzoli.
        return tekst + System.lineSeparator()
                + "a) " + odgovorA + " b) " + odgovorB + " c) " + odgovorC;
    }
}
