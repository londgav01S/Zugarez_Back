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
@Document(collection = "detalle_inventario")
public class DetalleInventario {

    @Id
    private String id;
    private int caducados;
    private int disponibles;
    private int vendidos;
    private int perdidos;
    private String estado;
    private ArrayList<Producto> ltsProducto;

}
