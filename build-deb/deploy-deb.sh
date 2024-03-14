#!/bin/bash

sname=$(basename $BASH_SOURCE)
sdir=$(cd `dirname $BASH_SOURCE` && pwd)

cd $sdir

dpkg -i issue-gen.deb 
