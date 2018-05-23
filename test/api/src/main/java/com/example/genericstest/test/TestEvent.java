package com.example.genericstest.test;


import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(onConstructor=@__({@JsonCreator}))
public class TestEvent {

    String thing;

}
