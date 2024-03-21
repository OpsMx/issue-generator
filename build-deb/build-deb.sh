#!/bin/bash

# Define variables
BASEDIR=$(dirname "$0")
PKG_NAME="issuegen"
PKG_VERSION="0.1"
PKG_DIR="$BASEDIR/issue-gen"
PKG_DEBIAN_DIR="$PKG_DIR/DEBIAN"
PKG_OPT_DIR="$PKG_DIR/opt/apps/issue-gen"

# Create directories if they don't exist
mkdir -p "$PKG_OPT_DIR/scripts/init.d"

# Copy files to package directories
cd -

cp -v "target/issuegen-$PKG_VERSION.jar" "$PKG_OPT_DIR/issuegen-$PKG_VERSION.jar"
cp -rvf scripts/* "$PKG_OPT_DIR/scripts/"

# Check if preinst and postinst files exist in issue-gen directory
if [ -f "$PKG_DEBIAN_DIR/preinst" ]; then
    cp -v "$PKG_DEBIAN_DIR/preinst" "$PKG_OPT_DIR/preinst.sh"
else
    echo "WARNING: 'preinst' file not found."
fi

if [ -f "$PKG_DEBIAN_DIR/postinst" ]; then
    cp -v "$PKG_DEBIAN_DIR/postinst" "$PKG_OPT_DIR/postinst.sh"
else
    echo "WARNING: 'postinst' file not found."
fi

# Set permissions
chmod +x "$PKG_OPT_DIR/scripts/"*.sh  "$PKG_OPT_DIR/scripts/init.d/"*.sh 

chmod +x "$PKG_OPT_DIR/"*.sh  "$PKG_DEBIAN_DIR/preinst"  "$PKG_DEBIAN_DIR/postinst"

# Build Debian package
echo "Building the DEBIAN package..."
dpkg-deb --build "$PKG_DIR" "$BASEDIR/${PKG_NAME}_${PKG_VERSION}_all.deb"
echo "DEBIAN package is ready: ${PKG_NAME}_${PKG_VERSION}_all.deb"
