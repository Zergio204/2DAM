// See https://aka.ms/new-console-template for more information
using System;
//Muestra un mensaje de saludo Buenos días o Buenas tardes en función de si son más de las 14h (compruébalo).
//Debe saludar al usuario logeado, p.e.: Buenos días jorgarma 
DateTime ahora = DateTime.Now;
if (ahora.Hour > 14){
    Console.WriteLine($"Buenas tardes {Environment.UserName}");
}else{
    Console.WriteLine($"Buenos días {Environment.UserName}");
}

//Muestra el mensaje Son las hh:mm del dd/mm/aa
Console.WriteLine($"Son las {ahora.Hour}:{ahora.Minute} del {ahora.Day}/{ahora.Month}/{ahora.Year}");

//Acepta una frase por consola (Console.ReadLine)
Console.WriteLine("Escribe una frase:");
String frase = Console.ReadLine();

//Muestra cada letra de la frase en una línea distinta
for (int i = 0; i < frase.Length; i++){
    char c = frase[i];
    Console.WriteLine(c);
}

//Muestra la frase invertida (p.e. iba caperucita por el bosque -> euqsob le rop aticurepac abi)
for (int j = frase.Length +1; j==0; j--){
    char c = frase[j];
    Console.Write(c);
}

//Muestra el número de palabras de la frase
int conteo=0;

for (int i = 0; i < frase.Length; i++){
    char c = frase[i];
    if (c == ' '){
        conteo++;
    }
}
Console.WriteLine($"Hay: {conteo + 1} palabras");