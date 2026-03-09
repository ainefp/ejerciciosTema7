package com.example.ejercicio601.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ejercicio601.domain.Autor;
import com.example.ejercicio601.domain.Curso;
import com.example.ejercicio601.services.AutorService;
import com.example.ejercicio601.services.CursoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {

    @Autowired
    private final CursoService cursoService;

    @Autowired
    private final AutorService autorService;

    private String errMsg;

    // Método para asignar la lista de autores a la vista
    // Es decir, no necesito hacer un model.addAttribute("listaAutores", autorService.obtenerTodos())
    // Esta variable corresponde a la variable "listaAutores" que se utiliza en el select del formulario
    @ModelAttribute("listaAutores")
    public List<Autor> asignarListaAutores() {
        return autorService.obtenerTodos();
    }

    // Método para asignar la lista de cursos a la vista
    @ModelAttribute("listaCursos")
    public List<Curso> asignarListaCursos() {
        return cursoService.obtenerTodos();
    }

    @GetMapping({ "/", "/list" })
    public String showList(Model model) {
        if (errMsg != null) {
            model.addAttribute("msg", errMsg);
            errMsg = null;
        }
        model.addAttribute("findForm", new Curso());
        model.addAttribute("findTheme", new Curso());
        model.addAttribute("findPrice", new Curso());
        model.addAttribute("findAutor", new Autor());
        return "listView";
    }

    @GetMapping("/{id}")
    public String showElement(@PathVariable Long id, Model model) {
        try {
            Curso curso = cursoService.obtenerPorId(id);
            model.addAttribute("curso", curso);

        } catch (RuntimeException e) {
            errMsg = e.getMessage();
            return "redirect:/list";
        }

        return "listOneView";
    }

    @GetMapping("/nuevo")
    public String showNew(Model model) {
        try {
            model.addAttribute("curso", new Curso());
            return "newFormView";
        } catch (RuntimeException e) {
            errMsg = e.getMessage();
            return "redirect:/list";
        }
    }

    @GetMapping("/editar/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Curso curso = cursoService.obtenerPorId(id);
        model.addAttribute("curso", curso);
        return "editFormView";
    }

    @GetMapping("/borrar/{id}")
    public String getMethodName(@PathVariable Long id) {
        cursoService.borrar(id);
        errMsg = "Curso borrado correctamente";
        return "redirect:/list";
    }

    @PostMapping("/nuevo/submit")
    public String submitForm(@ModelAttribute Curso curso, @RequestParam(required = false) Long autorId, Model model) {
        if (autorId != null) {
            curso.setAutor(autorService.obtenerPorId(autorId));
        }
        try {
            cursoService.añadir(curso);
        } catch (RuntimeException e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "newFormView";
        }
        errMsg = "Curso añadido correctamente";
        return "redirect:/list";
    }

    @PostMapping("/editar/submit")
    public String submitEdit(@ModelAttribute Curso curso, @RequestParam(required = false) Long autorId, Model model) {
        if (autorId != null) {
            curso.setAutor(autorService.obtenerPorId(autorId));
        }
        try {
            cursoService.editar(curso);
        } catch (RuntimeException e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "editFormView";
        }
        errMsg = "Curso editado correctamente";
        return "redirect:/list";
    }

    @PostMapping("/findByName")
    public String findName(@ModelAttribute("findForm") Curso cursoM, Curso curso, Model model) {
        model.addAttribute("listaCursos", cursoService.buscarPorNombre(curso.getNombre()));
        model.addAttribute("findTheme", new Curso());
        model.addAttribute("findPrice", new Curso());
        model.addAttribute("findAutor", new Autor());
        return "listView";
    }

    @PostMapping("/findByTheme")
    public String findTheme(@ModelAttribute("findTheme") Curso cursoM, Curso curso, Model model) {
        model.addAttribute("listaCursos", cursoService.buscarPorTematica(curso.getTematica()));
        model.addAttribute("findForm", new Curso());
        model.addAttribute("findPrice", new Curso());
        model.addAttribute("findAutor", new Autor());
        return "listView";
    }

    @PostMapping("/findByAutor")
    public String findAutor(@ModelAttribute("findAutor") Autor autorM, Autor autor, Model model) {
        model.addAttribute("listaCursos", cursoService.buscarPorAutor(autor.getId()));
        model.addAttribute("findForm", new Curso());
        model.addAttribute("findTheme", new Curso());
        model.addAttribute("findPrice", new Curso());
        return "listView";
    }

    @PostMapping("/findByPrice")
    public String findPrice(@ModelAttribute("findPrice") Curso cursoM, Curso curso, Model model) {
        model.addAttribute("listaCursos", cursoService.buscarPorPrecioMenor(curso.getPrecio()));
        model.addAttribute("findForm", new Curso());
        model.addAttribute("findTheme", new Curso());
        model.addAttribute("findAutor", new Autor());
        return "listView";
    }

}
