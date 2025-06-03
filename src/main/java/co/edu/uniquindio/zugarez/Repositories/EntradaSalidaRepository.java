package co.edu.uniquindio.zugarez.Repositories;

import co.edu.uniquindio.zugarez.Model.Entrada_Salida;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntradaSalidaRepository extends MongoRepository<Entrada_Salida,String> {

    List<Entrada_Salida> findByTipo(String tipo);

    List<Entrada_Salida> findByProductoId(String productoId);

}
