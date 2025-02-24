package co.edu.uniquindio.zugarez.Repositories;

import co.edu.uniquindio.zugarez.Model.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends MongoRepository<Producto,String> {
}
