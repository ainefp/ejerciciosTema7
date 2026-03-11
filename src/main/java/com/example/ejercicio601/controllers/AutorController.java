package com.example.ejercicio601.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ejercicio601.domain.Autor;
import com.example.ejercicio601.services.Autor.AutorService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/autores")
@RequiredArgsConstructor
public class AutorController {

    private final AutorService autorService;
    private String errMsg;

    @GetMapping({"", "/"})
    public String showList(Model model) {
        if (errMsg != null) { 
            model.addAttribute("msg", errMsg);
            errMsg = null;
        }
        model.addAttribute("listaAutores", autorService.obtenerTodos());
        return "Autor/listAutorView";
    }

    @GetMapping("/{id}")
    public String showElement(@PathVariable Long id, Model model) {
        Autor autor = autorService.obtenerPorId(id);
        model.addAttribute("autor", autor);
        return "Autor/listOneAutorView";
    }

    @GetMapping("/nuevo")
    public String showNew(Model model) {
        model.addAttribute("autor", new Autor());
        return "Autor/newAutorFormView";
    }

    @GetMapping("/editar/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Autor autor = autorService.obtenerPorId(id);
        model.addAttribute("autor", autor);
        return "Autor/editAutorFormView";
    }

    @GetMapping("/borrar/{id}")
    public String borrar(@PathVariable Long id) {
        autorService.borrar(id);
        errMsg = "Autor eliminado correctamente";
        return "redirect:/autores";
    }

    @PostMapping("/nuevo/submit")
    public String submitForm(@ModelAttribute Autor autor) {
        autorService.añadir(autor);
        errMsg = "Autor añadido correctamente";
        return "redirect:/autores";
    }

    @PostMapping("/editar/submit")
    public String submitEdit(@ModelAttribute Autor autor) {
        autorService.editar(autor);
        errMsg = "Autor editado correctamente";
        return "redirect:/autores";
    }
}
