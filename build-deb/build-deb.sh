#!/bin/bash -x

# Build

# Workspace: issue-generator git repository local
cp -v ../target/issuegen-0.1.jar issue-gen/opt/apps/issue-gen/issuegen-0.1.jar

# Copy scripts to package
cp -rv ../scripts/ issue-gen/opt/apps/issue-gen/
chmod +x issue-gen/opt/apps/issue-gen/scripts/*.sh
chmod +x issue-gen/opt/apps/issue-gen/scripts/init.d/*.sh

# Package
pwd
chmod +x issue-gen/DEBIAN/preinst
chmod +x issue-gen/DEBIAN/postinst
chmod +x issue-gen/opt/apps/issue-gen/*.sh

dpkg-deb --build issue-gen
