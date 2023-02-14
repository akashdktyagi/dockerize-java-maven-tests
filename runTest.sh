#!/bin/sh
echo "Executing maven command to run test"
echo "mvn clean test -DgridUrl='$1'"

mvn -o clean test -DgridUrl="$1"
#mvn package -o -llr -B -DgridUrl="$1"