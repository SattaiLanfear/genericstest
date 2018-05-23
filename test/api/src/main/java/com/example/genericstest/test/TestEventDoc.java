package com.example.genericstest.test;


import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.pcollections.PSequence;

@Value
@AllArgsConstructor(onConstructor=@__({@JsonCreator}))
public class TestEventDoc {

    PSequence<TestEvent> events;

}
