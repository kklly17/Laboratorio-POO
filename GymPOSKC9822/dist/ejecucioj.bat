@echo off
echo Iniciando Sistema GymPOS...
echo Cargando librerias graficas...

java -Djava.library.path="lib_externa" --module-path "lib_externa" --add-modules javafx.controls,javafx.fxml -jar "GymPOSKC9822.jar"

echo.
pause