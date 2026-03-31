package cl.duoc.diegogalvez.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.duoc.diegogalvez.model.SolicitudMedica;
import cl.duoc.diegogalvez.service.SolicitudService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/solicitudes")
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;
    @GetMapping
    public ResponseEntity<List<SolicitudMedica>> listarTodas() {
        return ResponseEntity.ok(solicitudService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        return solicitudService.obtenerPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SolicitudMedica> registrar(@Valid @RequestBody SolicitudMedica solicitud) {
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitudService.crear(solicitud));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@PathVariable Long id, @Valid @RequestBody SolicitudMedica solicitud) {
        return solicitudService.actualizar(id, solicitud)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        return solicitudService.eliminar(id)
             ? ResponseEntity.noContent().build()
             : ResponseEntity.notFound().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<SolicitudMedica>> filtrarPorPrioridad(@RequestParam String prioridad) {
        return ResponseEntity.ok(solicitudService.buscarPorPrioridad(prioridad));
    }
}

