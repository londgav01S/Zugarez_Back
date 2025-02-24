package co.edu.uniquindio.zugarez.Controllers;


import co.edu.uniquindio.zugarez.Model.Inventario;
import co.edu.uniquindio.zugarez.Repositories.InventarioRepository;
import co.edu.uniquindio.zugarez.Repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private InventarioRepository repository;

    @GetMapping
    public List<Inventario> getAll() {
        return repository.findAll();
    }
}
