package co.edu.uniquindio.zugarez.Model;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "entrada_salida")
public class Entrada_Salida {

    @Id
    private String id;
    private String descripcion;
    private String fecha;
    private String categoria;
    private DetalleProductoCompraCliente detalleProductoCompraCliente;
    private Producto producto;
    private String tipo; // "ENTRADA" o "SALIDA"
    private int cantidad;


}
