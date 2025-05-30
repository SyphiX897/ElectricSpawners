plugins {
    id("java")
    id("com.gradleup.shadow") version "9.0.0-beta15"
    id("maven-publish")
}

group = "io.github.thebusybiscuit"
version = "UNOFFICIAL"
description = "ElectricSpawners"

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.destroystokyo.com/repository/maven-public/")
    }
    maven {
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
    maven {
        url = uri("https://jitpack.io")
    }
    maven {
        url = uri("https://repo.codemc.org/repository/maven-public")
    }
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    implementation(libs.org.bstats.bstats.bukkit)
    compileOnly(libs.io.papermc.paper.paper.api)
    compileOnly(libs.com.github.slimefun.slimefun4)
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks {
    build {
        dependsOn(shadowJar)
    }

    shadowJar {
        relocate("org.bstats", "io.github.thebusybiscuit.electricspawners.bstats")
        archiveFileName.set("${rootProject.name}-${version}.jar")
        archiveClassifier.set("")
        destinationDirectory.set(file(rootProject.projectDir.path + "/bin"))
        exclude("META-INF/**")
        from("LICENSE")
        minimize()
    }

    withType<JavaCompile>() {
        options.encoding = "UTF-8"
    }

    withType<Javadoc>() {
        options.encoding = "UTF-8"
    }
}

