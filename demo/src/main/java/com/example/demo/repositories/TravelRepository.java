package com.example.demo.repositories;

import com.example.demo.data.Travel;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
@Getter
public class TravelRepository {
    List<Travel> items;

    public TravelRepository(){
        items = new LinkedList<>();
    }

    public void addItem(Travel travel){
        this.items.add(travel);
    }
}
