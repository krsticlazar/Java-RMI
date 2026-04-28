DISTRIBUIRANI SISTEMI – LABORATORIJSKE VEŽBE – JAVA RMI

Zadatak 5

Elektronska Aukcija

Opis:

Korišćenjem Java RMI tehnologije implementirati sistem  koji omogućava klijentima  da
ucestvuju u aukciji i licitiraju za eksponate.

Sistem treba da sadrži sledeće klase sa odgovarajućim metodama:

•  Server - klasa koja sadrži logiku izvršavanja serverskog dela sistema.
•  Klijent - klasa koja sadrži logiku izvršavanja klijentskog dela sistema.
•  KlijentAukcije  -  klasa  koja  sadrži  podatke  o  klijentu  koji  licitira  (identifikator,

ime i prezime) i implementira interfejs java.io.Serializable.

o  KlijentAukcije  (String  klijentAukcijeId,  String  ime,  String  prezime)  -
konstruktor  koji  uzima  jedinstveni  identifikator  klijenta  aukcije,  ime  i
prezime.

•  Eksponat - interfejs klasa koja sadrži podatke o jednom eksponatu.

o  void  prijaviLicitaciju(KlijentAukcije ka) - metoda koja prijavljuje klijenta
sa  zadatim  identifikatorom,  imenom  i  prezimenom,  za  aukciju  trenutnog
ekponata.

o  KlijentAukcije  vratiKlijentaAukcije()  -  metoda  koja  za  trenutni  eksponat

vrća objekat KlijentAukcije.

o  void odustaniOdLicitacije(String klijentAukcijeId) - metoda kojom se vrši

odustajanje klijenta od aukcije za trenutni eksponat.

o  String vratiNaziv () - metoda koja vraća trenutni naziv eksponata.
int vratiCenu() - metoda koja vraća trenutnu cenu eksponata.
o
o  void  povecajCenu(int  iznos)  -  metoda  koja  povećava  cenu  eksponata  za

određeni iznos.

•  EksponatImpl - klasa koja implementira interfejs klase Eksponat

o  EksponatImpl (String id, String naziv, int cena) - konstruktor koji uzima

jedinstveni identifikator Eksponata, njegov naziv i inicijalnu cenu

•  EAukcija - interfejs klasa koja sadrži (bazu) niz eksponata.

o  Eksponat    vratiEksponat  (String  idEksponata)  -  metoda  koja  vraća

referencu na Eksponat za zadati identifikator.

•  EAukcijaImpl - klasa koja implementira interfejs klase EAukcija

Sistem treba da prati sledeći scenario izvršavanja:

1. Vrši se startovanje servera na kome se kreira instanca klase EAukcijaImpl. U okviru
klase EAukcijaImpl se inicijalizuje niz od pet objekata tipa Eksponat sa odgovarajućim
identifikatorima i nazivima.

DISTRIBUIRANI SISTEMI – LABORATORIJSKE VEŽBE – JAVA RMI

2. Vrši se startovanje klijenta u okviru koga se vrši konktovanje na server i referenciranje
objekta tipa EAukcijaImpl.

3.  Na  klijentskoj  strani  se  u  okviru  komandne  linije  vrši  unos  identifikatora  klijenta,  -
imena klijenta i prezimena klijenta i na osnovu ovih podataka kreira lokalni objekat tipa
KlijentAukcije  koji  će  biti  korišćen  u  nastavku  prilikom  poziva  metoda  <<  Eksponat
>>::prijaviLicitaciju().

4. Na klijentskoj strani se zatim unosi identifikator ekponata praćeno porukom "Unesite
identifikator  Eksponata",  Nakon  čega  se  uneti  identifikator  prosleđuje  metodi  <<
EAukcija >>:: vratiEksponat().                 .

5. U okviru komandne linije se ispisuju naziv i trenutna cena eksponata koji su dobijeni
pozivima metoda << Eksponat >>:: vratiCenu () i << Eksponat >>:: vratiNaziv () .

6. Vrši se povećanje cene za 10 pozivom metode << Eksponat >>:: vratiCenu () i vrši se
prijava klijenta za taj ekponat pozivom metode  << Eksponat >>::prijaviLicitaciju().
.
6. Postupak se ponavlja za drugi ekponat ali se odustaje od licitacije pozivom na metod
<< Eksponat >>::odustaniOdLicitacije().

Primer izlaza na klijentskoj strani:

Dobrodosli na elektronsku aukciju. Za nastavak unesite vaše lične podatke:
Identifikator:
/>KL12345
Ime
/>Pera
Prezime
/>Peric

Unesite identifikator za eksponat od interesa:
/>EKS_997
Cena eksponata je:
1200

Izaberite opciju:
a) Licitacija
b) Odustajanje
/>a

Za koliko uvecavate iznos eksponata ?
/>10

Unesite identifikator za eksponat od interesa:

DISTRIBUIRANI SISTEMI – LABORATORIJSKE VEŽBE – JAVA RMI

/>EKS_991
Cena eksponata je:
99200

Izaberite opciju:
a) Licitacija
b) Odustajanje
/>b