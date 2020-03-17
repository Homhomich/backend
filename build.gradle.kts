plugins {
    java
}

allprojects {
    apply {
        plugin("java")
    }

    group = "ru.relex"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }

    configure<JavaPluginConvention> {
        sourceCompatibility = JavaVersion.VERSION_11
    }

    dependencies {
        compileOnly("org.projectlombok:lombok:1.18.12")
        annotationProcessor("org.projectlombok:lombok:1.18.12")
        testCompileOnly("org.projectlombok:lombok:1.18.12")
        testAnnotationProcessor("org.projectlombok:lombok:1.18.12")
        implementation("ru.relex:TastyFasty-commons:1.0-SNAPSHOT")
    }
}



dependencies {
    implementation(project(":data"))
    implementation("org.springframework.boot:spring-boot-starter-web:2.2.5.RELEASE")
    testCompile("junit:junit:4.12")
}

