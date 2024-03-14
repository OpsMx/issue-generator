#!/bin/bash

sname=$(basename $BASH_SOURCE)
sdir=$(cd `dirname $BASH_SOURCE` && pwd)

# Build
mvn -B -DskipTests clean install -e

#Test the jar execution
#java -jar ./target/issuegen-0.1.jar

#Workspace: issue-generator git repository local
echo "Copying artifacts to staging directory"
cp -v ./target/issuegen-0.1.jar build-deb/issue-gen/opt/apps/issue-gen/issuegen-0.1.jar

