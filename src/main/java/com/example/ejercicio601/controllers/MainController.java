package com.example.ejercicio601.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ejercicio601.domain.Curso;
import com.example.ejercicio601.services.CursoService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class MainController {

    private final CursoService cursoService;
    private String txtMsg;

    @GetMapping({"/", "/list"})
    public String showList(Model model) {
        if (txtMsg != null) {
            model.addAttribute("msg", txtMsg);
            txtMsg = null;
        }
        /*if (err != null){
            model.addAttribute("msg", txtMsg);
        }*/
        model.addAttribute("listaCursos", cursoService.obtenerTodos());
        model.addAttribute("findForm", new Curso());
        model.addAttribute("findTheme", new Curso());
        model.addAttribute("findPrice", new Curso());
        return "listView";
    }

    @GetMapping("/{id}")
    public String showElement(@PathVariable Long id, Model model) {
        try {
            Curso curso = cursoService.obtenerPorId(id);
            model.addAttribute("curso", curso);
            
        } catch(RuntimeException e) {
            txtMsg = e.getMessage();
            return "redirect:/list";
        }

        return "listOneView";
    }

    @GetMapping("/nuevo")
    public String showNew(Model model) {
        try {
            model.addAttribute("curso", new Curso());
            return "newFormView";
        } catch(RuntimeException e) {
            txtMsg = e.getMessage();
            return "redirect:/list";

        }

    }

    @GetMapping("/editar/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Curso curso = cursoService.obtenerPorId(id);
        model.addAttribute("curso",curso);
        return "editFormView";
    }

    @GetMapping("/borrar/{id}")
    public String getMethodName(@PathVariable Long id) {
        cursoService.borrar(id);
        txtMsg = "Curso borrado correctamente";
        return "redirect:/list";
    }

    @PostMapping("/nuevo/submit")
    public String submitForm(@ModelAttribute Curso curso) {
        cursoService.añadir(curso);
        txtMsg = "Curso añadido correctamente";
        return "redirect:/list";
        
    }
    
    @PostMapping("/editar/submit")
    public String submitEdit(@ModelAttribute Curso curso) {
        cursoService.editar(curso);
        txtMsg = "Curso editado correctamente";
        return "redirect:/list";
    }

    @PostMapping("/findByName")
    public String findName(Curso curso, Model model) {
        model.addAttribute("listaCursos", cursoService.buscarPorNombre(curso.getNombre()));
        model.addAttribute("findForm", curso);
        model.addAttribute("findTheme", new Curso());
        model.addAttribute("findPrice", new Curso());
        return "listView";
    }

    @PostMapping("/findByPrice")
    public String findPrice(Curso curso, Model model) {
        model.addAttribute("listaCursos", cursoService.buscarPorPrecioMenor(curso.getPrecio()));
        model.addAttribute("findPrice", curso);
        model.addAttribute("findForm", new Curso());
        model.addAttribute("findTheme", new Curso());
        return "listView";
    }
    
    @PostMapping("/findByTheme")
    public String findTheme(Curso curso, Model model) {
        model.addAttribute("listaCursos", cursoService.buscarPorTematica(curso.getTematica()));
        model.addAttribute("findTheme", curso);
        model.addAttribute("findForm", new Curso());
        model.addAttribute("findPrice", new Curso());
        return "listView";
    }
    
    

}
