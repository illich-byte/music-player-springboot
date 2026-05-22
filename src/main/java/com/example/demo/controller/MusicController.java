package com.example.demo.controller;

import com.example.demo.model.Music;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MusicController {

    @GetMapping("/")
    public String getMusicList(Model model) {
        List<Music> playlist = new ArrayList<>();
        
        playlist.add(new Music("Borderline", "idk", "Tame_Impala_-_Borderline_63547705.mp3"));
        model.addAttribute("songs", playlist);
        return "index"; // повертає шаблон index.html
    }
}