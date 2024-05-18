package com.svalero.SaraShopReactive.task;

import com.svalero.SaraShopReactive.model.Shop;
import com.svalero.SaraShopReactive.service.SaraStoreService;
import io.reactivex.functions.Consumer;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.control.ProgressIndicator;

public class SaraShopTask extends Task<Integer> {

    private final ObservableList<Shop> shops;
    private final ProgressIndicator progressIndicator;

    public SaraShopTask(ObservableList<Shop> products, ProgressIndicator progressIndicator) {
        this.shops = products;
        this.progressIndicator = progressIndicator;
    }

    // Método que se ejecuta al iniciar la tarea
    @Override
    protected Integer call() {

        // Mostrar el indicador de progreso como indeterminado
        Platform.runLater(() -> progressIndicator.setVisible(true));
        Platform.runLater(() -> progressIndicator.setProgress(-1));

        // Crear una instancia del servicio de fútbol
        SaraStoreService saraStoreService = new SaraStoreService();

        // Definir un Consumer para manejar los equipos recibidos
        Consumer<Shop> user = (shop) -> {
            // Retardar la ejecución para simular una operación de red
            Thread.sleep(250);
            // Agregar el nombre del equipo a la lista
            Platform.runLater(() -> this.shops.add(shop));
        };

        // Suscribir el Consumer al servicio para recibir los equipos
        saraStoreService.getAllShops()
                .subscribe(user);

        // Ocultar el indicador de progreso al finalizar la tarea
        Platform.runLater(() -> {
            progressIndicator.setVisible(false);
            progressIndicator.setProgress(0);
        });


        return null;
    }

}
