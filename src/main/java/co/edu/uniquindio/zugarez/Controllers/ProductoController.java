package co.edu.uniquindio.zugarez.Controllers;

import co.edu.uniquindio.zugarez.Model.Producto;
import co.edu.uniquindio.zugarez.Repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository repository;

    @GetMapping
    public List<Producto> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Producto create(@RequestBody Producto producto) {
        return repository.save(producto);
    }
}

