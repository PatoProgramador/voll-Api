package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.medico.DatosListadoMedico;
import med.voll.api.model.medico.DatosRegistroMedico;
import med.voll.api.model.medico.Medico;
import med.voll.api.model.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping
    public Page<DatosListadoMedico> listadoMedicos(@PageableDefault(size = 2) Pageable pagination) {
        return medicoRepository.findAll(pagination).map(DatosListadoMedico::new);
    }

    @PostMapping
    public Medico registrarMedico(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico) {
        return medicoRepository.save(new Medico(datosRegistroMedico));
    }
}
