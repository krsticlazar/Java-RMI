# eBanka - objasnjenje strukture

## Ideja aplikacije

Ovo je Java RMI aplikacija u kojoj klijent preko bankarskog servera pristupa korisniku i nad njegovim racunima radi transfer izmedju dinarskog i deviznog stanja.

Najvaznija podela je:

- glavni udaljeni objekat: `EBanka`
- udaljeni objekat jednog korisnika: `Korisnik`
- serijalizovan objekat sa stanjem racuna: `Stanje`
- ulazne tacke: `Server` i `Klijent`

## Tok izvrsavanja

1. Pokrene se `Server`.
2. Server pravi RMI registry i registruje `EBankaImpl` pod imenom `EBanka`.
3. Pokrene se `Klijent`.
4. Klijent preko `lookup` dobija referencu na `EBanka`.
5. Klijent unosi JBK korisnika.
6. Klijent trazi odgovarajuceg korisnika preko `vratiKorisnika(jbk)`.
7. Nad vracenim udaljenim objektom `Korisnik` radi transfer ili proverava stanje.
8. Kada trazi stanje, server salje serijalizovan objekat `StanjeImpl`.

## Objasnjenje svakog fajla

### `EBanka.java`

Glavni RMI interfejs sistema.

Metoda:

- `vratiKorisnika(String jbk)` - vraca udaljenu referencu na jednog korisnika

To znaci da klijent najpre pristupa sistemu kao celini, a tek onda jednom konkretnom korisniku.

### `EBankaImpl.java`

Serverska implementacija interfejsa `EBanka`.

Najvaznije polje:

- `Map<String, Korisnik> korisnici`

U ovoj mapi je simulirana banka sa deset korisnika. Konstruktor odmah popunjava mapu pocetnim stanjima.

### `Korisnik.java`

RMI interfejs jednog korisnika u banci.

Metode:

- `vratiStanje()`
- `transferDinarskiNaDevizni(float iznos, float kurs)`
- `transferDevizniNaDinarski(float iznos, float kurs)`

Bitna stvar je da klijent ne zna kako se transfer izvodi iznutra. On samo poziva odgovarajucu metodu na udaljenom objektu.

### `KorisnikImpl.java`

Serverska implementacija jednog korisnika.

Ova klasa cuva:

- `jbk`
- `iznosDinarski`
- `iznosDevizni`

Logika transfera:

- dinarski -> devizni:
  - skida se iznos sa dinarskog racuna
  - dodaje se `iznos / kurs` na devizni racun
- devizni -> dinarski:
  - skida se iznos sa deviznog racuna
  - dodaje se `iznos * kurs` na dinarski racun

Metode proveravaju:

- da je iznos pozitivan
- da je kurs pozitivan
- da na racunu ima dovoljno sredstava

### `Stanje.java`

Interfejs za stanje racuna. Nije RMI interfejs, vec serijalizovan tip podataka.

Metode:

- `vratiDinarskiIznos()`
- `vratiDevizniIznos()`

### `StanjeImpl.java`

Konkretna implementacija stanja. Ova klasa samo nosi podatke sa servera ka klijentu.

To je tipican obrazac kada:

- stanje zelis da procitas
- ne treba ti poseban udaljeni objekat
- dovoljno je da server posalje serijalizovan snapshot

### `Server.java`

Pokrece serversku stranu aplikacije.

Radi sledece:

1. kreira ili koristi registry na portu `1099`
2. kreira `EBankaImpl`
3. registruje ga pod imenom `EBanka`
4. ceka `Enter` da bi server ostao aktivan

### `Klijent.java`

Pokrece konzolni meni za korisnika.

Klijent:

- prikazuje meni
- cita opciju
- trazi JBK
- poziva odgovarajucu metodu na udaljenom korisniku
- formatira i ispisuje stanje racuna

U ovoj implementaciji kurs je fiksan:

- `117.0`

To je pojednostavljenje zbog zadatka, da fokus ostane na RMI komunikaciji.

## Najbitniji obrazac koji treba da zapamtis

Ovaj zadatak lepo pokazuje tri tipa klasa u jednoj RMI aplikaciji:

1. glavni udaljeni servis
2. udaljeni entitet nad kojim radis operacije
3. serijalizovan DTO objekat za prikaz stanja

Ovde to izgleda ovako:

- `EBanka` - glavni servis
- `Korisnik` - udaljeni entitet
- `Stanje` - serijalizovani objekat sa podacima
