package com.example.ejercicio601.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ejercicio601.domain.Autor;
import com.example.ejercicio601.services.AutorService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/autores")
@RequiredArgsConstructor
public class AutorController {

    private final AutorService autorService;
    private String txtMsg;

    @GetMapping({"", "/"})
    public String showList(Model model) {
        if (txtMsg != null) { 
            model.addAttribute("msg", txtMsg);
            txtMsg = null;
        }
        model.addAttribute("listaAutores", autorService.obtenerTodos());
        return "listAutorView";
    }

    @GetMapping("/{id}")
    public String showElement(@PathVariable Long id, Model model) {
        try {
            Autor autor = autorService.obtenerPorId(id);
            model.addAttribute("autor", autor);
        } catch (RuntimeException e) {
            txtMsg = e.getMessage();
            return "redirect:/autores";
        }
        return "listOneAutorView";
    }

    @GetMapping("/nuevo")
    public String showNew(Model model) {
        model.addAttribute("autor", new Autor());
        return "newAutorFormView";
    }

    @PostMapping("/nuevo/submit")
    public String submitForm(@ModelAttribute Autor autor) {
        autorService.añadir(autor);
        txtMsg = "Autor añadido correctamente";
        return "redirect:/autores";
    }

    @GetMapping("/editar/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Autor autor = autorService.obtenerPorId(id);
        model.addAttribute("autor", autor);
        return "editAutorFormView";
    }

    @PostMapping("/editar/submit")
    public String submitEdit(@ModelAttribute Autor autor) {
        autorService.editar(autor);
        txtMsg = "Autor editado correctamente";
        return "redirect:/autores";
    }

    @GetMapping("/borrar/{id}")
    public String borrar(@PathVariable Long id) {
        autorService.borrar(id);
        txtMsg = "Autor borrado correctamente";
        return "redirect:/autores";
    }
}
