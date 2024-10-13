package Praktikum;

import java.util.Random;

public class Aufgabe3 {

	private static final int BASIS = 2;
	private static final int MODULUS = 29;

	public static int privatenSchluesselGenerieren() {

		Random zufall = new Random();
		return zufall.nextInt(MODULUS - 2) + 2;
	}

	public static int oeffentlichenSchlüsselBerechnen(int privaterSchluessel) {
		return modExp(BASIS, privaterSchluessel, MODULUS);
	}

	public static int geheimerSchluesselGenerieren(int privaterSchluessel, int andererOeffentlicherSchluessel) {
		return modExp(andererOeffentlicherSchluessel, privaterSchluessel, MODULUS);
	}

	private static int modExp(int basis, int exponent, int modulus) {
		if (modulus == 1)
			return 0;
		int ergebnis = 1;
		basis = basis % modulus;
		while (exponent > 0) {
			if (exponent % 2 == 1)
				ergebnis = (ergebnis * basis) % modulus;
			exponent = exponent >> 1;
			basis = (basis * basis) % modulus;
		}
		return ergebnis;
	}

	public static void main(String[] args) {
		int privaterSchluesselA = privatenSchluesselGenerieren();
		int oeffentlicherSchlüsselA = oeffentlichenSchlüsselBerechnen(privaterSchluesselA);

		int privaterSchluesselB = privatenSchluesselGenerieren();
		int oeffentlicherSchluesselB = oeffentlichenSchlüsselBerechnen(privaterSchluesselB);

		int gemeinsamerGeheimerSchluesselA = geheimerSchluesselGenerieren(privaterSchluesselA, oeffentlicherSchluesselB);

		int gemeinsamerGeheimerSchluesselB = geheimerSchluesselGenerieren(privaterSchluesselB, oeffentlicherSchlüsselA);

		System.out.println("Benutzer A gemeinsamer geheimer Schlüssel: " + gemeinsamerGeheimerSchluesselA);
		System.out.println("Benutzer B gemeinsamer geheimer Schlüssel: " + gemeinsamerGeheimerSchluesselB);
	}
}
