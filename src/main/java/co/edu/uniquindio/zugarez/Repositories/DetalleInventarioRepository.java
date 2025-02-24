package co.edu.uniquindio.zugarez.Repositories;

import co.edu.uniquindio.zugarez.Model.DetalleInventario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleInventarioRepository extends MongoRepository<DetalleInventario,String> {
}
