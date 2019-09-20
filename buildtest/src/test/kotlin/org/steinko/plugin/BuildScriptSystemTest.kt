package org.steinko.projectversion

import assertk.assertThat
import assertk.assertions.contains
import java.io.File
import org.gradle.testkit.runner.BuildResult
import org.gradle.testkit.runner.GradleRunner
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature

object BuildScriptSystemTest : Spek({
    Feature("Build Script System Test") {
        Scenario("Test Properties") {

            var result: BuildResult = GradleRunner.create()
                .withProjectDir(File(ProjectDir.path()))
                .withArguments("greeting")
                .build()

                Then("should test build script") {
                    assertThat(result.getOutput()).contains("BUILD SUCCESSFUL")
                }

                Then("should contain Hello from plugin") {
                    assertThat(result.getOutput()).contains("Hello from plugin")
                }
        }
        }
})
