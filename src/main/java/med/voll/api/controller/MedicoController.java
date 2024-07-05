package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.medico.DatosListadoMedico;
import med.voll.api.model.medico.DatosRegistroMedico;
import med.voll.api.model.medico.Medico;
import med.voll.api.model.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping
    public List<DatosListadoMedico> listadoMedicos() {
        return medicoRepository.findAll().stream()
                .map(DatosListadoMedico::new)
                .collect(Collectors.toList());
    }

    @PostMapping
    public Medico registrarMedico(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico) {
        return medicoRepository.save(new Medico(datosRegistroMedico));
    }
}
