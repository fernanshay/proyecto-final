package com.shay;

import java.util.*;

public class AztecaFarma {
    public static void main(String[] args) {
        // Crear algunos medicamentos y laboratorios de ejemplo
        Laboratorio lab1 = new Laboratorio("Lab A");
        lab1.agregarMedicamento("Paracetamol", 5.99);
        lab1.agregarMedicamento("Ibuprofeno", 7.50);

        Laboratorio lab2 = new Laboratorio("Lab B");
        lab2.agregarMedicamento("Aspirina", 4.75);
        lab2.agregarMedicamento("Omeprazol", 9.99);

        // Mostrar la lista de medicamentos y precios
        System.out.println("Lista de Medicamentos Disponibles en la Farmacia:\n");

        for (Laboratorio laboratorio : Arrays.asList(lab1, lab2)) {
            System.out.println("Laboratorio: " + laboratorio.nombre);
            System.out.println("+----------------------+");
            System.out.println("| Medicamento | Precio |");
            System.out.println("+----------------------+");

            for (Medicamento medicamento : laboratorio.medicamentos) {
                System.out.printf("| %-12s | %-6.2f |\n", medicamento.nombre, medicamento.precio);
            }

            System.out.println("+----------------------+\n");
        }
    }
}

class Medicamento {
    String nombre;
    double precio;

    Medicamento(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Object precioProperty() {
        return null;
    }
}

class Laboratorio {
    String nombre;
    List<Medicamento> medicamentos;

    Laboratorio(String nombre) {
        this.nombre = nombre;
        this.medicamentos = new ArrayList<>();
    }

    void agregarMedicamento(String nombre, double precio) {
        medicamentos.add(new Medicamento(nombre, precio));
    }
}