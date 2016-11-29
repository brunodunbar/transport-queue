package com.brunodunbar.transportqueue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;


public class AppController  {

    @FXML
    private TableView<Carga> cargasTable;

    private Transportadora transportadora;

    private FileChooser abrirFileChooser;
    private FileChooser salvarFileChooser;

    @FXML
    public void initialize() {
        transportadora = new Transportadora();
        cargasTable.setItems(transportadora.getObservableList());
    }

    public void adicionarCarga(ActionEvent actionEvent) {
        new CargaDialog().showAndWait()
                .ifPresent(transportadora::adicionaCarga);
    }

    public void salvar(ActionEvent actionEvent) {
        if (salvarFileChooser == null) {
            salvarFileChooser = new FileChooser();
            salvarFileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Json", "*.json"));
            salvarFileChooser.setTitle("Salvar...");
        }

        File file = salvarFileChooser.showSaveDialog(cargasTable.getScene().getWindow());
        if (file != null) {
            try (CargaJsonWriter writer = new CargaJsonWriter(file)) {
                writer.write(transportadora.getObservableList());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void carregar(ActionEvent actionEvent) {
        if (abrirFileChooser == null) {
            abrirFileChooser = new FileChooser();
            abrirFileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Json", "*.json"));
            abrirFileChooser.setTitle("Abrir...");
        }

        File file = abrirFileChooser.showOpenDialog(cargasTable.getScene().getWindow());
        if (file != null && file.exists()) {
            transportadora.removerTodasCargas();
            try (CargaJsonReader reader = new CargaJsonReader(file)) {
                reader.read().forEach(transportadora::adicionaCarga);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
