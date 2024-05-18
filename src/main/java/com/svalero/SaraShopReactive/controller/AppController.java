package com.svalero.SaraShopReactive.controller;

import com.svalero.SaraShopReactive.utils.ShowAlert;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {

    @FXML
    private Button listShops;
    @FXML
    private TabPane tabSaraStore;
    @FXML
    private ChoiceBox<Integer> maxTabsChoiceBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Integer> choices = FXCollections.observableArrayList(1, 2, 3, 4, 5);
        maxTabsChoiceBox.setItems(choices);
        maxTabsChoiceBox.setValue(5);

    }

    // generamos un nuevo hilo
    @FXML
    public void listShops(ActionEvent event) throws IOException {

        // recogemos el valor del máximo de tabs
        int maxTabs = maxTabsChoiceBox.getValue();

        //miramos si es posible crear una tab más o excede el máximo
        if (tabSaraStore.getTabs().size() < maxTabs) {

            //creamos la instancia del nuevo fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com.svalero.SaraShopReactive/sara_pane.fxml"));


            //creamos la nueva pestaña
            AnchorPane anchorPane = loader.load(); //cuidado
            tabSaraStore.getTabs().add(new Tab("Shops", anchorPane));

            // Obtenemos el controlador del FXML cargado
            SaraTaskController saraTaskController = loader.getController();

            // Enviamos el código de la competición al controlador
            saraTaskController.createProductTask();

        } else {
            ShowAlert.showInformationAlert("Information", "DEMASIADAS PESTAÑAS", "máximo de pestañas alcanzado");
        }
    }

}