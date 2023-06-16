package com.example.demo.controllers;

import com.example.demo.data.Travel;
import com.example.demo.services.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/travels")
public class TravelsController {
    @Autowired
    TravelService service;

    @GetMapping("/")
    public String getTravels(Model model) {
        List<Travel> travels = this.service.getTravelsFromRepository();
        for (int i = 0; i < travels.size(); i++) {
            travels.get(i).setId(i + 1);
        }
        model.addAttribute("travels", travels);
        return "travels";
    }

    @GetMapping("/add-travel")
    public String showAddTravelForm(Model model) {
        return "add-travel";
    }

    @PostMapping("/add-travel")
    public String addTravel(@RequestParam("travelName") String travelName,
                            @RequestParam("departureDate") String departureDate,
                            @RequestParam("returnDate") String returnDate,
                            @RequestParam("travelTransport") String travelTransport,
                            @RequestParam("travelRate") String travelRate) {
        Travel travel = new Travel();
        travel.setName(travelName);
        travel.setDepartureDate(departureDate);
        travel.setReturnDate(returnDate);
        travel.setTravelTransport(travelTransport);
        travel.setTravelRate(travelRate);
        this.service.addItem(travel);

        return "redirect:/travels/";
    }
}
