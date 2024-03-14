BASEDIR=$(dirname "$0")
echo "../$BASEDIR"
pwd
cd -

# Workspace: issue-generator git repository local
cp -v target/issuegen-0.1.jar $BASEDIR/issue-gen/opt/apps/issue-gen/issuegen-0.1.jar

echo "copy test ........"
# Copy scripts to package
cp -rv -f  scripts/  $BASEDIR/issue-gen/opt/apps/issue-gen/
chmod +x $BASEDIR/issue-gen/opt/apps/issue-gen/scripts/*.sh
chmod +x $BASEDIR/issue-gen/opt/apps/issue-gen/scripts/init.d/*.sh

# Package
#pwd
cp -rv $BASEDIR/issue-gen/DEBIAN/preinst  $BASEDIR/issue-gen/opt/apps/issue-gen/preinst.sh
cp -rv $BASEDIR/issue-gen/DEBIAN/postinst $BASEDIR/issue-gen/opt/apps/issue-gen/postinst.sh

chmod +x $BASEDIR/issue-gen/DEBIAN/preinst
chmod +x $BASEDIR/issue-gen/DEBIAN/postinst
chmod +x $BASEDIR/issue-gen/opt/apps/issue-gen/*.sh

echo "Started deb to install ...."
dpkg-deb --build issue-gen
echo "Installation Completed ......."
