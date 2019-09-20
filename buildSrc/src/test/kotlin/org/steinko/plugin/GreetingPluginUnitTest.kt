package org.steinko.plugin

import kotlin.test.assertNotNull
import org.gradle.testfixtures.ProjectBuilder
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature
/**
 * A simple unit test for the 'org.steinko.plugin.greeting' plugin.
 */
object GreetingPluginUnitTest : Spek({
    Feature("GreetingPluging Unit Test") {
        Scenario("should unit test GreetingPlugin") {

            val project = ProjectBuilder.builder().build()

                When("should apply pluging to prroject") {
                    project.plugins.apply("org.steinko.plugin.GreetingPlugin")
                }

                Then("project should contain a greeting tasks") {
                    assertNotNull(project.tasks.findByName("greeting"))
                }
            }
    }
})
