package co.edu.uniquindio.zugarez.Repositories;

import co.edu.uniquindio.zugarez.Model.DetalleProductoCompraCliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleProductoCompraClienteRepository extends MongoRepository<DetalleProductoCompraCliente,String> {
}
