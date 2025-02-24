package co.edu.uniquindio.zugarez.Repositories;

import co.edu.uniquindio.zugarez.Model.Inventario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioRepository extends MongoRepository<Inventario,String> {
}
