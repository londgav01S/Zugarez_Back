package co.edu.uniquindio.zugarez.Repositories;

import co.edu.uniquindio.zugarez.Model.DetalleInventario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleInventarioRepository extends MongoRepository<DetalleInventario,String> {
    // ✅ Consulta para encontrar productos con bajo stock
    List<DetalleInventario> findByDisponiblesLessThan(int threshold);
}
