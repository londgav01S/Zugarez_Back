package co.edu.uniquindio.zugarez.Services;

import co.edu.uniquindio.zugarez.Model.DetalleInventario;
import co.edu.uniquindio.zugarez.Repositories.DetalleInventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventarioService {

    @Autowired
    private DetalleInventarioRepository detalleInventarioRepository;

    // ✅ Método para obtener productos con bajo stock
    public List<DetalleInventario> getLowStockProducts() {
        return detalleInventarioRepository.findByDisponiblesLessThan(5);  // 🔹 Condición de bajo stock
    }

}

