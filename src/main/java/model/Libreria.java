package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;


public class Libreria {
    private List<Libro> libros;
    private String nombre;
    
    public Libreria(String nom) {
        libros = new ArrayList<>();
        this.nombre = nom;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public boolean agregarLibro(Libro l) {
        libros.add(l);
        return true;
    }
    
    public List<String> obtenerLibros() {
        List<String> nomLibros = libros.stream()
                                .map(libro -> libro.getTitulo())
                                .collect(Collectors.toList());
        return nomLibros;
    }
    public List<Autor> obtenerAutoras(){
        return libros.stream().map(Libro -> Libro.getAutores()).flatMap(Autores -> Autores.stream())
                .filter(autor -> autor.getGenero() == Genero.MUJER)
                .distinct()
                .collect(Collectors.toList());
    }
    public List<String> obtenerSurname(){
        return libros.stream().map(Libro -> Libro.getAutores())
                .flatMap(Autores -> Autores.stream())
                .filter(Autor -> Autor.getEdad() >= 50)
                .map(Autor -> Autor.getNombre().toUpperCase())
                .distinct()
                .limit(15)
                .collect(Collectors.toList());
    }
    public int obtenerSumaEdades(){
        return libros.stream().map(Libro::getAutores)
                .flatMap(Autores -> Autores.stream())
                .filter(Autor -> Autor.getGenero() == Genero.MUJER)
                .distinct()
                .map(Autor::getEdad)
                .filter(Edad -> Edad < 25)
                .reduce(0, (Base, Edad) -> (Base + Edad))
                .intValue();
    }
    public Map<Genero, List<Autor>> obtenerAutoresAgrupados() {
        return libros.stream().map(Libro -> Libro.getAutores()).flatMap(Autores -> Autores.stream())
                .collect(groupingBy(Autor::getGenero));
    }
}
