import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Eksponat extends Remote {                             // Operacije se izvrsavaju nad serverskim eksponatom.
    void prijaviLicitaciju(KlijentAukcije ka) throws RemoteException;  // Upisuje ko trenutno licitira za ovaj eksponat.

    KlijentAukcije vratiKlijentaAukcije() throws RemoteException;       // Vraca trenutno prijavljenog klijenta.

    void odustaniOdLicitacije(String klijentAukcijeId) throws RemoteException;   // Brise klijenta iz licitacije.

    String vratiNaziv() throws RemoteException;                         // Citanje naziva eksponata.

    int vratiCenu() throws RemoteException;                            // Citanje trenutne cene.

    void povecajCenu(int iznos) throws RemoteException;                // Menja cenu eksponata na serveru.
}
