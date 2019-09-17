plugins {
    `java-gradle-plugin` 
    id("com.gradle.plugin-publish") version "0.10.0"  
} 

repositories {
  jcenter()
}

gradlePlugin {
  plugins {
    create("greetingsPlugin") {
      id = "org.steinko.greeting"
      implementationClass = "org.steinko.plugin.GreetingPlugin"
    }
  }
 } 
pluginBundle {
    website = "http://www.gradle.org/" 
    vcsUrl = "https://github.com/steinko/GreetingPlugin" 
    tags = listOf( "greeting", "plugin") 


description = "Greetings from here!"

(plugins) {

    // first plugin
    "greetingsPlugin" {
      // id is captured from java-gradle-plugin configuration
      displayName = "Gradle Greeting plugin"
      version = "1.0"
    }
   }
  }
