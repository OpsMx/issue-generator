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
cp -v "target/issuegen-$PKG_VERSION.jar" "$PKG_OPT_DIR/issuegen-$PKG_VERSION.jar"
cp -rvf scripts/* "$PKG_OPT_DIR/scripts/"
cp -v DEBIAN/preinst "$PKG_OPT_DIR/preinst.sh"
cp -v DEBIAN/postinst "$PKG_OPT_DIR/postinst.sh"

# Set permissions
chmod +x "$PKG_OPT_DIR/scripts/"*.sh "$PKG_OPT_DIR/scripts/init.d/"*.sh "$PKG_DEBIAN_DIR/"*.sh

# Build Debian package
echo "Preparing the DEBIAN package..."
dpkg-deb --build "$PKG_DIR" "$BASEDIR/${PKG_NAME}_${PKG_VERSION}_all.deb"
echo "DEBIAN package is ready: ${PKG_NAME}_${PKG_VERSION}_all.deb"
