package co.edu.uniquindio.zugarez.Controllers;


import co.edu.uniquindio.zugarez.Model.DetalleInventario;
import co.edu.uniquindio.zugarez.Model.Inventario;
import co.edu.uniquindio.zugarez.Repositories.InventarioRepository;
import co.edu.uniquindio.zugarez.Repositories.ProductoRepository;
import co.edu.uniquindio.zugarez.Services.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
