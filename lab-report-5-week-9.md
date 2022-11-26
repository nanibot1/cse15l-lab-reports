# Lab Report 5

### grade.sh on student submissions

> The following code block contains my grade.sh code:

```
rm -rf student-submission
git clone $1 student-submission

cd student-submission

if [[ -e ListExamples.java ]]
    then echo "Correct file submitted!"
else
    echo "Incorrect file submitted!"
    echo "Program FAIL"
    exit 1
fi

mv ListExamples.java ..
cd -

javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java
if [[ $? -eq 0 ]]
    then echo "Files compiled!"
else
    echo "File compilation error!"
    echo "Program FAIL"
    exit 1
fi

java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples > test-results.txt

if [[ $? -eq 0 ]]
    then echo "Tests succeeded!"
    echo "Program PASS"
else
    echo "Tests failed!"
    echo "Program FAIL"
fi
```

> 

[Compile Error Submission](https://github.com/ucsd-cse15l-f22/list-methods-compile-error)

![Image](https://i.imgur.com/XxJCjoN.png)

[Incorrect File Submission](https://github.com/ucsd-cse15l-f22/list-methods-filename)

![Image](https://i.imgur.com/3PTaxhH.png)

[Correct Submission](https://github.com/ucsd-cse15l-f22/list-methods-corrected)

![Image](https://i.imgur.com/MyEKSjf.png)