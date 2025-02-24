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
@Document(collection = "detalle_producto_compra_cliente")
public class DetalleProductoCompraCliente {

    @Id
    private String id;
    private int cantidad;
    private double subtotal;
    private double total;
    private String descripcion;
    private Entrada_Salida salida;
}
