#!/bin/bash
#Purpose: This script will replace the environment variables in a webpage file of the application
#The webpage is used to differentiate deployment versions beween every rollout
#sed -i 's/Master/'\"$imgname-$BUILD_NUMBER\"'/g' ${WORKSPACE}/src/main/resources/static/issuegenerator.html

#/src/main/resources/testpage.html
#/src/main/resources/static/issuegenerator.html

sname=$(basename $BASH_SOURCE)
sdir=$(cd `dirname $BASH_SOURCE` && pwd)

echo "[Script: $sdir/$sname] Updating webpage content to include App_Ver, Color, and HostName"

#Container HostName
export CHOSTNAME=`cat /etc/hostname`
#export APPVER=v1.0 #This value comes from Container/Host env variable. Make sure to set it during deployment

#envsubst 

#cat test.txt 
#echo ---
#envsubst  < test.txt > test-updated.txt
#echo ---
#mv -v test-updated.txt test.txt
#cat test.txt

#Update the html files (testpage.html and issuegenerator.html) to differentiate deployment version
jar -xf issuegen-0.1.jar BOOT-INF/classes/testpage.html
envsubst  < BOOT-INF/classes/testpage.html > BOOT-INF/classes/testpage.html-updated
mv -v BOOT-INF/classes/testpage.html BOOT-INF/classes/testpage.html.orig
mv -v BOOT-INF/classes/testpage.html-updated BOOT-INF/classes/testpage.html
jar -uf issuegen-0.1.jar BOOT-INF/classes/testpage.html

#Update the html files (testpage.html and issuegenerator.html) to differentiate deployment version
jar -xf issuegen-0.1.jar BOOT-INF/classes/testpage.html
envsubst  < BOOT-INF/classes/testpage.html > BOOT-INF/classes/testpage.html-updated
mv -v BOOT-INF/classes/testpage.html BOOT-INF/classes/testpage.html.orig
mv -v BOOT-INF/classes/testpage.html-updated BOOT-INF/classes/testpage.html
jar -uf issuegen-0.1.jar BOOT-INF/classes/testpage.html

#Update the html file to differentiate deployment version
jar -xf issuegen-0.1.jar BOOT-INF/classes/static/issuegenerator.html
envsubst  < BOOT-INF/classes/static/issuegenerator.html > BOOT-INF/classes/static/issuegenerator.html-updated
mv -v BOOT-INF/classes/static/issuegenerator.html BOOT-INF/classes/static/issuegenerator.html.orig
mv -v BOOT-INF/classes/static/issuegenerator.html-updated BOOT-INF/classes/static/issuegenerator.html
jar -uf issuegen-0.1.jar BOOT-INF/classes/static/issuegenerator.html
