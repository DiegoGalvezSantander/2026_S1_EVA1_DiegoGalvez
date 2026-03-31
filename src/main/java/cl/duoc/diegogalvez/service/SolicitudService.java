package cl.duoc.diegogalvez.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import cl.duoc.diegogalvez.model.SolicitudMedica;
import cl.duoc.diegogalvez.repository.SolicitudRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SolicitudService {

    private final SolicitudRepository solicitudRepository;

    public List<SolicitudMedica> obtenerTodas() {

        return solicitudRepository.buscarTodas();
    }

    public Optional<SolicitudMedica> obtenerPorId(Long id) {
        return solicitudRepository.buscarPorId(id);
    
    }


    public SolicitudMedica crear(SolicitudMedica solicitud) {
        return solicitudRepository.guardar(solicitud);

    }

    public Optional<SolicitudMedica> actualizar(Long id, SolicitudMedica solicitud) {
        if (solicitudRepository.existePorId(id)) {
            solicitud.setId(id);
            return Optional.of(solicitudRepository.guardar(solicitud));
        }
        return Optional.empty();
    }

    public boolean eliminar(Long id) {
        if (solicitudRepository.existePorId(id)) {
            solicitudRepository.eliminarPorId(id);
            return true;
        }
        return false;
    }


    public List<SolicitudMedica> buscarPorPrioridad(String prioridad) {
        return solicitudRepository.buscarTodas().stream()
                .filter(s -> s.getPrioridad().equalsIgnoreCase(prioridad))
                .collect(Collectors.toList());
    }
}

