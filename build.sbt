name := """scalaApplication"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

resolvers := ("Atlassian Releases" at "https://maven.atlassian.com/public/") +: resolvers.value

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies ++= Seq(
	  "com.mohiva" %% "play-silhouette" % "3.0.0",
  "org.webjars" %% "webjars-play" % "2.4.0-1",
  "net.codingwell" %% "scala-guice" % "4.0.0",
  "net.ceedubs" %% "ficus" % "1.1.2",
  "com.adrianhurt" %% "play-bootstrap3" % "0.4.4-P24",
  "com.mohiva" %% "play-silhouette-testkit" % "3.0.0" % "test",
  "mysql" % "mysql-connector-java" % "5.1.21",
  "org.hibernate" % "hibernate-entitymanager" % "4.3.9.Final" ,
  javaCore,
  javaJdbc,
  javaJpa,
  	jdbc,
  	cache,
  	ws,
  	specs2 % Test
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

PlayKeys.externalizeResources := false

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
