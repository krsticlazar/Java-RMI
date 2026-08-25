Elektronski fakultet
Katedra za računarstvo

________________________________________

23.04.2026.

DISTRIBUIRANI SISTEMI - NP

1.  Šta  predstavlja  skalabilnost  distribuiranog  sistema?  Navesti  i  objasniti  tehnike  skaliranja  distribuiranih

sistema.

2.  Objasniti pojam distribuirane transakcije i dati primer izvršenja jedna distribuirane transakcije.

3.  U call-by-copy/restore semantici, šta se dešava sa parametrima?

A.  Parametri se šalju kao kopija serveru
B.  Promene se automatski reflektuju na klijentu u realnom vremenu
C.  Nakon izvršenja, rezultati se kopiraju nazad klijentu
D.  Parametri se ne vraćaju klijentu

4.  Koja je uloga klijent stuba i server stuba u RPC komunikaciji i na koji način oni omogućavaju transparentno

pozivanje udaljenih procedura?

5.  a)  Izlaz iz IDL kompajlera sastoji se od više fajlova. Koji su to fajlovi i šta sadrže? Napisati na koji način
se  vrši  generisanje  ovih  fajlova  i  kako  se  na  osnovu  generisanih  fajlova  formiraju  izvršna  klijentska  i
serverska aplikacija (za svaki korak napisati odgovarajuću komandu).

b)  Napisati SunRPC definiciju interfejsa koji omogućava pristup jednoj udaljenoj proceduri koja pronalazi
minimum  i  maksimum  elemenata  niza  celih  brojeva  koji  se  šalju  serveru.  Napisati  kako  izgleda  poziv
procedure u klijentskoj aplikaciji.

6.  Šta se dešava kada server promeni IP adresu u sistemu sa dinamičkim povezivanjem?

A.  Klijent automatski dobija novu adresu bez intervencije posrednika
B.  Server ažurira svoju registraciju kod bindera sa novom adresom
C.  Binder briše prethodnu adresu i prekida sve postojeće veze klijenata
D.  Klijent mora ručno da unese novu adresu servera

7.  Navesti  i  objasniti  sve  tipove  tranzijentnih  sinhronih  komunikacija.  Za  svaki  tip  navesti  odgovarajući

primer.

8.  a)  Koji od sledećih tipova komunikacije message queuing sistemi najčešće podržavaju?

A.  Sinhroni poziv udaljene procedure (RPC)
B.  Stream-based komunikacija
C.  Asinhrona komunikacija
D.  Peer-to-peer socket komunikacija

b)  Interfejs  koji  je  na  raspolaganju  aplikacijama  za  razmenu  poruka  kod  message-queuing  sistema.
Objasniti.

9.  a)  Događaji A, B, C i D u distribuiranom sistemu imaju sledeće vektorske časovnike

A[1,0,0],  B[2,0,0],

C[2,1,0],

D[1,2,0]

Koji od gore navedenih vektorskih časovnika nije moguć i zašto?

b)  Da li je tačna sledeća tvrdnja koja se odnosi na Lamportove markice. Obrazložiti odgovor.

10. a) Da li je sledeće skladište podataka sekvencijalno konzistentno?

Ako je L(A)<L(B), tada je A→B ili A||B.

Inicijalno:
P1:
P2:

x=0
W(x)1
W(x)2

y=0
R(y)0
R(x)0

Obrazložiti odgovor. Šta treba promeniti da bi se odgovor promenio?

b) Da li je sledeće skladište podataka kauzalno konzistentno? Obrazložiti odgovor.

Inicijalno:
P1:
P2:
P3:

x=0
W(x)1
R(x)1
R(y)1

y=0

W(y)1
R(x)0

11. a) Opisati Lamportov algoritam za rešavanje problema vizantijski generala. Pokazati da se u sistemu sa 3

procesa u kojem jedan proces ispoljava greške vizanitjskog tipa ne može postići konsenzus.

b) Koje strategije za oporovak od greške u distribuiranom sistemu postoje?

12. U Chord ringu koji koristi 9-to bitne identifikatore nalaze se sledeći čvorovi: 1, 12, 123, 234, 345, 456,
501. Čvor sa identifikatorom traži fajl sa ključem 10. Navedite redom listu čvorova koji će biti kontaktirani
da bi se pronašao fajl sa identifikatorom 10.

13. a)  Pretpostavimo  da  je  fajl  veličine  400MB  sačuvan  na  HDFS-u.  Ako  je  veličina  bloka  128MB  i
podrazumevani faktor replikacije 3, koliki je ukupni broj blokova i kolika je veličina svakog od njih?

b)  Koji mehanizmi u HDFS omogućavaju oporavak od kvara DataNode-a?

A.  Replikacija blokova na više DataNode-ova
B.  Periodično slanje heartbeat paketa NameNode-u
C.  Snapshot-ovanje metapodataka na NameNode-u
D.  Automatsko preusmeravanje klijentskih zahteva na sekundarne NameNode-ove

14.
U  .NET-u,  koristeći  gRPC,  napisati  servis  koji  simulira  rad  kalkulatora  koji  podržava  operaciju
sabiranja,  oduzimanja,  množenja  i  deljenja  celih  brojeva. Svaka  operacija  prihvata  dva  cela  broja  kao
argument, a povratna vrednost treba sadržati polja operand1, operand2, operacija i rezultat.

Definisati i proto fajl (april.proto) koji daje specifikaciju servisa i poruka.

15.
Korišćenjem  Java  RMI-a,  napisati  serversku  aplikaciju  koja  za  primljena  2  prirodna  broja  N  i  M,
prosleđena od strane klijenta, ima za cilj da generiše sve proste brojeve između brojeva N i M, pri čemu svaki
od elemenata vraća klijentu čim se element izgeneriše. Napisati klijentsku aplikaciju koja će minimalno
demonstrirati funkcionisanje sistema.

16.
Datoteka  input.dat  sadrži  ukupno  1MB  podataka.  Napisati  MPI  program  koji  vrši  obradu  ovih
podataka i priprema ih za vizualizaciju, ujedno vršeći paralelni upis i čitanje datoteke. Na početku, svi procesi
vrše čitanje iste količine podataka tako da prvi proces čita poslednji skup podataka, drugi proces pretposlednji
skup, itd. korišćenjem funkcija sa pojedinačnim pokazivačem. Pročitane podatke procesi upisuju u datoteku
april.dat, tako što ih dele na 2 jednaka dela i upisuju po šemi prikazanoj na slici (za slučaj od 4 procesa), pri
čemu je potrebno obratiti pažnju na paralelizaciju tog upisa.

17.
Koristeći WCF kreirati full-duplex sistem kalkulatora. Korisnik u svojoj sesiji može da obriše trenutno
računanje, doda broj, oduzme broj, pomnoži brojem i podeli rezultat prosleđenim brojem. Svaka operacija se
odmah izvršava nad rezultatom (prethodni rezultat) i smešta u rezultat. Svaka operacija vraća rezultat izvršene
operacije. Servis po izvršenju operacije poziva klijenta i prosleđuje mu do tog momenta kreirani izraz (Na
primer: izraz 2+3-5*7).

Obavezno  izdvojiti  interfejs,  implementaciju,  web.config  (dovoljan  je  samo  deo  za  setovanje  servisa  i  na
klijentskoj  strani  deo  za  callback)  i  klijentsku  stranu  koja  demonstrira  rad  servisa.  Klijentska  strana  mora
pozvati sve metode servisa i prikazati njihov rezultat ako postoji.

NAPOMENA: Radovi koji budu sadržali tragove grafitne olovke će biti diskvalifikovani!