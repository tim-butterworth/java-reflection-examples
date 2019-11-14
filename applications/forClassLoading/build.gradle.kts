plugins {
    `java-library`
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}
dependencies {
    compile("com.fasterxml.jackson.core:jackson-core:2.10.0")
    compile("com.fasterxml.jackson.core:jackson-databind:2.10.0")

    implementation(project(":greatIdeaInterfaces"))
//    implementation(project(":highQualityIdeas"))
//    implementation(project(":lowBudgetIdeas"))
}