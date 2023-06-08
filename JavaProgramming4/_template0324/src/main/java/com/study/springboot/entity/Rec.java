package com.study.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString (exclude = "person")
@Builder
@Getter
@Setter
public class Rec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long rid;
    String content;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "PERSON_ID")
    @JsonIgnore
    private Person person;
}
