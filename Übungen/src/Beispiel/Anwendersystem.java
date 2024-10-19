package Beispiel; 
import java.io.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Anwendersystem extends Application {
	private Geburtsdatum geburtsdatum;

	// ---Anfang Attribute der grafischen Oberflaeche---
	private Pane pane = new Pane();
	private Label lblEingabe = new Label("Eingabe");
	private Label lblAnzeige = new Label("Anzeige");
	private Label lblGeburtstag = new Label("Geburtstag :");
	private Label lblGeburtsmonat = new Label("Geburtsmonat:");
	private Label lblGeburtsjahr = new Label("Geburtsjahr :");
	private TextField txtGeburtstag = new TextField();
	private TextField txtGeburtsmonat = new TextField();
	private TextField txtGeburtsjahr = new TextField();
	private TextArea txtAreaAnzeige = new TextArea();
	private Button btnEingabe = new Button("Eingabe");
	private Button btnAnzeige = new Button("Anzeige");
	private MenuBar mnbrMenuLeiste = new MenuBar();
	private Menu mnDatei = new Menu("Datei");
	private MenuItem mnItmCsvExport = new MenuItem("csv-Export");

	// -------Ende Attribute der grafischen Oberflaeche-------
	private void initKomponenten() {
		// Labels
		lblEingabe.setLayoutX(20);
		lblEingabe.setLayoutY(40);
		Font font = new Font("Arial", 24);
		lblEingabe.setFont(font);
		lblEingabe.setStyle("-fx-font-weight: bold;");
		lblAnzeige.setLayoutX(310);
		lblAnzeige.setLayoutY(40);
		lblAnzeige.setFont(font);
		lblAnzeige.setStyle("-fx-font-weight: bold;");
		lblGeburtstag.setLayoutX(20);
		lblGeburtstag.setLayoutY(90);
		lblGeburtsmonat.setLayoutX(20);
		lblGeburtsmonat.setLayoutY(130);
		lblGeburtsjahr.setLayoutX(20);
		lblGeburtsjahr.setLayoutY(170);
		pane.getChildren().addAll(lblEingabe, lblAnzeige, lblGeburtstag, lblGeburtsmonat, lblGeburtsjahr);
		// Textfelder
		txtGeburtstag.setLayoutX(120);
		txtGeburtstag.setLayoutY(90);
		txtGeburtsmonat.setLayoutX(120);
		txtGeburtsmonat.setLayoutY(130);
		txtGeburtsjahr.setLayoutX(120);
		txtGeburtsjahr.setLayoutY(170);
		pane.getChildren().addAll(txtGeburtstag, txtGeburtsmonat, txtGeburtsjahr);
		// Textbereich
		txtAreaAnzeige.setEditable(false);
		txtAreaAnzeige.setLayoutX(310);
		txtAreaAnzeige.setLayoutY(90);
		txtAreaAnzeige.setMaxWidth(230);
		txtAreaAnzeige.setMaxHeight(100);
		pane.getChildren().add(txtAreaAnzeige);
		// Buttons
		btnEingabe.setLayoutX(20);
		btnEingabe.setLayoutY(210);
		btnAnzeige.setLayoutX(310);
		btnAnzeige.setLayoutY(210);
		pane.getChildren().addAll(btnEingabe, btnAnzeige);
// Menu
		this.mnbrMenuLeiste.getMenus().add(mnDatei);
		this.mnDatei.getItems().add(mnItmCsvExport);
		pane.getChildren().add(mnbrMenuLeiste);
	}

	private void initListener() {
		btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				nehmeGeburtsdatumAuf();
			}
		});
		btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				zeigeGeburtsdatumAn();
			}
		});
		mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				schreibeGeburtsdatumInDatei();
			}
		});
	}

	private void nehmeGeburtsdatumAuf() {
		try {
			geburtsdatum = new Geburtsdatum(txtGeburtstag.getText(), txtGeburtsmonat.getText(),
					txtGeburtsjahr.getText());
			zeigeInformationsfensterAn("Das Geburtsdatum wurde aufgenommen!");
		} catch (Exception exc) {
			zeigeFehlermeldungAn("Fehler bei der Aufnahme des Geburtsdatums!");
		}
	}

	private void zeigeGeburtsdatumAn() {
		if (this.geburtsdatum != null) {
			txtAreaAnzeige.setText(this.geburtsdatum.gibGeburtsdatumZurueck());
		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Geburtsdatum aufgenommen.");
		}
	}

	private void schreibeGeburtsdatumInDatei() {
		try {
			BufferedWriter aus = new BufferedWriter(new FileWriter("Geburtsdaten.csv"));
			aus.write(this.geburtsdatum.gibGeburtsdatumZurueck());
			aus.close();
			zeigeInformationsfensterAn("Geburtsdatum wurde gespeichert!");
		} catch (IOException ioExc) {
			zeigeFehlermeldungAn("Fehler beim Speichern des Geburtsdatums!");
		} catch (Exception exc) {
			zeigeFehlermeldungAn("Ein unbekannter Fehler ist aufgetreten!");
		}
	}

	private void zeigeInformationsfensterAn(String meldung) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information");
		alert.setContentText(meldung);
		alert.showAndWait();
	}

	private void zeigeFehlermeldungAn(String meldung) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Fehlermeldung");
		alert.setContentText(meldung);
		alert.showAndWait();
	}

	@Override
	public void start(Stage primaryStage) {
		Scene scene = new Scene(this.pane, 560, 260);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Verwaltung von Geburtsdaten");
		primaryStage.show();
		this.initKomponenten();
		this.initListener();
	}

	public static void main(String... args) {
		launch(args);
	}
}