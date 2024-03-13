plugins {
    id("java")
}

group = "com.cleverthis.interview"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":padlock-impl"))
    // if you ever need import more dependencies, following this format:
    // implementation("group-id:project-id:version")
    // just like the logback classic
    // implementation("ch.qos.logback:logback-classic:1.5.3")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.test {
    useJUnitPlatform()
}