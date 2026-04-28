import java.rmi.Naming;
import java.util.Scanner;

/**
 * Klijentska strana matematickog kviza.
 *
 * Ova klasa ne sadrzi poslovnu logiku kviza. Njena uloga je da od servera
 * uzme udaljeni objekat, prikaze pitanja korisniku i prosledi unete odgovore.
 */
public class Klijent {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Preuzimamo referencu na udaljeni objekat koji je server objavio.
            Kviz kviz = (Kviz) Naming.lookup("rmi://localhost:1099/Kviz");

            // Svako pokretanje klijenta resetuje kviz na pocetak.
            kviz.pocetak();

            for (int i = 1; i <= 3; i++) {
                // Server vraca serijalizovani objekat tipa Pitanje.
                Pitanje p = kviz.vratiPitanje();
                if (p == null) {
                    break;
                }

                // Prikaz pitanja korisniku.
                System.out.println("Pitanje " + i);
                System.out.println(p.vratiTekst());
                System.out.println();
                System.out.println("Unesite odgovor:");

                // Od korisnika ocekujemo "a", "b" ili "c".
                String odg = scanner.nextLine().trim();
                // Prosledjujemo odgovor serveru koji radi proveru.
                kviz.odgovori(odg);
                System.out.println();
            }

            // Nakon poslednjeg pitanja trazimo konacan broj poena.
            System.out.println("Broj Poena:");
            System.out.println(kviz.vratiBrojPoena());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
