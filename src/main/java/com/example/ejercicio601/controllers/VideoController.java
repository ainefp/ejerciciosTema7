package com.example.ejercicio601.controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ejercicio601.domain.Video;
import com.example.ejercicio601.services.Video.VideoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/videos")
@RequiredArgsConstructor
public class VideoController {

    private final VideoService videoService;

    private String errMsg;

    @ModelAttribute("listaVideos")
    public List<Video> asignarListaVideos() {
        return videoService.obtenerTodos();
    }

    @GetMapping({"", "/"})
    public String showList(Model model) {
        if (errMsg != null) {
            model.addAttribute("msg", errMsg);
            errMsg = null;
        }
        model.addAttribute("listaVideos", videoService.obtenerTodos());
        return "Video/listVideoView";
    }

    @GetMapping("/{id}")
    public String showElement(@PathVariable Long id, Model model) {
        Video video = videoService.obtenerPorId(id);
        model.addAttribute("video", video);
        return "Video/listOneVideoView";
    }

    @GetMapping("/nuevo")
    public String showNew(Model model) {
        model.addAttribute("video", new Video());
        return "Video/newVideoFormView";
    }

    @GetMapping("/editar/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Video video = videoService.obtenerPorId(id);
        model.addAttribute("video", video);
        return "Video/editVideoFormView";
    }

    @GetMapping("/borrar/{id}")
    public String getMethodName(@PathVariable Long id) {
        videoService.borrar(id);
        errMsg = "Video eliminado correctamente";
        return "redirect:/videos";
    }

    @PostMapping("/nuevo/submit")
    public String submitForm(@ModelAttribute Video video) {
        videoService.añadir(video);
        errMsg = "Video añadido correctamente";
        return "redirect:/videos";
    }

    @PostMapping("/editar/submit")
    public String submitEdit(@ModelAttribute Video video) {
        videoService.editar(video);
        errMsg = "Video editado correctamente";
        return "redirect:/videos";
    }
}