package com.ofa.quote.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "quotes")
@Entity
public class Quote {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String quote;
    private String author;
    @ManyToOne
    private Category category;
    @ManyToMany(mappedBy = "quotes")
    private List<User> users;

}
