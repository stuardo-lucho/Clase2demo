package com.example.demo.controller;

import com.example.demo.entity.Territory;
import com.example.demo.repository.TerritoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/territory")
public class TerritoryController {

    @Autowired
    TerritoryRepository territoryRepository;

    @GetMapping("/list")
    public String listTerritories(Model model){

        List<Territory> listaterritorioStuardo = territoryRepository.findAllByTerritorydescription("abc");
        model.addAttribute("listOfTerritories", listaterritorioStuardo);

        return "territory/list";
    }

    @GetMapping("/add")
    public String returnForm(Model model){

        // TODO retornar la lista de la base de datos
        ArrayList<Integer> listOfRegions = new ArrayList<>();
        listOfRegions.add(1);
        listOfRegions.add(2);
        listOfRegions.add(3);
        listOfRegions.add(4);

        model.addAttribute("listOfRegionsId", listOfRegions);
        return "territory/form";
    }

    @PostMapping("/add")
    public String createTerritory(
            @RequestParam("territorydescription") String territorydescription,
            @RequestParam("regionid") String regionidString,
            @RequestParam("territoryid") String territoryid,

            RedirectAttributes attributes
    ){

        Territory territory = new Territory();
        territory.setTerritorydescription(territorydescription);
        territory.setRegionid(regionidString);
        territory.setTerritoryid(territoryid);
        territoryRepository.save(territory);

        attributes.addFlashAttribute("msg", "chibolin presidente");

        return "redirect:/territory/list";
    }

    @GetMapping("/borrar")
    public String deletTerrotory(Model model, @RequestParam("id") String id) {

        Optional<Territory> optShipper = territoryRepository.findById(id);

        if (optShipper.isPresent()) {
            territoryRepository.deleteById(id);
        }

        return "redirect:/territory/list";

    }

    @GetMapping("/editar")
    public String editTerrotory(Model model, @RequestParam("id") String id) {

        // obtener objeto
        // retornar el html

        Optional<Territory> optShipper = territoryRepository.findById(id);

        if (optShipper.isPresent()) {
            Territory territory = optShipper.get();

            model.addAttribute("territory", territory);
            return "territory/editForm";
        } else {
            return "redirect:/territory/list";
        }

    }
}
