package co.edu.uniquindio.zugarez.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;


// Esta clase representa un inventario en el sistema.

@Data
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "inventario")
public class Inventario {

    @Id
    private String id;
    private String fechaActualizacion;
    private String fechaVerificacion;
    private String estado;
    private String descripcion;
    private ArrayList<Entrada_Salida> lstEntrada;
    private ArrayList<Entrada_Salida> lstSalida;
    private ArrayList<DetalleInventario> lstDetalleInventario;
}
