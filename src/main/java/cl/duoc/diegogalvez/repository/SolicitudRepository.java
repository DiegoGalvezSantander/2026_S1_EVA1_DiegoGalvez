package cl.duoc.diegogalvez.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import cl.duoc.diegogalvez.model

@Repository
public class SolicitudRepository {
   
    private final Map<Long, SolicitudMedica> almacenamiento = new HashMap<>();

    public List<SolicitudMedica> buscarTodas() {
        return new ArrayList<>(almacenamiento.values());
    }

    public Optional<SolicitudMedica> buscarPorId(Long id) {
        return Optional.ofNullable(almacenamiento.get(id));
    }

    public SolicitudMedica guardar(SolicitudMedica solicitud) {
        almacenamiento.put(solicitud.getId(), solicitud);
        return solicitud;
    }

    public void eliminarPorId(Long id) {
        almacenamiento.remove(id);
    }

    public boolean existePorId(Long id) {
        return almacenamiento.containsKey(id);
    }
}

