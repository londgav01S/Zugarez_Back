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
@Document(collection = "zugarez")
public class Zugarez {

    @Id
    private String id;
    private ArrayList<Inventario> lstInnventario;
    private ArrayList<Producto> lstProducto;
}
