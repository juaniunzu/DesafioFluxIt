package com.example.dh_desafiofluxit.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Location implements Serializable {

    private Street street;
    private String city;
    private String state;
    private String country;
    private Coordinates coordinates;

}
