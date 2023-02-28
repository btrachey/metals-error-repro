scalaVersion := "3.2.0"

enablePlugins(ScalaNativePlugin)

// set to Debug for compilation details (Info is default)
logLevel := Level.Info

// import to add Scala Native options
import scala.scalanative.build._

// defaults set with common options shown
nativeConfig ~= { c =>
  c.withLTO(LTO.none) // thin
    .withMode(Mode.debug) // releaseFast
    .withGC(GC.immix) // commix
}

resolvers += Resolver.githubPackages("edadma")
libraryDependencies += ("io.github.edadma" %%% "libsndfile" % "0.1.2").cross(
  CrossVersion.for3Use2_13
)
