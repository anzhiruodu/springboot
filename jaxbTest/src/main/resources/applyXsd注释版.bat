@ECHO OFF
SET OUT_DIR=..\java\Xml
SET TARGET_DIR=..\java
SET PKG_NAME=Xml
SET XSD_FILE=..\resources\world.xsd
@ECHO ON
//RMDIR删除，/S删除目录，/Q安静模式  RMDIR /S /Q %OUT_DIR% 删除 ..\java\Xml目录下的所有文件，
RMDIR /S /Q %OUT_DIR%
//-d指定目录， -p指定包名 -readOnly生成的文件将处于只读模式  -Xlocator 为生成的代码启用源位置支持
xjc -Xlocator -d %TARGET_DIR% -p %PKG_NAME% -encoding UTF-8 -readOnly %XSD_FILE%
PAUSE
