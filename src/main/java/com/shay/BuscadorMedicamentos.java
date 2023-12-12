package com.shay;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class BuscadorMedicamentos extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Buscador de Medicamentos");

        // Barra de búsqueda
        TextField searchField = new TextField();
        searchField.setPromptText("Buscar medicamento...");
        searchField.setPrefWidth(300);

        // Lista de sugerencias
        ListView<String> suggestionsList = new ListView<>();
        suggestionsList.setItems(FXCollections.observableArrayList(
                "Ibuprofeno",
                "Paracetamol",
                "Amoxicilina",
                "Omeprazol",
                "Loratadina"
        ));

        // Descripción del medicamento y tabla de precios
        TextArea descriptionArea = new TextArea();
        descriptionArea.setEditable(false);
        descriptionArea.setWrapText(true);

        TableView<String> pricesTable = new TableView<>();
        //TableColumn<String, String> labColumn = new TableColumn<>("Laboratorio");
        //TableColumn<String, String> priceColumn = new TableColumn<>("Precio");
        //pricesTable.getColumns().addAll(labColumn, priceColumn);

        // Diseño de la interfaz
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(searchField, suggestionsList, descriptionArea, pricesTable);

        // Evento de selección en la lista de sugerencias
        suggestionsList.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    // Aquí deberías cargar la información del medicamento seleccionado
                    // y actualizar la descripción y la tabla de precios
                    descriptionArea.setText("Información de " + newValue);
                    // Actualizar la tabla de precios con información del medicamento seleccionado
                });

        // Configurar la escena
        Scene scene = new Scene(layout, 500, 400);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
