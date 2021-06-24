# codeSalad

A delicious salad made of tasty solutions for different coding problems.

## Table of contents

- [Introduction](#introduction)
- [Problems](#problems)
- [Linux - macOS](#linux---macos)
- [Windows](#windows)
- [Contributing](#contributing)

## Introduction

This repository contains **my** Java solutions for Gayle Laakmann McDowell's [Cracking the Coding Interview 6th Edition](https://www.amazon.it/Cracking-Coding-Interview-Programming-Questions/dp/0984782850). Although there are already other repos containing solutions to such problems, you can still find this one useful. Why? For the following reasons:

- there are **two** solutions for each problem: the first developed *before* reading the problem solution, the second *after* reading the tips and the official solution provided in the book. Just to be clear, the solutions provided in this repository are not necessarily the same given in the book: indeed, I used the official solutions as a starting point for my reasoning, which often led me to different algorithms;
- since the book, among other things, aims to stimulate your ability to come up with good algorithms for the provided problems, I decided to keep track of my performance improvements by **timing** the solutions *before* and *after* reading the official solutions. To time these solutions by yourself, read the [Timing](#timing) section. 
- as stated by Martin in [Clean Code](https://www.amazon.it/Clean-Code-Handbook-Software-Craftsmanship/dp/0132350882), a good practice is to always test the code. Thus, in this repository you will find all the tests to check the code goodness. Read the [Testing](#testing) section to know how.

The project is based on [Gradle](https://github.com/gradle/gradle) automation tool. A version of such tool is provided inside this repository to reach out whoever does not have it installed on his machine. Thus, all the commands indicated here use such script. However, if you have Gradle already installed on your machine, feel free to use it, even though I can't vouch for its compatibility. In case of any issue, please contact me.

## Problems

1. [Chapter 1 - Arrays and Strings](src/code/chapter01): `5 / 9`  complete.
1. [Chapter 2 - Linked Lists](src/code/chapter02): `4 / 8`  complete.
1. [Chapter 3 - Stacks and Queues](src/code/chapter03): `3 / 6`  complete.

## Linux - macOS

Here a list of the commands you need to build, run, time or test the program.

### Building

To build the programs, inside the the project root run the following command:

```shell
$ ./gradlew build
```

### Running

To run the programs, inside the the project root run the following command:

```shell
$ ./gradlew run
```

### Timing

To time the programs, inside the the project root run the following command:

```shell
$ ./gradlew run --args="-t"
```

### Testing

To test the programs, inside the the project root run the following command:

```shell
$ ./gradlew cleanTest && ./gradlew test
```

All tests are based on the [JUnit 5 framework](https://github.com/junit-team/junit5).

## Windows

In this repository you will find the Windows script for Gradle, namely `gradlew.bat`. If you want to run on Windows, just replace `./gradlew` with`gradlew.bat` in the commands above.

## Contributing

The repository is born with the goal to give real evidence of the results you can reach by exercising on coding on a regular basis. Of course, the project is huge and contributions are welcome. You could contribute in many ways:

- fixing bugs;
- improving the test coverage with new tests;  
- working on the same problem but using a different programming language.

In any case, please fork the project and make a *pull request* to the `main` branch. Feel free to contact me for any problem.