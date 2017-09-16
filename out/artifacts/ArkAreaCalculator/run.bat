SET jarFile=ArkAreaCalculator.jar
SET inFile=data.txt
SET outFile=out.txt

java -jar %jarFile% < %inFile% > %outFile%