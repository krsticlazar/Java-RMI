# Matematicki kviz - objasnjenje strukture

## Ideja aplikacije

Ova aplikacija koristi Java RMI da bi klijent pozivao metode koje se izvrsavaju na serveru. Server cuva pitanja, tacne odgovore i broj poena. Klijent samo prikazuje pitanja i salje unete odgovore.

Najvaznija podela je:

- udaljeni RMI objekat: `Kviz`
- obican serijalizovan objekat: `Pitanje`
- serverska ulazna tacka: `Server`
- klijentska ulazna tacka: `Klijent`

## Tok izvrsavanja

1. Pokrene se `Server`.
2. Server pravi registry na portu `1099`.
3. Server kreira `KvizImpl` i objavi ga pod imenom `Kviz`.
4. Pokrene se `Klijent`.
5. Klijent preko `Naming.lookup(...)` dobija referencu na udaljeni objekat `Kviz`.
6. Klijent poziva `pocetak()`, zatim tri puta trazi pitanje i salje odgovor.
7. Server vodi racuna o indeksu pitanja i broju poena.
8. Na kraju klijent trazi ukupan broj poena i ispisuje ga.

## Objasnjenje svakog fajla

### `Pitanje.java`

Interfejs za jedno pitanje. Nije RMI interfejs, nego obican serijalizovani tip podataka koji moze da se posalje sa servera na klijenta.

Metoda:

- `vratiTekst()` vraca pitanje i ponudjene odgovore kao gotov tekst za stampu.

### `PitanjeImpl.java`

Konkretna implementacija pitanja. Cuva:

- tekst pitanja
- odgovor pod opcijom `a`
- odgovor pod opcijom `b`
- odgovor pod opcijom `c`

Ova klasa nema RMI logiku. Njena uloga je samo da zapakuje podatke o pitanju.

### `Kviz.java`

Glavni udaljeni interfejs aplikacije. Ovo je interfejs koji klijent dobija od servera.

Metode:

- `pocetak()` resetuje stanje kviza
- `vratiPitanje()` vraca sledece pitanje
- `odgovori(String odg)` prima korisnikov odgovor
- `vratiBrojPoena()` vraca ukupan broj poena

Posto je ovo RMI interfejs:

- nasledjuje `Remote`
- sve metode imaju `throws RemoteException`

### `KvizImpl.java`

Serverska implementacija interfejsa `Kviz`.

Najvaznija polja:

- `pitanja` - niz pitanja
- `tacniOdgovori` - niz tacnih odgovora istim redosledom kao pitanja
- `indeksTrenutnogPitanja` - pokazuje koje pitanje sledi
- `indeksPoslednjegPitanja` - pamti za koje pitanje proveravamo odgovor
- `brojPoena` - broj tacnih odgovora

Bitna ideja:

- server vraca pitanje klijentu
- server pamti koje je pitanje upravo poslato
- kada klijent posalje odgovor, server proverava odgovor prema tom zapamcenom indeksu

Klasa nasledjuje `UnicastRemoteObject` zato sto predstavlja udaljeni objekat.

### `Server.java`

Pokrece serversku stranu aplikacije.

Radi tri bitne stvari:

1. pravi ili koristi postojeci RMI registry
2. kreira `KvizImpl`
3. vezuje objekat za ime `Kviz`

Zbog toga klijent kasnije moze da uradi `Naming.lookup("rmi://localhost:1099/Kviz")`.

### `Klijent.java`

Pokrece klijentsku stranu aplikacije.

Njegov posao je:

- povezivanje na server
- pozivanje `pocetak()`
- preuzimanje pitanja
- citanje odgovora sa tastature
- slanje odgovora serveru
- trazenje konacnog broja poena

Klijent ne zna koji je odgovor tacan. Tacna resenja zna samo server.

## Kako da razmisljas o obrascu

Ovaj zadatak pokazuje osnovni obrazac za male RMI aplikacije:

1. Napravis jedan glavni `Remote` interfejs.
2. Napravis `Impl` klasu koja nasledjuje `UnicastRemoteObject`.
3. Server registruje objekat pod nekim imenom.
4. Klijent radi `lookup`.
5. Ako treba da vracas "obican podatak", vracas serijalizovan objekat umesto novog udaljenog objekta.

U ovom primeru je:

- `Kviz` udaljeni objekat
- `Pitanje` obican serijalizovan objekat
