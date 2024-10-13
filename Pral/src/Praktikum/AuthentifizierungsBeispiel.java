package Praktikum;
import java.util.Scanner;

public class AuthentifizierungsBeispiel {

    // Diese Methode führt eine einfache Authentifizierung durch
    // Sie gibt true zurück, wenn die userId größer oder gleich 1337 ist
    public static boolean authentifizieren(int benutzerId) {
        return benutzerId == 1337;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int benutzerId;
        boolean istAuthentifiziert = false;

        // Benutzer wird aufgefordert, eine Benutzer-ID einzugeben
        System.out.print("Geben Sie die Benutzer-ID ein: ");
        benutzerId = scanner.nextInt();

        // Authentifizierung überprüfen, indem die Methode authentifizieren aufgerufen wird
        istAuthentifiziert = authentifizieren(benutzerId);

        // Ausgabe basierend auf dem Ergebnis der Authentifizierung
        if (istAuthentifiziert) {
            System.out.println("Authentifizierung erfolgreich!");
        } else {
            System.out.println("Authentifizierung fehlgeschlagen!");
        }

        // Scanner schließen, um Ressourcen freizugeben
        scanner.close();
    }
}