import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Serverska ulazna tacka.
 *
 * Server pravi RMI registry na portu 1099, kreira instancu kviza i vezuje je
 * za ime "Kviz" kako bi klijent mogao da je pronadje preko Naming.lookup.
 */
public class Server {
    public Server() {
        try {
            try {
                // Ako registry jos ne postoji, pravimo novi.
                LocateRegistry.createRegistry(1099);
            } catch (RemoteException e) {
                // Ako vec postoji, to nije greska za ovaj mali primer.
            }

            // Objektu dodeljujemo javno ime koje klijent koristi pri povezivanju.
            Naming.rebind("Kviz", new KvizImpl());
            System.out.println("Kviz server je pokrenut.");
            System.out.println("Pritisnite Enter za gasenje servera.");
            // Server ostaje aktivan dok ga korisnik rucno ne ugasi.
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}
