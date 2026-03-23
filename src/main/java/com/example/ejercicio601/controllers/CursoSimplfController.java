package com.example.ejercicio601.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ejercicio601.services.CursoSimplificado.CursoSimplfService;
import lombok.RequiredArgsConstructor;

@RequestMapping("/cursoSimplificado")
@RequiredArgsConstructor
@Controller
public class CursoSimplfController {
    
    private final CursoSimplfService cursoSimplfService;

    @GetMapping({"", "/"})
    public String showList(Model model, @RequestParam(required = false) String errorMsg) {
        if (errorMsg != null && !errorMsg.isBlank()) {
            model.addAttribute("errorMsg", errorMsg);
        }
        model.addAttribute("listaCursos", cursoSimplfService.obtenerTodos());
        return "CursoSimplificado/listCursoSimplfView";
    }

    @PostMapping("pagIni")
    public String showPagIni(Model model) {
        
        return "CursoSimplificado/listCursoSimplfView";
    }
}