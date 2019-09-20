plugins {
    
    id("org.jetbrains.kotlin.jvm") version "1.3.41"
    id("org.jmailen.kotlinter") version "2.1.1"
}

repositories {
     mavenCentral()
     jcenter()
}

val kotlinVersion = "1.3.50"
val spekVersion = "1.1.5"
val spek2Version = "2.0.7"

dependencies {
    
    
     // include Kotlin standard library
    implementation ("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    implementation ("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
    implementation ("org.jetbrains.kotlin:kotlin-script-runtime:$kotlinVersion")
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    
    // include JUnit 5 assertions
    testImplementation ("org.junit.jupiter:junit-jupiter-api:5.2.0")
    testImplementation ("org.spekframework.spek2:spek-dsl-jvm:$spek2Version")
    testRuntimeOnly ("org.spekframework.spek2:spek-runner-junit5:$spek2Version")

    // include JUnit 5 test engine
    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine:5.2.0") 
    
    testImplementation  (gradleApi())
    testImplementation (gradleTestKit())
    
    testImplementation ("com.willowtreeapps.assertk:assertk-jvm:0.19")
}

tasks {
    // Use the built-in JUnit support of Gradle.
    "test"(Test::class) {
        useJUnitPlatform()
    }
}
