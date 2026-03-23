package com.example.ejercicio601.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    private CursoSimplfService cursoSimplfService;

    @GetMapping({"", "/"})
    public String showList(@RequestParam(required = false) String errorMsg, @RequestParam(required = false) Integer numPag, Model model) {
        
        int pagFin = cursoSimplfService.getTotalPaginas() - 1;
        if (numPag == null || numPag < 0 || numPag > pagFin) numPag = 0;
        Integer pagSig = pagFin > numPag ? numPag + 1 : pagFin;
        Integer pagAnt = numPag > 0 ? numPag - 1 : 0;
        
        if (errorMsg != null && !errorMsg.isBlank()) {
            model.addAttribute("errorMsg", errorMsg);
        }

        model.addAttribute("listaCursos", cursoSimplfService.getCursosPaginados(numPag));
        model.addAttribute("pagAnt", pagAnt);
        model.addAttribute("pagSig", pagSig);
        model.addAttribute("pagFin", pagFin);

        return "CursoSimplificado/listCursoSimplfView";
    }
}