package co.edu.uniquindio.zugarez.Controllers;

import co.edu.uniquindio.zugarez.Model.DetalleInventario;
import co.edu.uniquindio.zugarez.Model.Producto;
import co.edu.uniquindio.zugarez.Repositories.DetalleInventarioRepository;
import co.edu.uniquindio.zugarez.Repositories.ProductoRepository;
import co.edu.uniquindio.zugarez.Services.DetalleInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalleInventario")
@CrossOrigin(origins = "http://localhost:3000")
public class DetalleInventarioController {

    @Autowired
    private DetalleInventarioService detalleInventarioService;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private DetalleInventarioRepository detalleInventarioRepository;

    @GetMapping
    public ResponseEntity<List<DetalleInventario>> getAll() {
        return ResponseEntity.ok(detalleInventarioService.getAll());
    }

    @PostMapping("/{productoId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public DetalleInventario create(String productoId, DetalleInventario detalle) {
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        detalle.setProducto(producto);
        return detalleInventarioRepository.save(detalle);
    }


    @PutMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<DetalleInventario> update(@PathVariable String id, @RequestBody DetalleInventario detalle) {
        DetalleInventario updated = detalleInventarioService.update(id, detalle);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        boolean deleted = detalleInventarioService.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}

