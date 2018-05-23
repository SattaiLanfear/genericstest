organization in ThisBuild := "com.example"
version in ThisBuild := "1.0-SNAPSHOT"

// the Scala version that will be used for cross-compiled libraries
scalaVersion in ThisBuild := "2.12.6"


lazy val `genericstest` = (project in file("."))
  .aggregate(
    `common-api`,
    `common-impl`,
    `test-api`,
    `test-impl`
  )


lazy val `common-api` = (project in file("common/api"))
  .settings(
    libraryDependencies ++= Seq(
      // Lagom
      lagomJavadslApi,

      lombok
    )
  )

lazy val `common-impl` = (project in file("common/impl"))
  .settings(
    libraryDependencies ++= Seq(
      lombok
    )
  )
  .dependsOn(`common-api`)


lazy val `test-api` = (project in file("test/api"))
  .settings(
    libraryDependencies ++= Seq(
      lagomJavadslApi,

      lombok
    )
  ).dependsOn(`common-api`)


lazy val `test-impl` = (project in file("test/impl"))
  .enablePlugins(LagomJava)
  .settings(
    libraryDependencies ++= Seq(
      lombok,

      lagomJavadslTestKit
    ) ++ lagomJUnitDeps
  )
  .dependsOn(
    `common-impl`,
    `test-api`
  )




val lombok = "org.projectlombok" % "lombok" % "1.16.18" % Compile

javacOptions in compile in ThisBuild += "-parameters"

