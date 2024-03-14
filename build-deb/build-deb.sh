BASEDIR=$(dirname "$0")
echo "../$BASEDIR"
pwd
cd -

# Workspace: issue-generator git repository local
cp -v target/issuegen-0.1.jar issue-gen/opt/apps/issue-gen/issuegen-0.1.jar

# Copy scripts to package
cp -rv -f  scripts/ issue-gen/opt/apps/issue-gen/
chmod +x issue-gen/opt/apps/issue-gen/scripts/*.sh
chmod +x issue-gen/opt/apps/issue-gen/scripts/init.d/*.sh

# Package
#pwd
cp -v issue-gen/DEBIAN/preinst issue-gen/opt/apps/issue-gen/preinst.sh
cp -v issue-gen/DEBIAN/postinst issue-gen/opt/apps/issue-gen/postinst.sh

chmod +x issue-gen/DEBIAN/preinst
chmod +x issue-gen/DEBIAN/postinst
chmod +x issue-gen/opt/apps/issue-gen/*.sh

echo "Started deb to install ...."
dpkg-deb --build issue-gen
echo "Installation Completed ......."
