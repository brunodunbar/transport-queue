package com.brunodunbar.transportqueue;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class CargaDialog extends Dialog<Carga> {

    public CargaDialog() {

        ButtonType okButtonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        getDialogPane().getButtonTypes().addAll(okButtonType, ButtonType.CANCEL);

        setTitle("Adicionando carga");

        setHeaderText("Informe os dados da carga");
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        //Descrição
        grid.add(new Label("Código:"), 0, 0);
        TextField codigoField = new TextField();
        grid.add(codigoField, 1, 0);

        //Direção
        grid.add(new Label("Destinatário:"), 0, 1);
        TextField destinatarioField = new TextField();
        grid.add(destinatarioField, 1, 1);

        //Velociada
        grid.add(new Label("Endereço:"), 0, 2);
        TextField enderecoField = new TextField();
        grid.add(enderecoField, 1, 2);

        //Coordenada
        grid.add(new Label("Prioridade:"), 0, 4);
        TextField prioridadeField = new TextField();
        grid.add(prioridadeField, 1, 4);

        getDialogPane().setContent(grid);
        Platform.runLater(codigoField::requestFocus);

        setResultConverter(dialogButton -> {
            if (dialogButton == okButtonType) {
                return new Carga(codigoField.getText(), destinatarioField.getText(), enderecoField.getText(),
                        Integer.valueOf(prioridadeField.getText()));
            }
            return null;
        });
    }
}