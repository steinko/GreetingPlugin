/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Gradle plugin project to get you started.
 * For more details take a look at the Writing Custom Plugins chapter in the Gradle
 * User Manual available at https://docs.gradle.org/5.6.1/userguide/custom_plugins.html
 */

plugins {
    // Apply the Java Gradle plugin development plugin to add support for developing Gradle plugins
    `java-gradle-plugin`

    // Apply the Kotlin JVM plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.3.41"
    
     id("com.gradle.plugin-publish") version "0.10.0"
     id ("org.jmailen.kotlinter") version "2.0.0"
}

repositories {
  jcenter()
  mavenCentral()
  maven {
             url =  uri( "https://maven.google.com/")
           }
  
}

group = "org.steinko.greeting"
version = "0.2"

gradlePlugin {
  plugins {
    create("greetingsPlugin") {
      id = "org.steinko.greeting"
       displayName = "Greet plugin"
      implementationClass = "org.steinko.plugin.GreetingPlugin"
    }
  }
 } 

 
 pluginBundle {
         website = "https://github.com/steinko/GreetingPlugin/wiki"
         vcsUrl =  "https://github.com/steinko/GreetingPlugin"
         description = "This plugin greet"
         tags = listOf("greeting", "salution")
         
 } 


val kotlinVersion = "1.3.50"
val spekVersion = "1.1.5"
val spek2Version = "2.0.7"

dependencies {
    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    
    implementation ("com.pinterest:ktlint:0.34.2")
    

    // Use the Kotlin test library.
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // Use the Kotlin JUnit integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
    
    testImplementation ("org.junit.jupiter:junit-jupiter-api:5.2.0")
    testImplementation ("org.spekframework.spek2:spek-dsl-jvm:$spek2Version")
    testRuntimeOnly ("org.spekframework.spek2:spek-runner-junit5:$spek2Version")

    // include JUnit 5 test engine
    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine:5.2.0") 
    
     testImplementation  (gradleApi())
     
}



// Add a source set for the functional test suite
val functionalTestSourceSet = sourceSets.create("functionalTest") {
}

gradlePlugin.testSourceSets(functionalTestSourceSet)
configurations.getByName("functionalTestImplementation").extendsFrom(configurations.getByName("testImplementation"))

// Add a task to run the functional tests
val functionalTest by tasks.creating(Test::class) {
    testClassesDirs = functionalTestSourceSet.output.classesDirs
    classpath = functionalTestSourceSet.runtimeClasspath
}

val check by tasks.getting(Task::class) {
    // Run the functional tests as part of `check`
    dependsOn(functionalTest)
}
