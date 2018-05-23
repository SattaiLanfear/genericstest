# genericstest

This is a simple test project to show a generic interface
driving a Lagom API.

Attempting to runAll results in:
```console
com.google.inject.CreationException: Unable to create injector, see the following errors:

1) Error in custom provider, scala.MatchError: EventDoc (of class sun.reflect.generics.reflectiveObjects.TypeVariableImpl)
  at com.lightbend.lagom.javadsl.server.ServiceGuiceSupport.bindServices(ServiceGuiceSupport.java:106) (via modules: com.google.inject.util.Modules$OverrideModule -> com.example.genericstest.test.impl.TestServiceModule)
  while locating com.lightbend.lagom.internal.javadsl.server.ResolvedServices
    for the 2nd parameter of com.lightbend.lagom.internal.server.ServiceRegistrationModule$RegisterWithServiceRegistry.<init>(ServiceRegistrationModule.scala:56)
  at com.lightbend.lagom.internal.server.ServiceRegistrationModule.bindings(ServiceRegistrationModule.scala:29):
Binding(class com.lightbend.lagom.internal.server.ServiceRegistrationModule$RegisterWithServiceRegistry to self eagerly) (via modules: com.google.inject.util.Modules$OverrideModule -> play.api.inject.guice.GuiceableModuleConversions$$anon$1)
  while locating com.lightbend.lagom.internal.server.ServiceRegistrationModule$RegisterWithServiceRegistry

1 error
	at com.google.inject.internal.Errors.throwCreationExceptionIfErrorsExist(Errors.java:470)
	at com.google.inject.internal.InternalInjectorCreator.injectDynamically(InternalInjectorCreator.java:184)
	at com.google.inject.internal.InternalInjectorCreator.build(InternalInjectorCreator.java:110)
	at com.google.inject.Guice.createInjector(Guice.java:99)
	at com.google.inject.Guice.createInjector(Guice.java:84)
	at play.api.inject.guice.GuiceBuilder.injector(GuiceInjectorBuilder.scala:185)
	at play.api.inject.guice.GuiceApplicationBuilder.build(GuiceApplicationBuilder.scala:137)
	at play.api.inject.guice.GuiceApplicationLoader.load(GuiceApplicationLoader.scala:21)
	at play.core.server.LagomReloadableDevServerStart$$anon$1.$anonfun$get$5(LagomReloadableDevServerStart.scala:176)
	at play.utils.Threads$.withContextClassLoader(Threads.scala:21)
	at play.core.server.LagomReloadableDevServerStart$$anon$1.$anonfun$get$3(LagomReloadableDevServerStart.scala:173)
	at scala.Option.map(Option.scala:146)
	at play.core.server.LagomReloadableDevServerStart$$anon$1.$anonfun$get$2(LagomReloadableDevServerStart.scala:149)
	at scala.util.Success.flatMap(Try.scala:247)
	at play.core.server.LagomReloadableDevServerStart$$anon$1.$anonfun$get$1(LagomReloadableDevServerStart.scala:147)
	at scala.concurrent.Future$.$anonfun$apply$1(Future.scala:654)
	at scala.util.Success.$anonfun$map$1(Try.scala:251)
	at scala.util.Success.map(Try.scala:209)
	at scala.concurrent.Future.$anonfun$map$1(Future.scala:288)
	at scala.concurrent.impl.Promise.liftedTree1$1(Promise.scala:29)
	at scala.concurrent.impl.Promise.$anonfun$transform$1(Promise.scala:29)
	at scala.concurrent.impl.CallbackRunnable.run(Promise.scala:60)
	at java.util.concurrent.ForkJoinTask$RunnableExecuteAction.exec(ForkJoinTask.java:1402)
	at java.util.concurrent.ForkJoinTask.doExec(ForkJoinTask.java:289)
	at java.util.concurrent.ForkJoinPool$WorkQueue.runTask(ForkJoinPool.java:1056)
	at java.util.concurrent.ForkJoinPool.runWorker(ForkJoinPool.java:1692)
	at java.util.concurrent.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:157)
Caused by: scala.MatchError: EventDoc (of class sun.reflect.generics.reflectiveObjects.TypeVariableImpl)
	at com.lightbend.lagom.internal.javadsl.api.CallResolver.$anonfun$registeredMessageSerializerFor$1(ServiceCallResolver.scala:46)
	at scala.Option.orElse(Option.scala:289)
	at com.lightbend.lagom.internal.javadsl.api.CallResolver.registeredMessageSerializerFor(ServiceCallResolver.scala:44)
	at com.lightbend.lagom.internal.javadsl.api.CallResolver.messageSerializerFor(ServiceCallResolver.scala:26)
	at com.lightbend.lagom.internal.javadsl.api.CallResolver.resolveMessageSerializer(ServiceCallResolver.scala:17)
	at com.lightbend.lagom.internal.javadsl.api.ServiceReader$.$anonfun$resolveServiceDescriptor$3(ServiceReader.scala:150)
	at scala.collection.TraversableLike.$anonfun$map$1(TraversableLike.scala:234)
	at scala.collection.Iterator.foreach(Iterator.scala:944)
	at scala.collection.Iterator.foreach$(Iterator.scala:944)
	at scala.collection.AbstractIterator.foreach(Iterator.scala:1432)
	at scala.collection.IterableLike.foreach(IterableLike.scala:71)
	at scala.collection.IterableLike.foreach$(IterableLike.scala:70)
	at scala.collection.AbstractIterable.foreach(Iterable.scala:54)
	at scala.collection.TraversableLike.map(TraversableLike.scala:234)
	at scala.collection.TraversableLike.map$(TraversableLike.scala:227)
	at scala.collection.AbstractTraversable.map(Traversable.scala:104)
	at com.lightbend.lagom.internal.javadsl.api.ServiceReader$.resolveServiceDescriptor(ServiceReader.scala:93)
	at com.lightbend.lagom.internal.javadsl.server.JavadslServerBuilder.resolveDescriptor(JavadslServerBuilder.scala:69)
	at com.lightbend.lagom.internal.javadsl.server.JavadslServerBuilder.$anonfun$resolveServices$1(JavadslServerBuilder.scala:56)
	at scala.collection.TraversableLike.$anonfun$map$1(TraversableLike.scala:234)
	at scala.collection.mutable.ResizableArray.foreach(ResizableArray.scala:59)
	at scala.collection.mutable.ResizableArray.foreach$(ResizableArray.scala:52)
	at scala.collection.mutable.ArrayBuffer.foreach(ArrayBuffer.scala:48)
	at scala.collection.TraversableLike.map(TraversableLike.scala:234)
	at scala.collection.TraversableLike.map$(TraversableLike.scala:227)
	at scala.collection.AbstractTraversable.map(Traversable.scala:104)
	at com.lightbend.lagom.internal.javadsl.server.JavadslServerBuilder.resolveServices(JavadslServerBuilder.scala:50)
	at com.lightbend.lagom.internal.javadsl.server.ResolvedServicesProvider.get$lzycompute(JavadslServerBuilder.scala:112)
	at com.lightbend.lagom.internal.javadsl.server.ResolvedServicesProvider.get(JavadslServerBuilder.scala:111)
	at com.lightbend.lagom.internal.javadsl.server.ResolvedServicesProvider.get(JavadslServerBuilder.scala:105)
	at com.google.inject.internal.ProviderInternalFactory.provision(ProviderInternalFactory.java:81)
	at com.google.inject.internal.InternalFactoryToInitializableAdapter.provision(InternalFactoryToInitializableAdapter.java:53)
	at com.google.inject.internal.ProviderInternalFactory.circularGet(ProviderInternalFactory.java:61)
	at com.google.inject.internal.InternalFactoryToInitializableAdapter.get(InternalFactoryToInitializableAdapter.java:45)
	at com.google.inject.internal.SingleParameterInjector.inject(SingleParameterInjector.java:38)
	at com.google.inject.internal.SingleParameterInjector.getAll(SingleParameterInjector.java:62)
	at com.google.inject.internal.ConstructorInjector.provision(ConstructorInjector.java:110)
	at com.google.inject.internal.ConstructorInjector.construct(ConstructorInjector.java:90)
	at com.google.inject.internal.ConstructorBindingImpl$Factory.get(ConstructorBindingImpl.java:268)
	at com.google.inject.i````nternal.ProviderToInternalFactoryAdapter$1.call(ProviderToInternalFactoryAdapter.java:46)
	at com.google.inject.internal.InjectorImpl.callInContext(InjectorImpl.java:1092)
	at com.google.inject.internal.ProviderToInternalFactoryAdapter.get(ProviderToInternalFactoryAdapter.java:40)
	at com.google.inject.internal.SingletonScope$1.get(SingletonScope.java:194)
	at com.google.inject.internal.InternalFactoryToProviderAdapter.get(InternalFactoryToProviderAdapter.java:41)
	at com.google.inject.internal.InternalInjectorCreator$1.call(InternalInjectorCreator.java:205)
	at com.google.inject.internal.InternalInjectorCreator$1.call(InternalInjectorCreator.java:199)
	at com.google.inject.internal.InjectorImpl.callInContext(InjectorImpl.java:1085)
	at com.google.inject.internal.InternalInjectorCreator.loadEagerSingletons(InternalInjectorCreator.java:199)
	at com.google.inject.internal.InternalInjectorCreator.injectDynamically(InternalInjectorCreator.java:180)
	... 25 more
```

Commenting out two lines in TestService.java enables it to work again (removing the inherited interface and methods coming from it)
These are lines 13 and 41