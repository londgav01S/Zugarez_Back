package co.edu.uniquindio.zugarez.Model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "producto")
public class Producto {

    @Id
    private String id;
    private String nombre;
    private Double precio;
    private int cantidad;
    private String marca;
    private String fechaVencimiento;
    private String estado;
    private DetalleInventario detalleInventario;
    private ArrayList<Entrada_Salida> ltsEntrada;
    private ArrayList<Entrada_Salida> ltsSalida;
}
