package be.pxl.ja.streamingservice.controller;

import javafx.scene.control.Alert;

public class ErrorHandler {

	public static void showError(Exception e) {

		new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
	}

}
