package Übung2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AnwendersystemView {

	private AnwendersystemControl anwControl;
	private AnwendersystemModel anwModel;
	private GridPane grid = new GridPane();
	private TextField txtest = new TextField();
	private Button btn = new Button("Schreiben in Datei");

	public AnwendersystemView(AnwendersystemControl anwControl, Stage primaryStage, AnwendersystemModel anwModel) {
		this.anwControl = anwControl;
		this.anwModel = anwModel;
		this.grid.setAlignment(Pos.CENTER);
		this.grid.setHgap(20);
		this.grid.setVgap(20);
		this.grid.setPadding(new Insets(30, 30, 30, 30));
		primaryStage.setTitle(this.anwModel.getÜberschrift());
		Scene scene = new Scene(grid, 350, 150);
		primaryStage.setScene(scene);
		primaryStage.show();
		this.intitKomponenten();
		this.initListener();

	}

	private void intitKomponenten() {
		this.grid.add(txtest, 0, 0);
		this.grid.add(btn, 1, 0);
	}

	private void initListener() {
		btn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				anwControl.schreibinDatei(txtest.getText());
			}
		});
	}

	void zeigInformationFenster(String meldung) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information");
		alert.setContentText(meldung);
		alert.showAndWait();
	}

	void zeigFehlermeldung(String meldung) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Fehlermeldung");
		alert.setContentText(meldung);
		alert.showAndWait();
	}

}
