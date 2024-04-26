#!/bin/bash

# Define variables
BASEDIR=$(dirname "$0")
PKG_NAME="issuegen"
PKG_VERSION="0.1"
#DEB_REVISION="3"
PKG_DIR="$BASEDIR/issue-gen"
PKG_DEBIAN_DIR="$PKG_DIR/DEBIAN"
PKG_OPT_DIR="$PKG_DIR/opt/apps/issue-gen"

#if [ -n "$BUILD_NUMBER" ]; then
#    PKG_VERSION="$PKG_VERSION-$BUILD_NUMBER"
#fi

# Create directories if they don't exist
mkdir -p "$PKG_OPT_DIR/scripts/init.d"

# Copy files to package directories
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

if [ -n "$BUILD_NUMBER" ]; then
    PKG_VERSION="$PKG_VERSION-$BUILD_NUMBER"
fi

#Changing the Version
sed -i 's/Version: .*xxx/Version: '$PKG_VERSION'/g' $PKG_DEBIAN_DIR/control

# Set permissions
chmod +x "$PKG_OPT_DIR/scripts/"*.sh "$PKG_OPT_DIR/scripts/init.d/"*.sh 2> /dev/null
chmod +x "$PKG_OPT_DIR/"*.sh "$PKG_DEBIAN_DIR/"*.sh 2> /dev/null

#VERSION=$((DEB_REVISION + 1))

# Build Debian package
echo "Building the DEBIAN package..."

dpkg-deb --build "$PKG_DIR" "$BASEDIR/${PKG_NAME}_${PKG_VERSION}_all.deb"
echo "DEBIAN package is ready: ${PKG_NAME}_${PKG_VERSION}_all.deb"
debpack=$(echo "DEBIAN package is ready: ${PKG_NAME}_${PKG_VERSION}_all.deb")
echo $debpack
ver=$(echo $debpack | awk -F ':' '{print $2}')
echo $ver
