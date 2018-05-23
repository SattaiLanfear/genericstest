package com.example.genericstest.test.impl;

import akka.NotUsed;
import com.example.genericstest.common.impl.AbstractAuditable;
import com.example.genericstest.test.TestEvent;
import com.example.genericstest.test.TestEventDoc;
import com.example.genericstest.test.TestService;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import org.pcollections.TreePVector;

import java.util.concurrent.CompletableFuture;

public class TestServiceImpl extends AbstractAuditable<TestEvent, TestEventDoc> implements TestService {

    @Override
    public ServiceCall<NotUsed, String> hello() {
        return notUsed -> CompletableFuture.completedFuture("Hello");
    }

    @Override
    public ServiceCall<NotUsed, TestEvent> getTestEvent() {
        return notUsed -> CompletableFuture.completedFuture(new TestEvent("Value!"));
    }

    @Override
    public ServiceCall<NotUsed, TestEventDoc> getExtraTestEvents() {
        return notUsed -> CompletableFuture.completedFuture(new TestEventDoc(
            TreePVector.empty()
        ));
    }
}
