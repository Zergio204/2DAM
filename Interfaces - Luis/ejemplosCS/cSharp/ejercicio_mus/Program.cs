// See https://aka.ms/new-console-template for more information
List<string> valores = new List<string>{"as", "dos", "tres", "cuatro", "cinco", "seis", "siete", "sota", "caballo", "rey"};
List<string> palos = new List<string>{"Copas", "Bastos", "Espadas", "Oros"};

//Generar baraja completa ordenada
List<string> baraja = new List<string>{};

for (int i = 0; i<=palos.Count-1;i++){
    for (int j = 0; j<=valores.Count-1;j++) {
        baraja.Add($"{valores[j]} de {palos[i]}");
    }
}

//Mostrar baraja ordenada
Console.WriteLine("BARAJA ORDENADA");
for (int i = 0;i <= baraja.Count-1;i++){
    Console.WriteLine(baraja[i]);
}

List<string> barajaDesordenada = new List<string>{};

//Desordenar baraja
Random r = new Random();
for (int i = 0; i <= baraja.Count-1; i++){
    var numeroAleatorio=r.Next(40);
    barajaDesordenada.Add(baraja[numeroAleatorio]);
}

//Mostrar baraja desordenada
Console.WriteLine("");
Console.WriteLine("BARAJA DESORDENADA");
for (int i = 0; i < barajaDesordenada.Count; i++){
    Console.WriteLine(barajaDesordenada[i]);
}

//Extraer 4 cartas para cada uno de los 4 jugadores

