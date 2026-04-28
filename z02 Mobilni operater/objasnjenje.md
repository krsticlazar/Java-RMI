# Mobilni operater - objasnjenje strukture

## Ideja aplikacije

Ovo je RMI aplikacija u kojoj klijent preko servera pristupa korisnicima mobilnog operatera. Server cuva "bazu" korisnika, njihove tarife i trenutno stanje. Klijent bira operaciju iz menija i trazi promenu ili pregled stanja.

Najvaznija podela je:

- glavni udaljeni objekat: `Operater`
- udaljeni objekat jednog korisnika: `Korisnik`
- serijalizovan objekat sa snapshot stanjem: `Stanje`
- ulazne tacke: `Server` i `Klijent`

## Tok izvrsavanja

1. Pokrene se `Server`.
2. Server pravi registry i objavi objekat `OperaterImpl` pod imenom `Operater`.
3. Pokrene se `Klijent`.
4. Klijent preko `lookup` dobija referencu na `Operater`.
5. Klijent unosi broj telefona.
6. Klijent preko `operater.vratiKorisnika(broj)` dobija udaljenu referencu na konkretnog korisnika.
7. Nad tim korisnikom poziva uplatu minuta, poruka, interneta ili proveru stanja.
8. Kada trazi stanje, server vraca objekat `StanjeImpl` kao serijalizovan snapshot.

## Objasnjenje svakog fajla

### `Operater.java`

Glavni RMI interfejs sistema. Ima samo jednu metodu:

- `vratiKorisnika(String broj)` - vraca udaljenu referencu na korisnika

Ovo je ulazna tacka u sistem, jer klijent prvo mora da nadje operatera.

### `OperaterImpl.java`

Serverska implementacija interfejsa `Operater`.

Najvaznije polje:

- `Map<String, Korisnik> korisnici` - mapa korisnika po broju telefona

Bitna ideja:

- "baza" korisnika je simulirana mapom u memoriji
- konstruktor odmah puni mapu sa 10 test korisnika
- metoda `vratiKorisnika` samo vraca vrednost iz mape

### `Korisnik.java`

RMI interfejs za jednog korisnika.

Metode:

- `uplatiMinute(int minuti)`
- `uplatiPoruke(int poruke)`
- `uplatiInternet(int internet)`
- `vratiStanje()`

Znaci, kada klijent jednom dodje do korisnika, on dalje radi direktno sa tim udaljenim objektom.

### `KorisnikImpl.java`

Serverska implementacija jednog korisnika.

Ova klasa cuva:

- broj telefona
- minute
- poruke
- internet
- tarife za svaki resurs
- racun

Svaka uplata radi dve stvari:

1. povecava odgovarajuci resurs
2. povecava racun po odgovarajucoj tarifi

Metoda `vratiStanje()` ne vraca direktan pristup internim poljima, nego pravi novi `StanjeImpl` objekat i salje ga klijentu.

### `Stanje.java`

Interfejs za citanje stanja korisnika. Nije RMI interfejs, nego serijalizovan tip podataka.

Metode:

- `vratiMinute()`
- `vratiPoruke()`
- `vratiInternet()`
- `vratiRacun()`

### `StanjeImpl.java`

Konkretan snapshot stanja korisnika. Ova klasa samo cuva podatke i nema poslovnu logiku.

To je dobar obrazac kada klijentu treba samo pregled podataka:

- server formira stanje
- stanje se posalje kao serijalizovan objekat
- klijent ga samo procita i ispise

### `Server.java`

Pokrece serversku stranu aplikacije.

Radi sledece:

1. pravi ili koristi RMI registry
2. kreira `OperaterImpl`
3. registruje ga pod imenom `Operater`
4. ceka da korisnik pritisne Enter

### `Klijent.java`

Pokrece klijentsku stranu aplikacije.

Njegov posao je:

- prikaz menija
- citanje opcije sa tastature
- trazenje korisnika po broju
- pozivanje odgovarajuce metode na korisniku
- ispis povratnog stanja kada je potrebno

Poslovna logika nije u klijentu. Klijent je samo konzolni interfejs.

## Kljucevi za razumevanje obrasca

Ovaj zadatak je dobar primer za situaciju kada imas vise nivoa objekata:

1. prvo dobijes glavni sistemski objekat
2. preko njega pronadjes konkretan entitet
3. nad tim entitetom radis operacije
4. stanje vracas kao serijalizovan objekat

Ovde konkretno:

- `Operater` je glavni udaljeni objekat
- `Korisnik` je drugi udaljeni objekat
- `Stanje` je obican serijalizovan objekat
