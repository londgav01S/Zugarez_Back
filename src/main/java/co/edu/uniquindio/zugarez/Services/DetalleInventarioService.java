package co.edu.uniquindio.zugarez.Services;

import co.edu.uniquindio.zugarez.Model.DetalleInventario;
import co.edu.uniquindio.zugarez.Model.Producto;
import co.edu.uniquindio.zugarez.Repositories.DetalleInventarioRepository;
import co.edu.uniquindio.zugarez.Repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DetalleInventarioService {

    @Autowired
    private DetalleInventarioRepository detalleInventarioRepository;

    @Autowired
    private ProductoRepository productoRepository;

    public List<DetalleInventario> getAll() {
        List<DetalleInventario> detalles = detalleInventarioRepository.findAll();

        for (DetalleInventario detalle : detalles) {
            detalle.setProducto(productoRepository.findById(detalle.getProducto().getId()).orElse(null));
        }

        return detalles;
    }


    public DetalleInventario create(String productoId, DetalleInventario detalle) {
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        detalle.setProducto(producto);
        return detalleInventarioRepository.save(detalle);
    }

    public DetalleInventario update(String id, DetalleInventario detalle) {
        Optional<DetalleInventario> existingDetalle = detalleInventarioRepository.findById(id);
        if (existingDetalle.isPresent()) {
            detalle.setId(id);
            return detalleInventarioRepository.save(detalle);
        }
        return null;
    }

    public boolean delete(String id) {
        if (detalleInventarioRepository.existsById(id)) {
            detalleInventarioRepository.deleteById(id);
            return true;
        }
        return false;
    }



}
