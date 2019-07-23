#include "ArduinoNvs.h"
#include "WiFi.h"
#include "BluetoothSerial.h"

BluetoothSerial SerialBT;

// ASIGNACION DE PINES
const int pinConfig = 36;

void setup() {
  Serial.begin(115200);
  NVS.begin();
  // CONFIGURAR PINES COMO ENTRADAS
  pinMode(pinConfig, INPUT);
  Serial.println(digitalRead(pinConfig));
  if(!digitalRead(pinConfig)){
    Serial.println("Entrando en modo configuracion...");
    conexionBT();
    
  }
  Serial.println("Iniciando...");


  Serial.println();
  if (NVS.getString("stWifiName").c_str()=="Depto11"){Serial.println("==");}else{Serial.println("!=");}
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



void conexionBT(){
  uint8_t cont=0;
  String st[4]={"_","_","_","_"};
  String msj[4]={"Ingrese correo: ","Ingrese contraseña: ","Ingrese nombre de red: ","Ingrese contraseña de red: "};
  SerialBT.begin("ESP32test"); //Bluetooth device name
  Serial.println("Conecte su dispositivo");
  delay(10000);
  while(cont<4){
    SerialBT.println(msj[cont]);
    while(st[cont]=="_"){
      if (SerialBT.available()) {
        st[cont]=SerialBT.readStringUntil('\0');
      }
    }
    cont++;
  }
  guardarSettings(st[0],st[1],st[2],st[3]);
  Serial.println("Exito al configurar!");ESP.restart();
}



//guardado datos a eeprom
void guardarSettings(String stMail, String stUserPwd, String stWifiName, String stWifiPwd){
  if(!NVS.setString("stMail", stMail)){Serial.print("Error al guardar correo. Reiniciando...");delay(10000);ESP.restart();} //Correo electronico
  if(!NVS.setString("stUserPwd", stUserPwd)){Serial.print("Error al guardar contraseña usuario. Reiniciando...");delay(10000);ESP.restart();} //Contraseña de usuario
  if(!NVS.setString("stWifiName", stWifiName)){Serial.print("Error al guardar nombre de la red. Reiniciando...");delay(10000);ESP.restart();} //Nombre Wifi
  if(!NVS.setString("stWifiPwd", stWifiPwd)){Serial.print("Error al guardar contraseña de red. Reiniciando...");delay(10000);ESP.restart();} //Contraseña Wifi
}
