package Übung2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AnwendersystemModel {

	public AnwendersystemModel() {

	}

	public String getÜberschrift() {
		return "Hallo";
	}

	public void schreibeinDatei(String text) throws IOException {
		BufferedWriter buffer = new BufferedWriter(new FileWriter("Text.txt"));
		buffer.write(text);
		buffer.close();
	}
}
