#!/bin/bash

BASEDIR=$(dirname "$0")

dpkg -i $BASEDIR/issue-gen.deb

echo "debin installed"
