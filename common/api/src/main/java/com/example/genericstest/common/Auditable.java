package com.example.genericstest.common;


import akka.NotUsed;
import akka.stream.javadsl.Source;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import static com.lightbend.lagom.javadsl.api.Service.*;

/**
 * An auditable service.
 *
 * @param <Event>
 */
public interface Auditable<Event, EventDoc> {

    ServiceCall<NotUsed, EventDoc> getHistoricalEvents();

    ServiceCall<NotUsed, Source<Event, ?>> getLiveEvents();

    static Descriptor.Call<?, ?>[] auditCalls(Auditable<?, ?> target) {
        return new Descriptor.Call[]{
            // We all use the name path, so no auto acl, talk directly
            namedCall("events/historical", target::getHistoricalEvents)
                .withAutoAcl(false),
            namedCall("events/live", target::getLiveEvents)
                .withAutoAcl(false)
        };
    }
}
