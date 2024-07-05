package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.medico.DatosRegistroMedico;
import med.voll.api.model.medico.Medico;
import med.voll.api.model.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public Medico registrarMedico(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico) {
        return medicoRepository.save(new Medico(datosRegistroMedico));
    }
}
