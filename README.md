# A Gilded Rose story

In this repository we will be doing a step-by-step tutorial on how to effectively get control of some _legacy_ code that we were tasked to maintain and develop.

This journey is based on the java version of the [Gilded Rose kata](https://github.com/emilybache/GildedRose-Refactoring-Kata).

The core framework used to test our code is [JUnit 5](https://junit.org/junit5/).

We will be looking at how we can quickly put in place tests that verify the behaviour of our application using
[ApprovalTests](https://github.com/approvals/ApprovalTests.Java) to quickly cover all our code, and [PiTest](https://pitest.org/) to maintain the confidence that our tests are covering all possible cases, and we have left no stones unturned. 

* [Day 1](doc/Day_01.md): Acquiring the code and run tests
* [Day 2](doc/Day_02.md): Verifying the test and covering all missing cases
* [Day 3](doc/Day_03.md): Getting inside the code and delivering changes
* [Day 4](doc/Day_04.md): Simplifications and architectural changes to simplify responsibilities
