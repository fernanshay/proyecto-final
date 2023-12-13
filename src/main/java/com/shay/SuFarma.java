package com.shay;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;

import java.util.ArrayList;
import java.util.List;

public class SuFarma extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Administrador de Medicamentos");

        // Elementos de la UI
        TextField searchField = new TextField();
        TextField basePriceField = createNumberField();
        Button searchButton = new Button("Buscar");
        TableView<Medicamento> priceTable = new TableView<>();

        // Tabla
        TableColumn<Medicamento, String> labColumn = new TableColumn<>("Laboratorio");
        TableColumn<Medicamento, Double> priceColumn = new TableColumn<>("Precio");
        labColumn.setCellValueFactory(new PropertyValueFactory<>("laboratorio"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("precio"));
        priceTable.getColumns().addAll(labColumn, priceColumn);

        // Layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(searchField, basePriceField, searchButton, priceTable);

        List<Medicamento> data = new ArrayList<>();
        ObservableList<Medicamento> medicamentos = FXCollections.observableArrayList(data);
        priceTable.setItems(medicamentos);
        searchButton.setOnAction(e -> searchMedicine(searchField.getText(), basePriceField.getText(), medicamentos, priceTable));

        Scene scene = new Scene(layout, 400, 350);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void searchMedicine(String medicine, String basePrice, ObservableList<Medicamento> data, TableView<Medicamento> table) {
        // Limpiar la tabla
        data.clear();

        // Validar que el campo de precio base no esté vacío
        if (!basePrice.isEmpty()) {
            double base = Double.parseDouble(basePrice);

            // Definición de aumento de precios
            double aumentoRoche = 0.05;
            double aumentoLuza = 0.04;
            double aumentoMedifarma = 0.03;
            double aumentoOtro = 0.02;

            // Precio aumentado
            double precioRoche = base * (1 + aumentoRoche);
            double precioLuza = base * (1 + aumentoLuza);
            double precioMedifarma = base * (1 + aumentoMedifarma);
            double precioOtro = base * (1 + aumentoOtro);

            // Medicamentos (objetos)
            if (medicine.equalsIgnoreCase("Paracetamol")) { // Paracetamol
                data.add(new Medicamento("Paracetamol", "Roche", precioRoche));
                data.add(new Medicamento("Paracetamol", "Luza", precioLuza));
                data.add(new Medicamento("Paracetamol", "Medifarma", precioMedifarma));
                data.add(new Medicamento("Paracetamol", "Otro", precioOtro));
            } else if (medicine.equalsIgnoreCase("Ibuprofeno")) { // Ibuprofeno
                data.add(new Medicamento("Ibuprofeno", "Roche", precioRoche));
                data.add(new Medicamento("Ibuprofeno", "Luza", precioLuza));
                data.add(new Medicamento("Ibuprofeno", "Medifarma", precioMedifarma));
                data.add(new Medicamento("Ibuprofeno", "Otro", precioOtro));
            } else if (medicine.equalsIgnoreCase("Amoxicilina")) { // Amoxicilina
                data.add(new Medicamento("Amoxicilina", "Roche", precioRoche));
                data.add(new Medicamento("Amoxicilina", "Luza", precioLuza));
                data.add(new Medicamento("Amoxicilina", "Medifarma", precioMedifarma));
                data.add(new Medicamento("Amoxicilina", "Otro", precioOtro));
            } else if (medicine.equalsIgnoreCase("Omeprazol")) { // Omeprazol
                data.add(new Medicamento("Omeprazol", "Roche", precioRoche));
                data.add(new Medicamento("Omeprazol", "Luza", precioLuza));
                data.add(new Medicamento("Omeprazol", "Medifarma", precioMedifarma));
                data.add(new Medicamento("Omeprazol", "Otro", precioOtro));
            }
        }

        // Actualizar la tabla con los resultados de búsqueda
        table.setItems(data);
    }

    private TextField createNumberField() {
        TextField textField = new TextField();
        TextFormatter<Double> textFormatter = new TextFormatter<>(new DoubleStringConverter());
        textField.setTextFormatter(textFormatter);
        return textField;
    }

    // Clase Medicamento
    public static class Medicamento {
        private final String nombre;
        private final String laboratorio;
        private final double precio;

        public Medicamento(String nombre, String laboratorio, double precio) {
            this.nombre = nombre;
            this.laboratorio = laboratorio;
            this.precio = precio;
        }

        public String getNombre() {
            return nombre;
        }

        public String getLaboratorio() {
            return laboratorio;
        }

        public double getPrecio() {
            return precio;
        }
    }
}
