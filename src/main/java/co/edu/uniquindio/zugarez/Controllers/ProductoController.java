package co.edu.uniquindio.zugarez.Controllers;

import co.edu.uniquindio.zugarez.Model.Producto;
import co.edu.uniquindio.zugarez.Repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductoController {

    @Autowired
    private ProductoRepository repository;

    @GetMapping("/obtenerProductos")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Producto> getAll() {
        return repository.findAll();
    }

    @PostMapping("/crearProducto")
    @CrossOrigin(origins = "http://localhost:3000")
    public Producto create(@RequestBody Producto producto) {
        return repository.save(producto);
    }
    @PutMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Producto updateProduct(@PathVariable String id, @RequestBody Producto updatedProduct) {
        Optional<Producto> existingProduct = repository.findById(id);
        if (existingProduct.isPresent()) {
            Producto producto = existingProduct.get();
            producto.setNombre(updatedProduct.getNombre());
            producto.setPrecio(updatedProduct.getPrecio());
            producto.setCantidad(updatedProduct.getCantidad());
            producto.setMarca(updatedProduct.getMarca());
            producto.setFechaVencimiento(updatedProduct.getFechaVencimiento());
            producto.setEstado(updatedProduct.getEstado());
            return repository.save(producto);
        }
        throw new RuntimeException("Producto no encontrado");
    }
    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public void deleteProduct(@PathVariable String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Producto no encontrado");
        }
    }

    @GetMapping("/caducados")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Producto> getProductosCaducados(
            @RequestParam String desde,
            @RequestParam String hasta) {
        return repository.findByEstadoAndFechaVencimientoBetween("caducado", desde, hasta);
    }

    @GetMapping("/por-vencer")
    public ResponseEntity<List<Producto>> listarProductosPorVencer() {
        LocalDate hoy = LocalDate.now();
        LocalDate limite = hoy.plusDays(10);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String desde = hoy.format(formatter);
        String hasta = limite.format(formatter);

        List<Producto> productos = repository.findProductosPorVencerEntre(desde, hasta);
        return ResponseEntity.ok(productos);
    }

}

