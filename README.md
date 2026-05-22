# Java RMI Practice - Distributed Systems

This repository contains Java RMI practice material, solved exercises, and exam preparation notes for the **Distributed Systems** course at the **Faculty of Electronic Engineering, University of Niš**.

The goal of the repository is to keep the examples simple, close to classroom/lab style, and easy to run from the terminal without Maven, Gradle, or additional frameworks.

## Contents

- `z01 Matematicki kviz` - mathematical quiz RMI example, including a separated `Server`, `Klijent`, and `Shared` structure.
- `z02 Mobilni operater` - mobile operator simulation with remote user operations and account state handling.
- `z03 eBanka` - electronic banking simulation with remote banking/user logic.
- `z04 Prijava ispita` - exam registration system implemented with Java RMI.
- `z05 Aukcija` - auction system with remote auction and exhibit objects.
- `APR26` - exam-style task for generating prime numbers with callback-based delivery.
- `JUN24` - exam-style MQTT broker simulation using topics, publishing, subscribing, and callbacks.
- `KOL124` - football score tracking system with remote matches and result-change callbacks.
- `.docs` - prepared notes and final explanations based on Java RMI lectures.
- `.zips` - reference examples from practical classes.

Most task folders include:

- Java source files for the RMI solution.
- `objasnjenje.md` with a structured explanation of the solution.
- `pokretanje.txt` or `uputstvo.txt` with short run instructions.
- Original task text or supporting materials where available.

## Technical Scope

The repository focuses on core Java RMI concepts:

- remote interfaces with `Remote` and `RemoteException`;
- server-side implementations with `UnicastRemoteObject`;
- RMI registry usage with `LocateRegistry` and `Naming.rebind`;
- client-side lookup with `Naming.lookup`;
- serializable data transfer objects;
- callback-based communication;
- separating shared contracts from server and client implementations;
- writing exam-oriented minimal solutions.

## Running Examples

The examples are intentionally kept as plain Java projects. In most folders, the workflow is:

```powershell
javac *.java
java Server
java Klijent
```

For exercises that are split into `Server`, `Klijent`, and `Shared`, compile from the server or client folder with:

```powershell
javac -d . ..\Shared\*.java *.java
```

Each task folder contains its own run instructions.

## Purpose

This repository is primarily a study workspace for understanding Java RMI through practical tasks. It is also organized as exam preparation material, with notes focused on what should be written in an exam notebook rather than only on complete runnable applications.

