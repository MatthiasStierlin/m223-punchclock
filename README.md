# M223: Punchclock
Dies ist ein Fork der Beispielapplikation PunchClock für das Modul M223 der ZLI.

Die Applikation kann folgendes tun:
* Sie können sich registrieren und anmelden.
* Sie können ihre arbeitszeiten erfassen.
* Sie können die Abteilungen ihrer Firma verwalten.
* Sie können die Projekte ihrer Firma verwalten.

## Loslegen
Folgende Schritte befolgen um loszulegen:
1. Sicherstellen, dass JDK 12 installiert und in der Umgebungsvariable `path` definiert ist.
1. Ins Verzeichnis der Applikation wechseln und über die Kommandozeile mit `./gradlew bootRun` oder `./gradlew.bat bootRun` starten
1. Unittest mit `./gradlew test` oder `./gradlew.bat test` ausführen.
1. Ein ausführbares JAR kann mit `./gradlew bootJar` oder `./gradlew.bat bootJar` erstellt werden.

Folgende Dienste stehen während der Ausführung im Profil `dev` zur Verfügung:
- REST-Schnittstelle der Applikation: http://localhost:8081
- Dashboard der H2 Datenbank: http://localhost:8081/h2-console