## Practical task for module 5 of Java Advanced: Backend Core Program - Clean Code

### Task 1: Optimize and Re-architect a Library Management System's Book Lending Feature

### Task 2: Refactor the Employee Class

### Task 3: Critical Evaluation for Liskov Substitution Principle

The Liskov Substitution Principle (LSP) states that objects of a superclass shall be replaceable with objects of its subclasses without altering the correctness of the program. 
In the provided code, the <code>PayPalPayment</code> class violates LSP because it throws an UnsupportedOperationException under certain conditions (when the PayPal account is not linked to a bank account), 
which is not expected behavior from the superclass <code>PaymentMethod</code>.
To fix this violation, the code has been refactored using the Template Method design pattern. 
This pattern allows us to define the skeleton of an algorithm in a method, deferring some steps to subclasses. 
This way, it was ensured that each subclass will handle its specific steps without altering the behavior expected by the superclass.

### Task 4: SonarQube Analysis

The provided code includes intentional issues and vulnerabilities: 

   1. Bugs:
        - faultyLogic: Division by zero.
        - randomBug: Randomly generates an index that could be out of bounds for the array.

   2. Vulnerabilities:
        - unsafeMethod and duplicateCodeExample: Both methods contain SQL injection vulnerabilities by directly including user input in the SQL query.

   3. Code Smells:
        - duplicateCodeExample: Contains duplicated code from unsafeMethod.
        - complexMethod: An example of a long and complex method that does simple tasks in an overly complicated way.
