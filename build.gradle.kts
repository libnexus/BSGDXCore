plugins {
    id("java")
}

group = "com.libnexus.bsgdx.plugin.core"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(files("C:\\Users\\Shaun.LAPTOP-418HJLF3\\Documents\\Boid Simulator GDX\\desktop\\build\\libs\\desktop-1.0.jar"))
}

tasks.test {
    useJUnitPlatform()
}