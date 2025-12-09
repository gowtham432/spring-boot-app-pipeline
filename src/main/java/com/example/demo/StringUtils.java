[MINOR] CODE_SMELL - java:S1104
File: gowtham432_spring-boot-app-pipeline:src/main/java/com/example/demo/StringUtils.java
Line: 13
Message: Make DEFAULT_ENCODING a static final constant or non-public and provide accessors if needed.
---
[MINOR] CODE_SMELL - java:S1444
File: gowtham432_spring-boot-app-pipeline:src/main/java/com/example/demo/StringUtils.java
Line: 13
Message: Make this "public static DEFAULT_ENCODING" field final
---
[MINOR] CODE_SMELL - java:S3008
File: gowtham432_spring-boot-app-pipeline:src/main/java/com/example/demo/StringUtils.java
Line: 13
Message: Rename this field "DEFAULT_ENCODING" to match the regular expression '^[a-z][a-zA-Z0-9]*$'.
---
[MAJOR] CODE_SMELL - java:S1068
File: gowtham432_spring-boot-app-pipeline:src/main/java/com/example/demo/StringUtils.java
Line: 16
Message: Remove this unused "API_KEY" private field.
---
[MAJOR] CODE_SMELL - java:S1068
File: gowtham432_spring-boot-app-pipeline:src/main/java/com/example/demo/StringUtils.java
Line: 17
Message: Remove this unused "DATABASE_PASSWORD" private field.
---
[MAJOR] CODE_SMELL - java:S1068
File: gowtham432_spring-boot-app-pipeline:src/main/java/com/example/demo/StringUtils.java
Line: 20
Message: Remove this unused "unusedField" private field.
---
[MAJOR] CODE_SMELL - java:S107
File: gowtham432_spring-boot-app-pipeline:src/main/java/com/example/demo/StringUtils.java
Line: 26
Message: Method has 8 parameters, which is greater than 7 authorized.
---
[MAJOR] CODE_SMELL - java:S1172
File: gowtham432_spring-boot-app-pipeline:src/main/java/com/example/demo/StringUtils.java
Line: 27
Message: Remove these unused method parameters "trim", "replacement", "addTimestamp".
---
[BLOCKER] BUG - java:S2095
File: gowtham432_spring-boot-app-pipeline:src/main/java/com/example/demo/StringUtils.java
Line: 59
Message: Use try-with-resources or close this "BufferedReader" in a "finally" clause.
---
[BLOCKER] VULNERABILITY - javasecurity:S2083
File: gowtham432_spring-boot-app-pipeline:src/main/java/com/example/demo/StringUtils.java
Line: 59
Message: Change this code to not construct the path from user-controlled data.
---
[MINOR] CODE_SMELL - java:S1488
File: gowtham432_spring-boot-app-pipeline:src/main/java/com/example/demo/StringUtils.java
Line: 60
Message: Immediately return this expression instead of assigning it to the temporary variable "line".
---
[CRITICAL] CODE_SMELL - java:S3776
File: gowtham432_spring-boot-app-pipeline:src/main/java/com/example/demo/StringUtils.java
Line: 73
Message: Refactor this method to reduce its Cognitive Complexity from 36 to the 15 allowed.
---
[MAJOR] CODE_SMELL - java:S1066
File: gowtham432_spring-boot-app-pipeline:src/main/java/com/example/demo/StringUtils.java
Line: 77
Message: Merge this if statement with the enclosing one.
---
[MAJOR] CODE_SMELL - java:S1066
File: gowtham432_spring-boot-app-pipeline:src/main/java/com/example/demo/StringUtils.java
Line: 78
Message: Merge this if statement with the enclosing one.
---
[MAJOR] CODE_SMELL - java:S1066
File: gowtham432_spring-boot-app-pipeline:src/main/java/com/example/demo/StringUtils.java
Line: 79
Message: Merge this if statement with the enclosing one.
---
[CRITICAL] CODE_SMELL - java:S2692
File: gowtham432_spring-boot-app-pipeline:src/main/java/com/example/demo/StringUtils.java
Line: 79
Message: 0 is a valid index, but is ignored by this check.
---
[MAJOR] CODE_SMELL - java:S1066
File: gowtham432_spring-boot-app-pipeline:src/main/java/com/example/demo/StringUtils.java
Line: 80
Message: Merge this if statement with the enclosing one.
---
[MAJOR] CODE_SMELL - java:S1066
File: gowtham432_spring-boot-app-pipeline:src/main/java/com/example/demo/StringUtils.java
Line: 92
Message: Merge this if statement with the enclosing one.
---
[MINOR] BUG - java:S2184
File: gowtham432_spring-boot-app-pipeline:src/main/java/com/example/demo/StringUtils.java
Line: 115
Message: Cast one of the operands of this division operation to a "double".
---
[MINOR] BUG - java:S2184
File: gowtham432_spring-boot-app-pipeline:src/main/java/com/example/demo/StringUtils.java
Line: 131
Message: Cast one of the operands of this division operation to a "double".
---
[MAJOR] CODE_SMELL - java:S1172
File: gowtham432_spring-boot-app-pipeline:src/main/java/com/example/demo/StringUtils.java
Line: 151
Message: Remove this unused method parameter "address".
---
[MAJOR] BUG - java:S4973
File: gowtham432_spring-boot-app-pipeline:src/main/java/com/example/demo/StringUtils.java
Line: 202
Message: Strings and Boxed types should be compared using "equals()".
---
[MINOR] CODE_SMELL - java:S1126
File: gowtham432_spring-boot-app-pipeline:src/main/java/com/example/demo/StringUtils.java
Line: 202
Message: Replace this if-then-else statement by a single return statement.
---
[MAJOR] CODE_SMELL - java:S1144
File: gowtham432_spring-boot-app-pipeline:src/main/java/com/example/demo/StringUtils.java
Line: 211
Message: Remove this unused private "unusedMethod" method.
---
[MAJOR] CODE_SMELL - java:S106
File: gowtham432_spring-boot-app-pipeline:src/main/java/com/example/demo/StringUtils.java
Line: 212
Message: Replace this use of System.out by a logger.
---