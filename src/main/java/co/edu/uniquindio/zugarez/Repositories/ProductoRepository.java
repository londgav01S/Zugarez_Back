package co.edu.uniquindio.zugarez.Repositories;

import co.edu.uniquindio.zugarez.Model.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends MongoRepository<Producto,String> {

    List<Producto> findByEstadoAndFechaVencimientoBetween(String estado, String desde, String hasta);

    @Query("{ 'estado': { $ne: 'caducado' }, 'fechaVencimiento': { $gte: ?0, $lte: ?1 } }")
    List<Producto> findProductosPorVencerEntre(String desde, String hasta);




}
