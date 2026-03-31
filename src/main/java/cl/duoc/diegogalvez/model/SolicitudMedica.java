package cl.duoc.diegogalvez.model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudMedica {
    @NotNull(message = "No puede ser nulo el id")
    private Long id;

    @NotBlank(message = "El nombre del paciente es obligatorio")
    private String nombrePaciente;

    @NotBlank(message = "La especialidad es obligatoria")
    private String especialidad;

    @NotBlank(message = "El estado es obligatorio (Estado solicitud)")
    private String estado;

    @NotNull(message = "La fecha del registro es obligatoria")
    private LocalDate fechaRegistro;

    @NotBlank(message = "La prioridad de atencion es obligatoria")
    private String prioridad;
}
