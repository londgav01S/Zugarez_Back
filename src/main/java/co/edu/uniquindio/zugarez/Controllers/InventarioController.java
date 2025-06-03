package co.edu.uniquindio.zugarez.Controllers;


import co.edu.uniquindio.zugarez.Model.DetalleInventario;
import co.edu.uniquindio.zugarez.Model.Inventario;
import co.edu.uniquindio.zugarez.Repositories.InventarioRepository;
import co.edu.uniquindio.zugarez.Repositories.ProductoRepository;
import co.edu.uniquindio.zugarez.Services.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/inventario")
@CrossOrigin(origins = "http://localhost:3000")
public class InventarioController {

    @Autowired
    private InventarioRepository repository;

    @Autowired
    private InventarioService inventarioService;

    @GetMapping
    public List<Inventario> getAll() {
        return repository.findAll();
    }

    @GetMapping("/low-stock")
    public ResponseEntity<List<DetalleInventario>> getLowStockProducts() {
        List<DetalleInventario> lowStockProducts = inventarioService.getLowStockProducts();
        return ResponseEntity.ok(lowStockProducts);
    }

    @PutMapping("/verificar/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Inventario> registrarFechaVerificacion(@PathVariable String id, @RequestBody Map<String, String> body) {
        Optional<Inventario> inventarioOptional = repository.findById(id);

        if (inventarioOptional.isPresent()) {
            Inventario inventario = inventarioOptional.get();
            inventario.setFechaVerificacion(body.get("fechaVerificacion"));
            return ResponseEntity.ok(repository.save(inventario));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/crear")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Inventario> crearInventario(@RequestBody Inventario inventario) {
        if (inventario.getFechaActualizacion() == null) {
            inventario.setFechaActualizacion(""); // valor por defecto si no se pasa
        }
        if (inventario.getFechaVerificacion() == null) {
            inventario.setFechaVerificacion("");
        }
        if (inventario.getEstado() == null) {
            inventario.setEstado("Activo");
        }
        if (inventario.getDescripcion() == null) {
            inventario.setDescripcion("Nuevo inventario creado desde Postman");
        }
        if (inventario.getLstEntrada() == null) {
            inventario.setLstEntrada(new ArrayList<>());
        }
        if (inventario.getLstSalida() == null) {
            inventario.setLstSalida(new ArrayList<>());
        }
        if (inventario.getLstDetalleInventario() == null) {
            inventario.setLstDetalleInventario(new ArrayList<>());
        }

        Inventario nuevo = repository.save(inventario);
        return ResponseEntity.status(201).body(nuevo);
    }



}
