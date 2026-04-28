import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Udaljeni interfejs kviza.
 *
 * Sve metode iz ovog interfejsa klijent poziva preko mreze, pa interfejs mora
 * da nasledjuje {@link Remote}, a metode moraju da prijave
 * {@link RemoteException}.
 */
public interface Kviz extends Remote {
    /**
     * Resetuje kviz na pocetno stanje:
     * broj poena postaje 0, a indeks pitanja se vraca na pocetak.
     */
    void pocetak() throws RemoteException;

    /**
     * Vraca sledece pitanje koje treba prikazati korisniku.
     */
    Pitanje vratiPitanje() throws RemoteException;

    /**
     * Prima odgovor korisnika u obliku "a", "b" ili "c" i interno proverava
     * da li je odgovor tacan.
     */
    void odgovori(String odg) throws RemoteException;

    /**
     * Vraca ukupan broj osvojenih poena.
     */
    int vratiBrojPoena() throws RemoteException;
}
