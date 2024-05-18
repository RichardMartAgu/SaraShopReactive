package com.svalero.SaraShopReactive.controller;

import com.svalero.SaraShopReactive.model.Product;
import com.svalero.SaraShopReactive.task.SaraProductTask;
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
    private TableView<Product> productTableView;
    @FXML
    private TableColumn<Product, String> nameColumn;
    @FXML
    private TableColumn<Product, String> descriptionColumn;
    @FXML
    private ProgressIndicator progressIndicator;
    private ObservableList<Product> products;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //inicializamos la visualización de la tableView, la listView y los label del filtrado.
        productTableView.setVisible(true);

        // inicializamos la lista de equipos en la competición
        this.products = FXCollections.observableArrayList();

        //añadimos la lista al tableView
        productTableView.setItems(products);

        //añadir valores a las columnas del tableView
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        descriptionColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescription()));

    }

    //crea la tarea para recibir los equipos de una competición
    public void createProductTask() {


        // creamos la instancia de FootballTask con el código de competición, la lista de nombres y la barra de progreso
        SaraProductTask saraProductTask = new SaraProductTask(products, progressIndicator);

        // Iniciar la tarea en un hilo separado
        new Thread(saraProductTask).start();
    }

}









