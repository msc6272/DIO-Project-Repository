# REST API with Kotlin

[Original Source Code](https://github.com/cami-la/credit-application-system)

[Notes for the Original Code](https://gist.github.com/cami-la/560b455b901778391abd2c9edea81286)

## Installing Kotlin in Ubuntu

[How to Install and Run Kotlin in Ubuntu](https://linuxhint.com/kotlin_ubuntu/)

```sh
sudo apt update
sudo apt install zip
sudo apt install unzip
curl -s https://get.sdkman.io | bash
sdk install kotlin
```

## Installing Extensions for Kotlin in VSCode

- Kotlin: from fwcd
- Kotlin Language: from mathiasfrohlich

## Other Links

[Setup VSCode for Kotlin Development](https://in-kotlin.com/ide/vscode/setup-vscode-for-kotlin-development/)

[Understanding Gradle Tasks](https://betterprogramming.pub/understanding-gradle-tasks-417d6f5e13f4)

[The Java Plugin](https://docs.gradle.org/current/userguide/java_plugin.html)

[Build Script Basics](https://docs.gradle.org/current/userguide/tutorial_using_tasks.html)

[Developing Custom Gradle Task Types](https://docs.gradle.org/current/userguide/custom_tasks.html#custom_tasks)

[\(Best!!!\) Debugging Kotlin program using VSCode](https://medium.com/@thunderz99/debugging-kotlin-program-using-vscode-318ed43fe2f0)

[springdoc-openapi v2.1.0](https://springdoc.org/v2/#getting-started)

[JUnit 5 Quickstart](https://java.testcontainers.org/quickstart/junit_5_quickstart/)

[JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)

[AssertJ - fluent assertions java library](https://assertj.github.io/doc/)

## Application Resources

- [Console do H2](http://localhost:8080/h2-console) -> ver arquivo application.yml para dados de conexão

## Executing the code

1. Build the code
    a. Open the command pallete
    b. Type Tasks
    c. Choose Run task
    d. Type gradle:build
2. Run the code
    a. Open a terminal console
    b. Change the prompt to the folder build/libs
    c. Run the .jar file with the command: "java -jar \<filename\>.jar"

Another way of executing the code is to run the following command: **./gradlew bootRun**
