package com.example.genericstest.common.impl;

import akka.NotUsed;
import akka.stream.javadsl.Source;
import com.example.genericstest.common.Auditable;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import java.util.concurrent.CompletableFuture;

public abstract class AbstractAuditable<Event, EventDoc> implements Auditable<Event, EventDoc> {

    @Override
    public ServiceCall<NotUsed, EventDoc> getHistoricalEvents() {
        // Fake implementations, theoretically this would go use some interface to fetch events as a document
        return notUsed -> CompletableFuture.completedFuture(null);
    }


    @Override
    public ServiceCall<NotUsed, Source<Event, ?>> getLiveEvents() {
        // Fake implementations, theoretically this would go use some interface to fetch events
        return notUsed -> CompletableFuture.completedFuture(Source.empty());
    }

}
