Elektronski fakultet
Katedra za računarstvo

26.4.2024.

DISTRIBUIRANI SISTEMI - I KOLOKVIJUM

Teorija:

1.  Navesti i ukratko objasniti prednosti distribuiranih u odnosu na centralizovane sisteme.

2.  Šta se podrazumeva pod pristupnom transparentnošću:

a)  Udaljenim resursima se pristupa korišćenjem lokaciono nezavisnih imena
b)  lokalnim i udaljenim resursima se pristupa korišćenjem istih operacija
c)  repliciranim resursima se pristupa kao da postoji samo jedna kopija
d)  resurs će upravljati svim zahtevima na isti način bez obzira na lokaciju klijenta

A.  Koji su načini prenosa parametara kod poziva udaljene procedure? Objasniti.
B.  Koja je uloga portmappera kod Sun RPC? Gde se izvršava i koje informacije čuva?
C.  Napisati  SunRPC  definiciju  interfejsa  koji  omogućava  pristup  jednoj  udaljenoj
proceduri  koja  u  datom  nizu  pronalazi  maksimalni  element  u  nizu  i  indeks
maksimalnog  elementa.  Napisati  kako  bi  izgledao  poziv  udaljene  procedure  u
klijentskoj aplikaciji. Pre poziva procedure, inicijalizovati potrebne parametre.

3.

4.

A.  Koji su nedostaci statičkog povezivanja kod RPC? Da li i kako mogu biti otklonjeni

dinamičkim povezivanjem?

B.  Šta predstavlja uuid kod DCE RPC, koja je njegova uloga i kako se generiše?
C.  DCE  direktorijumski  servis  (cell  directory  service)  u  slučaju  poziva  udaljene

procedure omogućava da:

a)  Klijent pronađe broj porta na kome je implementirana udaljena procedura
b)  Klijent pronađe na kom serveru je implementirana udaljena procedura
c)  Server obavi prozivku klijenta
d)  Distribuciju objekata između više čvorova

5.

Interfejs  koji  je  na  raspolaganju  aplikacijama  za  razmenu  poruka  kod  publish-subscribe
sistema

Zadaci:

1.  U  .NET-u,  koristeći  gRPC,  kreirati  servis  za  upravljanje  listom  zadataka.  Servis  treba  da
omogući klijentima da dodaju zadatke, prikažu sve zadatke i označe zadatke kao završene.

Zahtevi:

•  Definisati proto fajl (tasks.proto) koji daje specifikaciju servisa i poruka. Servis treba

da podržava sledeće operacije:
o  AddTask: Dodaje novi zadatak na listu.
o  ListTasks: Dobija listu svih zadataka.
o  MarkTaskAsCompleted: Označava zadatak kao završen po njegovom ID-u.
Implementirati gRPC server definisan u tasks.proto fajlu

•

2.  Napisati RMI kôd koji implementira udaljeni pristup serveru za praćenje rezultata fudbalskih

utakmica.

Implementirati  klasu  Match  sa  atributima  (int  id,  String  homeTeam,  String  awayTeam,  int
homeGoals,  int  awayGoals,  Stadium  stadium  –  sa  atributima  String  name  i  String  city).
Metode  klase  Match  treba  da  omoguće  korisniku  da  doda  gol  domaćem,  odnosno
gostujućem  timu,  i  da  preuzme  stadion  na  kome  se  igra  utakmica.  Pored  toga,  potrebno  je
implemenirati  udaljenu  metodu  koja  će  vratiti  String  literal  koji  će  sadržati  id  i  trenutni
rezultat  utakmice.  Potrebno  je  omogućiti  korisnicima  da  se  pretplate  na  promenu  rezultata
utakmice. Callback interfejs sadrži popis udaljene metode resultChanged(int matchId).
Klasa FootballScore treba omogućiti klijentima da pozovu metodu koja vraća  String literal
koji će sadržati identifikatore i rezultate svih utakmica koje postoje u sistemu, kao i metodu
za preuzimanje jedne utakmice. U konstruktoru klase kreirati dva objekta klase  Match, čije
su  vrednosti  identifikatora  1  i  2,  respektivno,  i  smestiti  ih  u  odgovarajuću  strukturu
podataka.

Implementirati serversku klasu Server koja kreira objekat klase FootballScore i upisuje ga u
RMI registar na portu 4096. Kôd klijentske klase ClientUser treba da prikaže sve utakmice,
naziv stadiona na kome se igra utakmica sa id-jem 2, da se pretplati na događaje utakmice sa
id-jem  1,  kao  i  da  implementira  Callback  interfejs  tako  da  korisnik  bude  u  toku  sa
rezultatom  utakmice.  Kôd  klijentske  klase  ClientAdmin  treba  da  doda  gol  domaćem  timu
utakmice sa id-jem 1.

3.  Napisati  MPI  program  koji  vrši  paralelni  upis  i  čitanje  binarne  datoteke,  prema  sledećim

zahtevima:

1)  Svaki proces upisuje N slučajno generisanih celih brojeva u datoteku dat.dat. Upis se
vrši  upotrebom  pojedinačnih  pokazivača,  dok  redosled  podataka  u  fajlu  ide  od
podataka poslednjeg do podataka prvog procesa.

2)  Ponovo  otvoriti  datoteku.  Svi  procesi  vrše  čitanje  N  podataka  iz  datoteke  dat.dat,
tako  da  se  ne  može  predvideti  koji  će  proces  pročitati  koji  deo  datoteke.  Obratiti
pažnju na konzistentnost prilikom čitanja.