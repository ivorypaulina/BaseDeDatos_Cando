package com.example.cando_basededatos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductoController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtStock;

    @FXML
    private Label lblMensaje;

    @FXML
    private TableView<Producto> tablaProductos;

    @FXML
    private TableColumn<Producto, Integer> colId;

    @FXML
    private TableColumn<Producto, String> colNombre;

    @FXML
    private TableColumn<Producto, Double> colPrecio;

    @FXML
    private TableColumn<Producto, Integer> colStock;

    private final ObservableList<Producto> lista =
            FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        colId.setCellValueFactory(
                new PropertyValueFactory<>("id"));

        colNombre.setCellValueFactory(
                new PropertyValueFactory<>("nombre"));

        colPrecio.setCellValueFactory(
                new PropertyValueFactory<>("precio"));

        colStock.setCellValueFactory(
                new PropertyValueFactory<>("stock"));
    }

    @FXML
    private void guardar() {

        try {

            Connection con =
                    Conexion.getConexion();

            String sql =
                    "INSERT INTO productos(nombre,precio,stock) VALUES(?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, txtNombre.getText());
            ps.setDouble(2,
                    Double.parseDouble(txtPrecio.getText()));
            ps.setInt(3,
                    Integer.parseInt(txtStock.getText()));

            ps.executeUpdate();

            lblMensaje.setText("Producto guardado");

            con.close();

        } catch (Exception e) {

            lblMensaje.setText("Error");
            e.printStackTrace();
        }
    }

    @FXML
    private void mostrar() {

        lista.clear();

        try {

            Connection con =
                    Conexion.getConexion();

            PreparedStatement ps =
                    con.prepareStatement(
                            "SELECT * FROM productos");

            ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                lista.add(
                        new Producto(
                                rs.getInt("id"),
                                rs.getString("nombre"),
                                rs.getDouble("precio"),
                                rs.getInt("stock")
                        )
                );
            }

            tablaProductos.setItems(lista);

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}