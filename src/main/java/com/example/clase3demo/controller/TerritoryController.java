package com.example.clase3demo.controller;

import com.example.clase3demo.entity.Territory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/territory")
public class TerritoryController {


    @GetMapping(value = {"", "/list"})
    public String listar(Model model){
        List<Territory> list = territoryRepository.findAll();

        model.addAttribute("territoryList",list);
        return "/territories/territoryList";
    }

}
