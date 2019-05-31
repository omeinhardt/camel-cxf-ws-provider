# camel-cxf-ws-provider

Beispielprojekt für das Bereitstellen eines SOAP Web Services in einer Apache Camel Anwendung, die in einer Oracle WebLogic Server 11g-Umgebung läuft, mittels Apache CXF.

## Voraussetzungen ##

Java 8, Maven 3.2.3

## Projektstruktur ##

 - Root-Verzeichnis:
 Allgemeine pom.xml
 - jar:
    WSDL- und XSD-Datei des Web Services
 - war:
    Definition der Camel Route
    CXF-Konfiguration für die Bereitstellung des Web Services und Einbindung von CXF Interceptors
 - ear:
    WebLogic-spezifische Konfigurationsdateien

## Build ##
Im Root-Verzeichnis Aufruf von

    mvn clean install

Erzeugt wird eine deploybare .ear-Datei.