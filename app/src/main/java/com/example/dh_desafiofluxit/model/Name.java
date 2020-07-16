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
public class Name implements Serializable {

    private String title;
    private String first;
    private String last;

}
