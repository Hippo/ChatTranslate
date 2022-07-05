plugins {
    id("java")
    id("maven-publish")
}

group = "rip.hippo"
version = "1.2.0"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://jitpack.io")
}

dependencies {
    implementation("org.spigotmc:spigot-api:1.19-R0.1-SNAPSHOT")
    implementation("rip.hippo:BukkitVersion:1.0.0")
}


publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}