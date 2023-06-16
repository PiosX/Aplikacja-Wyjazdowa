package com.example.demo.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Travel {
    private int id;
    private String name;
    private String departureDate;
    private String returnDate;
    private String travelTransport;
    private String travelRate;
}
