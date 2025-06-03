package co.edu.uniquindio.zugarez.Controllers;

import co.edu.uniquindio.zugarez.Model.Entrada_Salida;
import co.edu.uniquindio.zugarez.Model.Producto;
import co.edu.uniquindio.zugarez.Repositories.EntradaSalidaRepository;
import co.edu.uniquindio.zugarez.Repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/entrada-salida")
@CrossOrigin(origins = "http://localhost:3000")
public class EntradaSalidaController {

    @Autowired
    private EntradaSalidaRepository entradaSalidaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @PostMapping("/desecho")
    public ResponseEntity<Entrada_Salida> registrarDesecho(@RequestBody Entrada_Salida salida) {
        salida.setTipo("SALIDA");  // siempre será una salida
        return ResponseEntity.ok(entradaSalidaRepository.save(salida));
    }

    @PostMapping("/plan-abastecimiento")
    public ResponseEntity<Entrada_Salida> registrarPlan(@RequestBody Entrada_Salida plan) {
        plan.setTipo("PLAN"); // Se marca como plan de abastecimiento
        return ResponseEntity.ok(entradaSalidaRepository.save(plan));
    }


    @GetMapping("/historial-pedidos")
    public ResponseEntity<List<Entrada_Salida>> obtenerHistorialPedidos() {
        List<Entrada_Salida> pedidos = entradaSalidaRepository.findByTipo("PEDIDO");
        return ResponseEntity.ok(pedidos);
    }

    @PostMapping("/pedido")
    public ResponseEntity<?> registrarPedidoProveedor(@RequestBody Entrada_Salida pedido) {
        Optional<Producto> productoOpt = productoRepository.findById(pedido.getId());

        if (productoOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Producto no encontrado");
        }

        Producto producto = productoOpt.get();
        if (pedido.getProducto().getMinimoPedido() < producto.getMinimoPedido()) {
            return ResponseEntity.badRequest().body("La cantidad es menor al mínimo permitido para este producto (" + producto.getMinimoPedido() + ")");
        }

        pedido.setTipo("PEDIDO");
        return ResponseEntity.ok(entradaSalidaRepository.save(pedido));
    }

    @PostMapping("/pedido-recibido")
    public ResponseEntity<Entrada_Salida> registrarRecepcionPedido(@RequestBody Entrada_Salida entrada) {
        entrada.setTipo("PEDIDO_RECIBIDO"); // se registra como recepción
        return ResponseEntity.ok(entradaSalidaRepository.save(entrada));
    }

    @GetMapping("/resumen/{productoId}")
    public ResponseEntity<Map<String, Object>> resumenEntradasSalidas(@PathVariable String productoId) {
        List<Entrada_Salida> registros = entradaSalidaRepository.findByProductoId(productoId);

        int totalEntradas = registros.stream()
                .filter(e -> e.getTipo().equalsIgnoreCase("ENTRADA"))
                .mapToInt(Entrada_Salida::getCantidad)
                .sum();

        int totalSalidas = registros.stream()
                .filter(e -> e.getTipo().equalsIgnoreCase("SALIDA"))
                .mapToInt(Entrada_Salida::getCantidad)
                .sum();

        Map<String, Object> resumen = new HashMap<>();
        resumen.put("productoId", productoId);
        resumen.put("totalEntradas", totalEntradas);
        resumen.put("totalSalidas", totalSalidas);
        resumen.put("movimientos", registros); // lista completa

        return ResponseEntity.ok(resumen);
    }





}