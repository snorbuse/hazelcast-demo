package se.snorbu.hazelcastdemo.domain.model;

import lombok.Value;

import java.io.Serializable;

@Value(staticConstructor = "of")
public class Person implements Serializable {
    private String firstName;
    private String lastName;
}
