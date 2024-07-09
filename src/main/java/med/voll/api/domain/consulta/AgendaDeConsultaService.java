package med.voll.api.domain.consulta;

import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.infra.errors.ValicacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgendaDeConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    public void agendar(DatosAgendarConsulta datosAgendarConsulta) {

        // validaciones
        if (pacienteRepository.findById(datosAgendarConsulta.idPaciente()).isEmpty()) {
            throw new ValicacionDeIntegridad("este id para el paciente no fue encontrado");
        }

        if (datosAgendarConsulta.idMedico() != null && medicoRepository.existsById(datosAgendarConsulta.idMedico())) {
            throw new ValicacionDeIntegridad("este id para el medico no fue encontrado");
        }
        // relaciones
        Paciente paciente = pacienteRepository.findById(datosAgendarConsulta.idPaciente()).get();
        Medico medico = seleccionarMedico(datosAgendarConsulta);
        // nueva instancia
        Consulta consulta = new Consulta(null, medico, paciente, datosAgendarConsulta.fecha());
        consultaRepository.save(consulta);
    }

    private Medico seleccionarMedico(DatosAgendarConsulta datosAgendarConsulta) {
        if (datosAgendarConsulta.idMedico() != null) {
            return medicoRepository.getReferenceById(datosAgendarConsulta.idMedico());
        }
        if (datosAgendarConsulta.especialidad() == null) {
            throw new ValicacionDeIntegridad("Debe seleccionarse una especialidad para el medico");
        }
        return medicoRepository.seleccionarMedicoConEspecialidadEnFecha(datosAgendarConsulta.especialidad(), datosAgendarConsulta.fecha());
    }
}
