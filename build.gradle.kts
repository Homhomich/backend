import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    java
    id("org.springframework.boot") version "2.2.5.RELEASE"
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
    implementation("org.hibernate.validator:hibernate-validator:6.1.2.Final") /* тоже надо будет удалить когда перейдем на сервисы*/
    implementation(project(":security"))
    implementation(project(":services"))
    implementation("org.springframework.boot:spring-boot-starter-web:2.2.5.RELEASE")
    testCompile("junit:junit:4.12")
}

springBoot {
    mainClassName = "ru.relex.tastyfasty.rest.TastyFasty"
}


val bootJar: BootJar by tasks

bootJar.apply {
    launchScript()
}
