 int Trig = 2;   // Numer pinu wyzwolenia
    int Echo = 3;   // Numer pinu odpowiedzi
    
    int E1 = 5;  
    int M1 = 4; 
    int E2 = 6;                      
    int M2 = 7; 
   
     
    long EchoTime;  // Czas trwania sygna�u ECHO
    int  Distance;  // Odleg�o�� w centymetrach
    int  MaximumRange = 200; // Maksymalna odleg�o��
    int  MinimumRange = 2;   // Minimalna odleg�o��
     
    void setup()
    {
      // Inicjalizacja portu szeregowego
      Serial.begin(9600);
     
      // Konfiguracja pin�w
      pinMode(Trig, OUTPUT);
      pinMode(Echo, INPUT);
      
      
      pinMode(M1, OUTPUT);   
      pinMode(M2, OUTPUT); 
      
     
    }
     
    void loop()
    {
      
  int value; //oblsuga silnika
  for(value = 0 ; value <= 255; value+=5) 
  { 
    digitalWrite(M1,HIGH);   
    digitalWrite(M2, HIGH);       
    analogWrite(E1, value);   //PWM Speed Control
    analogWrite(E2, value);   //PWM Speed Control
    delay(30); 
  }  
      
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
     
      // Obliczamy odleg�o��
      Distance = EchoTime / 58;
     
      // Sprawdzamy zakres pomiarowy
      if (Distance >= MaximumRange || Distance <= MinimumRange)
      {
        Serial.println("Poza zakresem");  
      } else  
      {
       Serial.println(Distance);
      }
     
      // Op�nienie kolejnego pomiaru
      delay(100);
    }