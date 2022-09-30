package com.mycompany.plf_libreria;

import java.util.ArrayList;
import java.util.List;
import model.Autor;
import model.Genero;
import model.Libreria;
import model.Libro;

public class PLF_Libreria {

    public static void main(String[] args) {
        Libreria  libreria = new Libreria("Ocho Libros");
        
        ArrayList<Autor> autor = new ArrayList<>();
        autor.add(new Autor("Craig Larman",14, Genero.HOMBRE));
        Libro libro = new Libro("UML y Patrones", autor, "7ma","1234567890");
        libreria.agregarLibro(libro);
        
        autor = new ArrayList<>();
        autor.add(new Autor("Jane Austen",16, Genero.MUJER));
        libro = new Libro("Orgullo y Prejuicio", autor, "7ma","1234567890");
        libreria.agregarLibro(libro);
        autor = new ArrayList<>();
        autor.add(new Autor("Mery Yein",16, Genero.MUJER));
        libro = new Libro("Orgullo y Prejuicio", autor, "7ma","1234567890");
        libreria.agregarLibro(libro);
        
        //Obtener todos los nombres de todos los libros
        List<String> libros = libreria.obtenerLibros();
        System.out.println("Titulos disponibles: " + libros);
        //Obtener suma de edades
        int sumaEdades = libreria.obtenerSumaEdades();
        System.out.println("Suma edades: " +sumaEdades);
        System.out.println("Autores Agrupados: " + libreria.obtenerAutoresAgrupados());
    }
}
