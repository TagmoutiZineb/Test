package Praktikum;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Aufgabe1 {

	public static String Dateieinlesen(String dateiname) throws IOException {
		StringBuffer inhalt = new StringBuffer(); 
		BufferedReader reader = new BufferedReader(new FileReader(dateiname)); // Verwende den übergebenen
																					// Dateinamen
		String line;
		while ((line = reader.readLine()) != null) {
			inhalt.append(line).append("\n");
		}
		reader.close();
		return inhalt.toString();
	}

	public static Map<Character, Double> haeufigkeitberechnen(String text) {
		text = text.toLowerCase();
		Map<Character, Integer> charCount = new HashMap<>();
		int gesamt = 0;

		for (char b : text.toCharArray()) {
			if (Character.isLetter(b)) {
				charCount.put(b, charCount.getOrDefault(b, 0) + 1);
				gesamt++;
			}
		}

		Map<Character, Double> haeufigkeit = new HashMap<>();
		for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
			char b = entry.getKey();
			int wert = entry.getValue();
			haeufigkeit.put(b, (double) wert / gesamt);
		}

		return haeufigkeit;
	}

	public static void haeufigkeitdiagramm(Map<Character, Double> haeufigkeit) {
		int width = 1300;
		int height = 400;

		JFrame frame = new JFrame("Letter Frequency Analysis");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setVisible(true);

		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				Graphics2D g2d = (Graphics2D) g;

			
				int panelWidth = getWidth();
				int panelHeight = getHeight();

				
				int abstand = 30;

				
				double maxhaeufigkeit = haeufigkeit.values().stream().max(Double::compare).orElse(0.0);

				
				int balken = (panelWidth - 2 * abstand) / 20; // Anzl der sichtbare Balken

				
				g2d.drawLine(abstand, panelHeight - abstand, panelWidth - abstand, panelHeight - abstand); // X-Achse zeichnen
				g2d.drawLine(abstand, abstand, abstand, panelHeight - abstand); // Y-Achse zeichnene

				
				g2d.drawString("Buchstabe", panelWidth / 2, panelHeight - abstand / 8); // X-Achse Beschriftung
				g2d.drawString("Häufigkeit", abstand / 2, panelHeight / 26); // Y-Achse Beschriftung

				
				int x = abstand * 2;
				int barWidth = (panelWidth - 3 * abstand) / balken;  // Zeichnen der Balken für jeden Buchstabenhäufigkeit

				for (Map.Entry<Character, Double> entry : haeufigkeit.entrySet()) {
					char buchstabe = entry.getKey();
					double haeufigkeitderbuchstabe = entry.getValue();

					int barHeight = (int) (haeufigkeitderbuchstabe / maxhaeufigkeit * (panelHeight - 2 * abstand));

				
					g2d.setColor(Color.GRAY);   // färben
					g2d.fillRect(x, panelHeight - abstand - barHeight, barWidth, barHeight);  // zeichen im (x,y) mit barwidth und barheight maßnahmen 

					g2d.setColor(Color.BLACK);   // färben der Buchstaben 
					g2d.drawString(String.valueOf(buchstabe), x + barWidth / 2, panelHeight - abstand + 15);   // beschrifftung der balken mit buchstaben

					g2d.drawString(String.format("%.2f", haeufigkeitderbuchstabe), x + barWidth / 8,panelHeight - abstand - barHeight - 5); // der prozentuale häufigkeit jeder Buchstabe 

					
					x += barWidth + abstand;    // Position für den nächsten Balken aktualisieren

					
					if (x > panelWidth - abstand) {
						break;
					}
				}
			}
		};

		frame.add(panel);
	}

	public static String entschlusltertext(String text, Map<Character, Character> haeufigkeitmappe) {
		StringBuffer entschlusltertext = new StringBuffer();
		for (char b : text.toCharArray()) {
			char kleineB = Character.toLowerCase(b);
			if (Character.isLetter(kleineB) && haeufigkeitmappe.containsKey(kleineB)) {
				char entschluseltechar = haeufigkeitmappe.get(kleineB);
				entschlusltertext.append(Character.isLowerCase(b) ? entschluseltechar : Character.toUpperCase(entschluseltechar));
			} else {
				entschlusltertext.append(b);
			}
		}
		return entschlusltertext.toString();
	}

	public static void main(String[] args) throws IOException {
		String dateiname = "Aufgabe1.txt"; // Hier den Dateinamen anpassen, falls nötig
		String text = Dateieinlesen(dateiname);
		Map<Character, Double> haeufigkeit = haeufigkeitberechnen(text);
		haeufigkeitdiagramm(haeufigkeit);

		// entschlüsselung der Buchstaben im text mit hilfe der Vergleichen von Häufigkeit der Buchstaben im Deutschsprache und im unsere text 
		Map<Character, Character> standardhaeufigkeit = new HashMap<>();
		standardhaeufigkeit.put('a', 'i');
		standardhaeufigkeit.put('b', 'y');
		standardhaeufigkeit.put('c', 'k');
		standardhaeufigkeit.put('d', 'l');
		standardhaeufigkeit.put('e', 'm');
		standardhaeufigkeit.put('f', 'n');
		standardhaeufigkeit.put('g', 'o');
		standardhaeufigkeit.put('h', 'p');
		standardhaeufigkeit.put('i', 'z');
		standardhaeufigkeit.put('j', 'r');
		standardhaeufigkeit.put('k', 's');
		standardhaeufigkeit.put('l', 't');
		standardhaeufigkeit.put('m', 'u');
		standardhaeufigkeit.put('n', 'v');
		standardhaeufigkeit.put('o', 'w');
		standardhaeufigkeit.put('p', 'x');
		standardhaeufigkeit.put('q', 'q');
		standardhaeufigkeit.put('r', 'j');
		standardhaeufigkeit.put('s', 'a');
		standardhaeufigkeit.put('t', 'b');
		standardhaeufigkeit.put('u', 'c');
		standardhaeufigkeit.put('v', 'd');
		standardhaeufigkeit.put('w', 'e');
		standardhaeufigkeit.put('x', 'f');
		standardhaeufigkeit.put('y', 'g');
		standardhaeufigkeit.put('z', 'h');

		String entschlussletertextfinal = entschlusltertext(text, standardhaeufigkeit);
		System.out.println("Entschlüsselter Text:");
		System.out.println(entschlussletertextfinal);
	}
}
