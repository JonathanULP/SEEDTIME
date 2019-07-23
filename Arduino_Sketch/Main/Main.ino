#include "ArduinoNvs.h"
#include "WiFi.h"

String stMail, stUserPwd, stWifiName, stWifiPwd;

void setup() {
  Serial.begin(115200);
  NVS.begin();
  
  //leer datos
  //bluetoth
  
  WiFi.mode(WIFI_STA);
  WiFi.begin(NVS.getString("stWifiName").c_str(),NVS.getString("stWifiPwd").c_str()); //Se leen WifiName y WifiPwd de la EEPROM
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
 }
 Serial.println("");
 Serial.println("WiFi connected");
 Serial.println("IP address: ");
 Serial.println(WiFi.localIP());
}


void loop() {
    


    
}

//lectura de datos de configuracion
void configurarSettings(){
  //lectura de datos
  Serial.print("\n Ingrese su correo: ");
  Serial.setTimeout(8000);
  stMail=Serial.readString();
  Serial.print("\n Ingrese su contraseña de usuario: ");
  Serial.setTimeout(8000);
  stUserPwd=Serial.readString();
  Serial.print("\n Ingrese el nombre de su red: ");
  Serial.setTimeout(8000);
  stWifiName=Serial.readString();
  Serial.print("\n Ingrese la contraseña de su red: ");
  Serial.setTimeout(8000);
  stWifiPwd=Serial.readString();
}

//guardado datos a eeprom
void guardarSettings(){
  if(!NVS.setString("stMail", stMail)){Serial.print("Error al guardar correo. Reiniciando...");delay(10000);ESP.restart();} //Correo electronico
  if(!NVS.setString("stUserPwd", stUserPwd)){Serial.print("Error al guardar contraseña usuario. Reiniciando...");delay(10000);ESP.restart();} //Contraseña de usuario
  if(!NVS.setString("stWifiName", stWifiName)){Serial.print("Error al guardar nombre de la red. Reiniciando...");delay(10000);ESP.restart();} //Nombre Wifi
  if(!NVS.setString("stWifiPwd", stWifiPwd)){Serial.print("Error al guardar contraseña de red. Reiniciando...");delay(10000);ESP.restart();} //Contraseña Wifi
}
