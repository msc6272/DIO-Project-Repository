# Lab Project: Designing a Bootcamp using OOP

## Links

[Create useful .gitignore files](https://www.toptal.com/developers/gitignore/)
[Fork Source](https://github.com/cami-la/desafio-poo-dio/)

## Modifications to the original implementation

1. Interface Certificado created

2. Abstract Class Colaborador created

3. Class Instrutor created

4. Class Convidado created

5. Class Skill created

6. Class Modulo created

7. Some properties were added to the original classes to accomodate the new classes created

## To be implemented

* Instead of calculating the XP everytime, I think a property called XP should be created and when a progression occurs, this new property should be updated
* Contents should be part of a Modulo object, so the Bootcamp object must have a set of Modulos instead of a set of Conteudos.
* It seems that the method calcularXP is not needed for the Curso and Mentoria objects
* Besides Curso and Mentoria, there are two more contents: Lab Project and Code Challenge
* Every Curso object also has one or more topics (Topic object to be created) and also a knowledge test (to be created)
* Every Dev object should have a ranking property (must create a method to calculate the rank) that  should be calculated inside the progredir method (maybe somewhere else)
