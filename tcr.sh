#!/bin/bash

echo "Running gradle tests..."
./gradlew clean unitTest

# Store the test result
TEST_RESULT=$?

# Check if tests failed
if [ $TEST_RESULT -ne 0 ]; then
    echo "Tests failed! Removing changes..."
    git reset --hard HEAD
    exit 1
fi

echo "Tests passed! Committing..."
git add .
git commit -m "working"
exit 0
