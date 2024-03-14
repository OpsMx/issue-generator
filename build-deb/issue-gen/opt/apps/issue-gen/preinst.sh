#!/bin/bash -x

# Pre-installation script
# Used for manual run. It cannot be called automatically by .deb install as the scriptfile will not be available prior to installation

sleep 180s
#cd /opt/apps/issue-gen
proc=`ps -ef|grep issuegen |grep -v grep |awk '{ print $2}'`
if [ -z "$proc" ]; then
   echo "App is not running. Proceeding with installation ..."
else
   echo "App is running. Stopping it before installation ..."
   kill -9 $proc
   DTSTAMP=$(date '+%Y-%m-%d_%H-%M-%S')
   LOG_FILE="issuegen.log"
   cd /opt/apps/issue-gen
   cp -v $LOG_FILE $LOG_FILE_$DTSTAMP.log
fi

#echo "Pre-install : Nothing configured"
echo "Pre-install script : done"
