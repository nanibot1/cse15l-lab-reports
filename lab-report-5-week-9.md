# Lab Report 5

### grade.sh on student submissions

> The following code block contains my grade.sh code:

```
1   rm -rf student-submission
2   git clone $1 student-submission
3   
4   cd student-submission
5   
6   if [[ -e ListExamples.java ]]
7       then echo "Correct file submitted!"
8   else
9       echo "Incorrect file submitted!"
10      echo "Program FAIL"
11      exit 1
12   fi
13 
14   mv ListExamples.java ..
15   cd -
16 
17   javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java
18   if [[ $? -eq 0 ]]
19       then echo "Files compiled!"
20   else
21       echo "File compilation error!"
22       echo "Program FAIL"
23       exit 1
24   fi
25 
26   java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples > test-results.txt
27 
28   if [[ $? -eq 0 ]]
29       then echo "Tests succeeded!"
30       echo "Program PASS"
31   else
32       echo "Tests failed!"
33       echo "Program FAIL"
34   fi
```

> Using the above grade script along with the server java files and the following student submission ListExamples.java files, you get the following results:

[Compile Error Submission](https://github.com/ucsd-cse15l-f22/list-methods-compile-error)

![Image](https://i.imgur.com/XxJCjoN.png)

[Incorrect File Submission](https://github.com/ucsd-cse15l-f22/list-methods-filename)

![Image](https://i.imgur.com/3PTaxhH.png)

[Correct Submission](https://github.com/ucsd-cse15l-f22/list-methods-corrected)

![Image](https://i.imgur.com/MyEKSjf.png)

> I will be tracing the script with the compile error submission: 

1. Line 1 with command `rm` has no stdout nor stderror, and its return code is zero.
2. Line 2 with command `git clone` has an stderror of "Cloning into 'student-submission'...", and its return code is zero.
3. Line 4 with command `cd` has no stdout nor stderror, and its return code is zero.
4. Line 6 with the condition `-e ListExamples.java` in the `if` statement returns true because the command `cd student-submission` will return with a return code of zero.
5. Line 7 with command echo has an stdout of "Correct file submitted!", and its return code is zero.
6. Lines 9-11 does not run because the condition `-e ListExamples.java` returns true, so the `then` does not pass.
7. Line 12 with the command `fi` has no stdout nor stderror, and its return code is zero.
8. Line 14 with the command `mv` has no stdout nor stderror, and its return code is zero.
9. Line 15 with the command `cd` has an stdout of "/home/linux/ieng6/cs15lfa22/cs15lfa22ok/list-examples-grader", and its return code is zero.
10. Line 17 with the command `javac` has an stderror of "ListExamples.java:15: error: ';' expected
        result.add(0, s)
                        ^
1 error", and its return code is non-zero.
11. Line 18 with the condition `$? -eq 0` in the `if` statement returns false because `$?` is a non-zero value.
12. Line 19 does not run because the `if` statement returns false.
13. Line 21 with the command `echo` has an stdout of "File compilation error!", and its return code is zero.
14. Line 22 with the command `echo` has an stdout of "Program FAIL", and its return code is zero.
15. Line 23 with the command `exit` has no stdout nor stderror, and its return code is non-zero.
16. Lines 24-34 do not run because the program exited early at line 23 with `exit 1`.