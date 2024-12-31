package com.isai.api.gestion.alumnos.app.domain;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    private final List<Estudiante> listaEstudiantes;

    public Utils() {
        this.listaEstudiantes = new ArrayList<>();
        this.listaEstudiantes.add(new Estudiante(123, "Juan Perez", "juan@gmail.com.pe", 18, "Programacion 1"));
        this.listaEstudiantes.add(new Estudiante(124, "Pedro Suarez", "pedro@gmail.com.pe", 16, "Diseño de base de datos"));
        this.listaEstudiantes.add(new Estudiante(125, "Fabian Castillo", "fabian@gmail.com.pe", 15, "Analisis de sistemas"));
        this.listaEstudiantes.add(new Estudiante(126, "Daniel Ojeda", "dani@gmail.com.pe", 19, "Investigacion Cientifica"));
        this.listaEstudiantes.add(new Estudiante(127, "Walter Rios", "walter@gmail.com.pe", 12, "Estructuras de datos"));
    }

    public List<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

}
