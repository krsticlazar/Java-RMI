import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Serverska implementacija kviza.
 *
 * Kviz je udaljeni objekat, pa klasa nasledjuje {@link UnicastRemoteObject}.
 * Server kreira jednu instancu ove klase i registruje je pod imenom "Kviz".
 */
public class KvizImpl extends UnicastRemoteObject implements Kviz {
    // Niz svih pitanja koje kviz koristi.
    private final Pitanje[] pitanja;
    // Paralelni niz sa tacnim odgovorima za svako pitanje.
    private final String[] tacniOdgovori;
    // Pokazuje koje pitanje sledece treba vratiti klijentu.
    private int indeksTrenutnogPitanja;
    // Pamti pitanje na koje klijent trenutno odgovara.
    private int indeksPoslednjegPitanja;
    // Brojac tacnih odgovora.
    private int brojPoena;

    /**
     * Konstruktor priprema fiksan skup pitanja i odgovora.
     */
    public KvizImpl() throws RemoteException {
        super();
        pitanja = new Pitanje[] {
            new PitanjeImpl("1+1= ?", "1", "2", "3"),
            new PitanjeImpl("2*3= ?", "6", "2", "1"),
            new PitanjeImpl("10/2= ?", "1", "2", "5")
        };
        tacniOdgovori = new String[] { "b", "a", "c" };
        indeksTrenutnogPitanja = 0;
        indeksPoslednjegPitanja = -1;
        brojPoena = 0;
    }

    @Override
    public synchronized void pocetak() throws RemoteException {
        // Svaki novi pokusaj resavanja mora da krene od nule.
        brojPoena = 0;
        indeksTrenutnogPitanja = 0;
        indeksPoslednjegPitanja = -1;
    }

    @Override
    public synchronized Pitanje vratiPitanje() throws RemoteException {
        if (indeksTrenutnogPitanja < pitanja.length) {
            // Pamtimo koje je pitanje upravo poslato da bismo sledeci odgovor
            // mogli da proverimo u odnosu na pravi indeks.
            indeksPoslednjegPitanja = indeksTrenutnogPitanja;
            return pitanja[indeksTrenutnogPitanja++];
        }

        // Kada vise nema pitanja, vracamo null kao signal kraja kviza.
        return null;
    }

    @Override
    public synchronized void odgovori(String odg) throws RemoteException {
        // Ako nije poslato nijedno pitanje ili je odgovor vec obradjen,
        // odgovor ignorisemo.
        if (indeksPoslednjegPitanja < 0 || indeksPoslednjegPitanja >= tacniOdgovori.length) {
            return;
        }

        // Trim uklanja slucajne razmake koje korisnik moze uneti.
        String odgovor = odg == null ? "" : odg.trim();
        if (tacniOdgovori[indeksPoslednjegPitanja].equalsIgnoreCase(odgovor)) {
            brojPoena++;
        }

        // Nakon obrade ovog odgovora ne smemo ga ponovo brojati.
        indeksPoslednjegPitanja = -1;
    }

    @Override
    public synchronized int vratiBrojPoena() throws RemoteException {
        return brojPoena;
    }
}
