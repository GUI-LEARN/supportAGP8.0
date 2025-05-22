package com.demo.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

open class GreetingPluginExtension {
    var message: String = "Hello, World!"
}


class DemoPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.extensions.create("Greeting", GreetingPluginExtension::class.java)
        project.tasks.register("greeting") {
            val message = project.extensions.getByType(GreetingPluginExtension::class.java).message
            println(message)
        }
    }
}