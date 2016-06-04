#include <stdio.h>
#include <setjmp.h>
#include <Thread.h>

#define TRY do{ jmp_buf ex_buf__; if( !setjmp(ex_buf__) ){
#define CATCH } else {
#define ETRY } }while(0)
#define THROW longjmp(ex_buf__, 1)
  
    Thread myThread = Thread();
  
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
    
   void check_line()
{
	
	






} 
    void foreword()
    {    
        // for(int i=0;i<20;i++){
    int value = 255; //oblsuga silnika
    digitalWrite(M1, HIGH);   
    digitalWrite(M2, LOW);       
    analogWrite(E1, value);   //PWM Speed Control
    analogWrite(E2, value);
 //}  
}
    
    
     void backword()
    {
         // for(int i=0;i<20;i++){
  int value = 255; //oblsuga silnika
    digitalWrite(M1, LOW);   
    digitalWrite(M2, HIGH);       
    analogWrite(E1, value);   //PWM Speed Control
    analogWrite(E2, value);
// } 
     }
    
    
     void turnright()
    {
     //  for(int i=0;i<20;i++){
  int value = 255; //oblsuga silnika
    digitalWrite(M1, HIGH);   
    digitalWrite(M2, LOW);       
    analogWrite(E1, 0);   //PWM Speed Control
    analogWrite(E2, value);
 //}  
    }
    
     
      void turnleft()
    {    
  int value = 255; //oblsuga silnika
    digitalWrite(M1, LOW);   
    digitalWrite(M2, HIGH);       
    analogWrite(E1, value);   //PWM Speed Control
    analogWrite(E2, 0);
// }      
    }
    
         void stop()
    {    
 
    digitalWrite(M1, LOW);   
    digitalWrite(M2, HIGH);       
    analogWrite(E1, 0);   //PWM Speed Control
    analogWrite(E2, 0);
// }      
    }
    
    
    void sonar()
    {
      
          //obsluga czujnika
      
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
     
      // Sprawdzamy zakres pomiarowy
      if (Distance >= MaximumRange || Distance <= MinimumRange)
      {
        Serial.println("Poza zakresem");  
      } 
      
      if(Distance<=10){
       digitalWrite(M1, HIGH);   
       digitalWrite(M2, LOW);       
       analogWrite(E1, 0);   //PWM Speed Control
       analogWrite(E2, 0);
      }
      else  
      {
       Serial.println(Distance);
      }
     
      // Opóźnienie kolejnego pomiaru
      delay(100);
      
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
      
      myThread.onRun(sonar);
    //  myThread.setInterval(500);
     
    }
     
    void loop()
    { 
      
       if(myThread.shouldRun())
		myThread.run();
        char c;
      //    if(Serial.available())  
//  {  
   
  c = Serial.read(); 
int i=0;
while(c[i]!='$')
{
message[i] = c[i];
i++;

}	  
int n = atoi(massage);

  switch(n)
  {
    case '1':
    foreword();
    break;
    
    
    case '2':
    backword();
    break;
    
    
    case '3':
    turnright();
    break;
    
    
    case '4':
    turnleft();
    break;
    
    
    case '5':
    stop();
    break;
    	
    case(x<450 && x>400):
    foreword();
    break;		

    default:
    check_line();
    
  }
  
      
 //   }
    
    }
    

