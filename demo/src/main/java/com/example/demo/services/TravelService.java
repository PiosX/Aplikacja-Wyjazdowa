package com.example.demo.services;

import com.example.demo.data.Travel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.TravelRepository;

import java.util.List;
@Service
@NoArgsConstructor
@Getter
public class TravelService {
    @Autowired
    TravelRepository items;

    public List<Travel> getTravelsFromRepository() {return this.items.getItems();}

    public void addItem(Travel newTravel) {
        this.items.addItem(newTravel);
    }
}
