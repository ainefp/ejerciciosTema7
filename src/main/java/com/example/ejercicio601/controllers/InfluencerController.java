package com.example.ejercicio601.controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ejercicio601.domain.Influencer;
import com.example.ejercicio601.services.Influencer.InfluencerService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/influencers")
@RequiredArgsConstructor
public class InfluencerController {

    private final InfluencerService influencerService;

    private String errMsg;

    @ModelAttribute("listaInfluencers")
    public List<Influencer> asignarListaInfluencers() {
        return influencerService.obtenerTodos();
    }

    @GetMapping({"", "/"})
    public String showList(Model model, @RequestParam(required = false) String errorMsg) {
        if (errorMsg != null && !errorMsg.isBlank()) {
            model.addAttribute("errorMsg", errorMsg);
        }
        if (errMsg != null) {
            model.addAttribute("msg", errMsg);
            errMsg = null;
        }
        model.addAttribute("listaInfluencers", influencerService.obtenerTodos());
        return "Influencer/listInfluencerView";
    }

    @GetMapping("/{id}")
    public String showElement(@PathVariable Long id, Model model) {
        Influencer influencer = influencerService.obtenerPorId(id);
        model.addAttribute("influencer", influencer);
        return "Influencer/listOneInfluencerView";
    }

    @GetMapping("/nuevo")
    public String showNew(Model model) {
        model.addAttribute("influencer", new Influencer());
        return "Influencer/newInfluencerFormView";
    }

    @GetMapping("/editar/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Influencer influencer = influencerService.obtenerPorId(id);
        model.addAttribute("influencer", influencer);
        return "Influencer/editInfluencerFormView";
    }

    @GetMapping("/borrar/{id}")
    public String getMethodName(@PathVariable Long id) {
        influencerService.borrar(id);
        errMsg = "Influencer eliminado correctamente";
        return "redirect:/influencers";
    }

    @PostMapping("/nuevo/submit")
    public String submitForm(@ModelAttribute Influencer influencer) {
        influencerService.añadir(influencer);
        errMsg = "Influencer añadido correctamente";
        return "redirect:/influencers";
    }

    @PostMapping("/editar/submit")
    public String submitEdit(@ModelAttribute Influencer influencer) {
        influencerService.editar(influencer);
        errMsg = "Influencer editado correctamente";
        return "redirect:/influencers";
    }
}