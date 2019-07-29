package com.stackroute.SpringBootTask.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "Muzix")
public class Muzix {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int ratings;
    private String comment;

  public Muzix(String name, String comment) {

  }
}
