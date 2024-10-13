package Praktikum;

import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.util.Arrays;

public class Aufgabe2 {
	public static void main(String[] args) throws Exception {
	
		String eingabedatei = "Aufgabe2.bin";
		String ausgabedatei = "Aufgabe2_encrypted.bin";
		String schlussel = "ITS-Prakt2024";

	
		byte[] byteschlussel = schlussel.getBytes("UTF-8");
		byte[] konvschlussel = Arrays.copyOf(byteschlussel, 16); // AES-128

		
		byte[] eingabetext = Files.readAllBytes(Paths.get(eingabedatei));

		
		SecureRandom random = new SecureRandom();
		byte[] iv = new byte[16];
		random.nextBytes(iv);

	
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		SecretKeySpec privatschlussel = new SecretKeySpec(konvschlussel, "AES");
		IvParameterSpec ivSpec = new IvParameterSpec(iv);
		cipher.init(Cipher.ENCRYPT_MODE, privatschlussel, ivSpec);

		
		byte[] verschltext = cipher.doFinal(eingabetext);

	
		try (FileOutputStream outputStream = new FileOutputStream(ausgabedatei)) {
			outputStream.write(iv);
			outputStream.write(verschltext);
		}

		System.out.println("Datei erfolgreich verschlüsselt: " + ausgabedatei);
	}
}

