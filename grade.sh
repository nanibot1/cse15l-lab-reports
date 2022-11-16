# Create your grading script here

set -e

rm -rf student-submission
git clone $1 student-submission

rm -rf graded-submission

if [[ -e ListExamples.java ]]
    then echo "Correct file submitted!"
else
    echo "Correct file submitted!"
fi

mkdir graded-submission
cp TestListExamples.java ListExamples.java -r ./lib graded-submission/

cd graded-submission

set +e
javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java
if [[ $? -eq 0 ]]
    then echo "Files compiled!"
else
    echo "File compilation error!"
fi

java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples > test-results.txt

grep "FAILURES" test-results.txt > grep-results.txt

if [[ -s grep-results.txt ]]
    then echo "Tests failed!"
else
    echo "Tests succeeded!"
fi