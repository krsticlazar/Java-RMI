# Aukcija - opste objasnjenje

## Struktura resenja

Resenje je organizovano kroz dva nivoa remote objekata:

- `EAukcija` predstavlja centralni servis aukcije.
- `Eksponat` predstavlja pojedinacan eksponat za koji klijenti mogu da licitiraju ili da odustanu.

Klijent se prvo povezuje na objekat `EAukcija`, a zatim preko njega dobija referencu na konkretan objekat `Eksponat`.

## Uloge klasa

- `Server` pokrece RMI registry i registruje glavni objekat aukcije.
- `Klijent` trazi podatke o korisniku, zatim bira eksponat i izvrsava licitaciju ili odustajanje.
- `KlijentAukcije` cuva podatke o klijentu i prenosi se sa klijenta ka serveru kao `Serializable` objekat.
- `EAukcijaImpl` cuva pet unapred kreiranih eksponata.
- `EksponatImpl` cuva stanje jednog eksponata: naziv, cenu i trenutno prijavljenog klijenta.

## Tok rada aplikacije

1. Pokrene se `Server`.
2. Server kreira objekat `EAukcijaImpl`.
3. U konstruktoru `EAukcijaImpl` nastaje pet objekata tipa `EksponatImpl`.
4. Server registruje objekat `EAukcija` pod imenom `EAukcija`.
5. Pokrene se jedan ili vise klijenata.
6. Klijent unosi svoj identifikator, ime i prezime i lokalno pravi objekat `KlijentAukcije`.
7. Klijent unosi identifikator eksponata i preko `EAukcija.vratiEksponat(...)` dobija remote referencu na trazeni eksponat.
8. Klijent cita naziv i cenu eksponata.
9. Ako izabere licitaciju, poziva `povecajCenu(...)` i `prijaviLicitaciju(...)`.
10. Ako izabere odustajanje, poziva `odustaniOdLicitacije(...)`.

## Zasto je ovde `KlijentAukcije` serializable, a `Eksponat` remote

`KlijentAukcije` je obican podatkovni objekat. Ne treba da ima udaljene metode, vec samo da prenese podatke o korisniku na server.

`Eksponat` je remote zato sto njegovo stanje mora da ostane na serveru i da vise klijenata vidi iste promene cene i istog prijavljenog klijenta.

## Kako se vidi deljeno stanje

Ako dva klijenta uzmu isti eksponat:

- kada prvi klijent poveca cenu, drugi klijent ce pri sledecem citanju videti novu cenu;
- kada prvi klijent prijavi licitaciju, objekat eksponata cuva tog klijenta kao trenutno prijavljenog;
- kada taj isti klijent odustane, prijavljeni klijent se uklanja.

## Pokretanje

Iz foldera `z05 Aukcija`:

```powershell
javac *.java
java Server
java Klijent
```

Za test sa vise korisnika pokreni vise puta `java Klijent` u vise terminala.
