package Übung2;

import javafx.stage.Stage;

public class AnwendersystemControl {

	private AnwendersystemModel anwModel;
	private AnwendersystemView anwView;

	public AnwendersystemControl(Stage primaryStage) {
		this.anwModel = new AnwendersystemModel();
		this.anwView = new AnwendersystemView(this, primaryStage, anwModel);
	}

	public void schreibinDatei(String text) {
		try {
			this.anwModel.schreibeinDatei(text);
			this.anwView.zeigInformationFenster("Der Text wurde in die Datei geschrieben");
		} catch (Exception e) {
			this.anwView.zeigFehlermeldung("Der Text wurde nicht in die Datei geschrieben");
		}
	}

}
