echo off
set arg1=%~dp0%~1
set currentFolder=%~dp0
set astah_commandw="C:\Program Files\astah-uml\astah-commandw.exe"
set filename=Diagramas.asta
set imagesFolderName=\%filename:~0,-5%

@REM echo "Arquivo: " %arg1%
echo %imagesFolderName%

if "%~1"=="" goto :sem

:com
@REM Com argumento
echo Com argumento
@REM echo %astah_commandw% -image all -f "%arg1%" -o "%currentFolder%"
%astah_commandw% -image all -f "%arg1%" -o "%currentFolder%
goto fim

:sem
@REM Sem argumento
echo Sem argumento
@REM echo %astah_commandw% -image all -f "%currentFolder%Diagramas.asta" -o "%currentFolder%"
%astah_commandw% -image all -f "%currentFolder%%filename%" -o "%currentFolder%

:fim
set currentFolder=%currentFolder:~0,-1%
for %%f in (%currentFolder%) do set currentFolder=%%~nxf
echo Imagens salvas em: .\%currentFolder%%imagesFolderName%

pause