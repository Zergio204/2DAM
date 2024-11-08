using System.Runtime.CompilerServices;

namespace baraja;

class Program
{
    static readonly string[] valores = ["As", "2", "3", "4", "5", "6", "7", "sota", "caballo", "rey"];
    static readonly string[] palos = ["bastos", "copas", "espadas", "oros"];
    static List<string> cartas = new List<string>();
    static void Main(string[] args)
    {
        cartas = CrearBaraja(valores, palos);
        //MostrarBaraja(cartas);
       
        Desordenar(cartas);
       
        //MostrarBaraja(cartas);
        string[,] mano = Repartir(cartas);
        MostrarMano(mano);
    }

    static List<string> CrearBaraja(string[] valores, string[] palos)
    {
        List<string> cartas = new List<string>();
        for (int i = 0; i < palos.Length; i++)
        {
            for (int j = 0; j < valores.Length; j++)
            {
                cartas.Add($"{valores[j]} de {palos[i]}");
            }
        }
        return cartas;
    }
    static void MostrarBaraja(List<string> cartas)
    {
        foreach (var item in cartas)
        {
            Console.WriteLine(item);
        }
    }

    static List<string> Desordenar(List<string> cartas)
    {
        var random = new Random();
        for (int i = cartas.Count - 1; i > 0; i--)
        {
            int j = random.Next(0, i + 1);
            (cartas[j], cartas[i]) = (cartas[i], cartas[j]);
        }
        return cartas;
    }

    static string[,] Repartir(List<string> cartas)
    {
        string[,] mano = new string[4, 4]; //[jugador,carta]
        int n = 0;
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                mano[j, i] = cartas[n++];
            }
        }
        return mano;
    }

    static void MostrarMano(string[,] mano)
    {
        for (int j = 0; j < 4; j++)
        {
            Console.Write($"Jugador-{j + 1}: ");
            for (int i = 0; i < 4; i++)
            {
                Console.Write($"{mano[j, i]}{(i < 3 ? "," : ".")} ");
            }
            Console.WriteLine();
        }
    }
}
