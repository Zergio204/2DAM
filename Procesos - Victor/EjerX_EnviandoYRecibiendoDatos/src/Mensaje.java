import java.io.Serializable;

public record Mensaje (String emisor, String mensaje) implements Serializable {}

/* 
 * - No se puede heredar.
 * - Atributos finales, por tantos constantes, por tanto 
 *   no se pueden modificar una vez creado el objeto
 * - Incluye los métodos get, toString, equals y hashCode
 * */
