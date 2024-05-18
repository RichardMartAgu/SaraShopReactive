package com.svalero.SaraShopReactive.controller;

import com.svalero.SaraShopReactive.model.Shop;
import com.svalero.SaraShopReactive.task.SaraShopTask;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class SaraTaskController implements Initializable {

    @FXML
    private TableView<Shop> shopTableView;
    @FXML
    private TableColumn<Shop, String> nameColumn;
    @FXML
    private TableColumn<Shop, String> addressColumn;
    @FXML
    private ProgressIndicator progressIndicator;
    private ObservableList<Shop> shops;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //inicializamos la visualización de la tableView, la listView y los label del filtrado.
        shopTableView.setVisible(true);

        // inicializamos la lista de equipos en la competición
        this.shops = FXCollections.observableArrayList();

        //añadimos la lista al tableView
        shopTableView.setItems(shops);

        //añadir valores a las columnas del tableView
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        addressColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress()));

    }

    //crea la tarea para recibir los equipos de una competición
    public void createProductTask() {


        // creamos la instancia de FootballTask con el código de competición, la lista de nombres y la barra de progreso
        SaraShopTask saraShopTask = new SaraShopTask(shops, progressIndicator);

        // Iniciar la tarea en un hilo separado
        new Thread(saraShopTask).start();
    }

}









