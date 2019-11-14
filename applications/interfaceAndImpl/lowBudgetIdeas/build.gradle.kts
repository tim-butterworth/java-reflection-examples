plugins {
    `java-library`
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

dependencies {
    implementation(project(":greatIdeaInterfaces"))
}