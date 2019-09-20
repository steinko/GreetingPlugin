 plugins {
 
               id("org.jetbrains.kotlin.jvm") version "1.3.50"
               id("org.steinko.greeting")
               id ("org.jmailen.kotlinter") version "2.0.0"
           }
           
 repositories {
   jcenter()
   mavenCentral()
   maven {
             url =  uri( "https://maven.google.com/")
         }
         
  dependencies  {      
          implementation ("com.pinterest:ktlint:0.34.2")
         }
}