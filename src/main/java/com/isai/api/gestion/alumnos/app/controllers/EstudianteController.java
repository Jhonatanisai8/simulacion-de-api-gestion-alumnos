package com.isai.api.gestion.alumnos.app.controllers;

import com.isai.api.gestion.alumnos.app.domain.Estudiante;
import com.isai.api.gestion.alumnos.app.domain.Utils;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/estudiantes")
@RestController
public class EstudianteController {

    private final Utils repo = new Utils();

    @GetMapping
    public List<Estudiante> getEstudiantes() {
        return this.repo.getListaEstudiantes();
    }

    @GetMapping("/{email}")
    public Estudiante getCliente(@PathVariable String email) {
        return this.repo.getListaEstudiantes()
                .stream()
                .filter((t) -> t.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Estudiante postEstudiante(@RequestBody Estudiante estudiante) {
        this.repo.getListaEstudiantes().add(estudiante);
        return estudiante;
    }

    @PutMapping
    public Estudiante putEstudiante(@RequestBody Estudiante estudiante) {
        return this.repo.getListaEstudiantes()
                .stream()
                .filter((t) -> t.getIdEstudiante() == estudiante.getIdEstudiante())
                .findFirst()
                .map((t) -> {
                    t.setNombre(estudiante.getNombre());
                    t.setEdad(estudiante.getEdad());
                    t.setEmail(estudiante.getEmail());
                    t.setCurso(estudiante.getCurso());
                    return t;
                }).orElse(null);
    }

    @DeleteMapping("/{idEstudiante}")
    public Estudiante deleteEstudiante(@PathVariable int idEstudiante) {
        return this.repo.getListaEstudiantes()
                .stream()
                .filter((t) -> t.getIdEstudiante() == idEstudiante)
                .findFirst()
                .map(t -> {
                    this.repo.getListaEstudiantes().remove(t);
                    return t;
                }
                ).orElse(null);
    }

    @PatchMapping
    public Estudiante patchEstudiante(@RequestBody Estudiante estudiante) {
        return this.repo.getListaEstudiantes()
                .stream()
                .filter((t) -> t.getIdEstudiante() == estudiante.getIdEstudiante())
                .findFirst()
                .map((t) -> {
                    if (estudiante.getNombre() != null) {
                        t.setNombre(estudiante.getNombre());
                    }
                    if (estudiante.getEdad() != 0) {
                        t.setEdad(estudiante.getEdad());
                    }
                    if (estudiante.getCurso() != null) {
                        t.setCurso(estudiante.getCurso());
                    }
                    if (estudiante.getEmail() != null) {
                        t.setEmail(estudiante.getEmail());
                    }
                    return t;
                })
                .orElse(null);
    }

}
