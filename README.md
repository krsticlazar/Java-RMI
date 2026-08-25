# Java RMI Practice - Distributed Systems

This repository contains Java RMI practice material, solved exercises, and exam preparation notes for the **Distributed Systems** course at the **Faculty of Electronic Engineering, University of Niš**.

The goal of the repository is to keep the examples simple, close to classroom/lab style, and easy to run from the terminal without Maven, Gradle, or additional frameworks.

## Contents

- `Lab 01` - mathematical quiz RMI example.
- `Lab 02` - mobile operator simulation.
- `Lab 03` - electronic banking simulation.
- `Lab 04` - exam registration system.
- `Lab 05` - auction system with remote exhibit objects.
- `Ispit APR26` - prime-number generation with callback-based delivery.
- `Ispit JUN24` - MQTT broker simulation with publishing, subscriptions, and callbacks.
- `Ispit KOL124` - football score tracking with remote matches and callbacks.
- `Ispit KOL126` - stock-price tracking with callback notifications.
- `Dodatni 01` - electronic voting with server-side `Map` and `Set` state.
- `Dodatni 02` - digital library with remote books and serializable snapshots.
- `Dodatni 03` - FIFO queue system with per-ticket callbacks.
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

All Java files for a task are kept directly in that task's folder. The workflow is:

```powershell
javac *.java
java Server
java Klijent
```

Each task folder contains its own run instructions.

## Purpose

This repository is primarily a study workspace for understanding Java RMI through practical tasks. It is also organized as exam preparation material, with notes focused on what should be written in an exam notebook rather than only on complete runnable applications.
