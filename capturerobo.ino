#include <stdio.h>
#include <stdlib.h>
#include <string.h>




int Trig = 2;   // Numer pinu wyzwolenia
int Echo = 3;   // Numer pinu odpowiedzi

int E1 = 5;  
int M1 = 4; 
int E2 = 6;                      
int M2 = 7; 


long EchoTime;  // Czas trwania sygnału ECHO
int  Distance;  // Odległość w centymetrach
int  MaximumRange = 200; // Maksymalna odległość
int  MinimumRange = 2;   // Minimalna odległość


void foreword()
{    

  int value = 255; //oblsuga silnika
  digitalWrite(M1,  LOW);   
  digitalWrite(M2, HIGH);       
  analogWrite(E1, value);   //PWM Speed Control
  analogWrite(E2, value);
  delay(500); 
}


void backword()
{

  int value = 200; //oblsuga silnika
  digitalWrite(M1, HIGH);   
  digitalWrite(M2, LOW);       
  analogWrite(E1, value);   //PWM Speed Control
  analogWrite(E2, value);
  delay(200); 

}


void turnright()
{

  int value = 255; //oblsuga silnika
  digitalWrite(M1, LOW);   
  digitalWrite(M2, HIGH);       
  analogWrite(E1, value);   //PWM Speed Control
  analogWrite(E2, 0);
  delay(300); 

}

void turnright2()
{

  int value = 255; //oblsuga silnika
  digitalWrite(M1, LOW);   
  digitalWrite(M2, HIGH);       
  analogWrite(E1, value);   //PWM Speed Control
  analogWrite(E2, 0);
  delay(200); 

}


void turnleft()
{    

  int value = 255; //oblsuga silnika
  digitalWrite(M1, LOW);   
  digitalWrite(M2, HIGH);       
  analogWrite(E1, 0);   //PWM Speed Control
  analogWrite(E2, value);
  delay(300);   
}

void turnleft2()
{    

  int value = 255; //oblsuga silnika
  digitalWrite(M1, LOW);   
  digitalWrite(M2, HIGH);       
  analogWrite(E1, 0);   //PWM Speed Control
  analogWrite(E2, value);
  delay(200);   
}


void stop()
{    

  digitalWrite(M1, LOW);   
  digitalWrite(M2, HIGH);       
  analogWrite(E1, 0);   //PWM Speed Control
  analogWrite(E2, 0);
  delay(200);     
}




void setup()
{
  // Inicjalizacja portu szeregowego
  Serial.begin(9600);

  // Konfiguracja pinów
  pinMode(Trig, OUTPUT);
  pinMode(Echo, INPUT);


  pinMode(M1, OUTPUT);   
  pinMode(M2, OUTPUT); 



}

void loop()
{ 

 


   // Ustawiamy TRIG w stan niski na 2us
  digitalWrite(Trig, LOW);
  delayMicroseconds(2);

  // Ustawiamy TRIG w stan wysoki na 10us
  digitalWrite(Trig, HIGH);
  delayMicroseconds(10);

  // Ustawiamy TRIG w stan niski - rozpoczynamy pomiar
  digitalWrite(Trig, LOW);

  // Odczytujamy czas trwania stanu wysokiego na pinie ECHO
  EchoTime = pulseIn(Echo, HIGH);

  // Obliczamy odległość
  Distance = EchoTime / 58;

   Serial.print(Distance);

 String c;

  c = Serial.readString();
  Serial.write(c.toInt());


  if(Distance<10){
   
  digitalWrite(M1, LOW);   
  digitalWrite(M2, HIGH);       
  analogWrite(E1, 0);   //PWM Speed Control
  analogWrite(E2, 0);
  }
  else{

    switch(c.toInt())
    {

    case 1 ... 256:
      turnleft2();
      stop();
      break;  

    case 257 ...  383:
      turnleft();
      stop();
      break;  

    case 384 ... 640:
      foreword();
      stop();
      break;  

    case 641 ... 767:
      turnright2();
      stop();
      break;  

    case 768 ... 1024:
      turnright();
      stop();
      break;  



    }
  }
}
