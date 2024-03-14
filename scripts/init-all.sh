#!/bin/bash
# Filename: init-all.sh (Present at /usr/local/bin/)
# Assuming every startup scripts are in /opt/scripts/init.d/
script_dir="/opt/apps/issue-gen/scripts/init.d"

# Quit if the scripts directory does not exist
if [ ! -d "$script_dir" ]; then
  echo "Directory does not exist: $script_dir"
  exit 1
fi

# Iterate through each shell script in the directory
#cd $script_dir #Danger. Parents scripts behave differently due to CD
for script_file in $script_dir/*.sh; do
  # Check if the file is a regular file and executable
  if [ -f "$script_file" ] && [ -x "$script_file" ]; then
    echo "==> Running $script_file"
    # Execute the shell script
     ./$script_file
    echo "==> End of $script_file"
  else
    echo "Skipping $script_file (not executable)"
  fi
done
