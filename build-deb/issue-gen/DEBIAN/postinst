#!/bin/bash
#Post-install script

#/opt/apps/issue-gen/issuegen-start.sh

sleep 30s
echo "Pre-run for jar modification"
. /opt/apps/issue-gen/scripts/init-all.sh

echo "Starting application ..."
cd /opt/apps/issue-gen
LOG_FILE="issuegen.log"
nohup java -jar issuegen-0.1.jar </dev/null &> $LOG_FILE &
sleep 1m

# Check if the log file contains text X, Y, or Z
if grep -qE 'BindException|ERROR Failed to start' "$LOG_FILE"; then
    echo "Application failed to start. Found error text in the App log file."
    exit 1  # Exit with error code 1
else
    echo "Application started successfully."
    exit 0  # Exit peacefully with code 0
fi
