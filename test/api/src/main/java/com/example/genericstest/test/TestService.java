package com.example.genericstest.test;

import akka.NotUsed;
import akka.stream.javadsl.Source;
import com.example.genericstest.common.Auditable;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import static com.lightbend.lagom.javadsl.api.Service.*;

public interface TestService extends Service
    , Auditable<TestEvent, TestEventDoc>
{

    ServiceCall<NotUsed, String> hello();


    // To prove TestEvent/TestEventDoc are serializable
    ServiceCall<NotUsed, TestEvent> getTestEvent();

    ServiceCall<NotUsed, TestEventDoc> getExtraTestEvents();


    // NOTE: Even though they're redefined here with explicit types, the fact that it's being defined from Auditable
    // seems to make them lose too much info
    //@Override
    ServiceCall<NotUsed, TestEventDoc> getHistoricalEvents();

    //@Override
    ServiceCall<NotUsed, Source<TestEvent, ?>> getLiveEvents();

    @Override
    default Descriptor descriptor() {
        return named("test")
            .withCalls(
                namedCall("hello", this::hello),
                namedCall("getTestEvent", this::getTestEvent),
                namedCall("getExtraTestEvents", this::getExtraTestEvents)
            )
            .withCalls(Auditable.auditCalls(this))
            .withAutoAcl(true);
    }
}
