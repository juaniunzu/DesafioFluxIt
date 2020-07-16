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
public class Info implements Serializable {

    private String seed;
    private int results;
    private int page;
    private String version;

}
