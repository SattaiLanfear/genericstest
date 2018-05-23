package com.example.genericstest.test.impl;


import com.example.genericstest.test.TestService;
import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;


public class TestServiceModule extends AbstractModule
    implements ServiceGuiceSupport {

    @Override
    protected void configure() {
        bindService(TestService.class, TestServiceImpl.class);

    }
}
