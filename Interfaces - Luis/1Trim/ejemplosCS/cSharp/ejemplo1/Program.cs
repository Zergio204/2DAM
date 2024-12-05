// See https://aka.ms/new-console-template for more information
Console.Write("Hola colega, cómo te llamas? ");
String?  nombre=Console.ReadLine();
if (nombre==String.Empty){
    Console.WriteLine("es nulo");
}else{
    Console.WriteLine($"Hola {nombre.ToUpper()}, o {nombre}");
}