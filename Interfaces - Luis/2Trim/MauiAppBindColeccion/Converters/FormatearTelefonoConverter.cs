using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MauiAppBindColeccion.Converters
{
    public class FormatearTelenofoConverter : IValueConverter
    {
        public object Convert(object value, Type targetType, object parameter, CultureInfo culture)
        {
            if (value is string phoneNumber && phoneNumber.Length == 10)
            {
                return $"({phoneNumber.Substring(0, 3)}) {phoneNumber.Substring(3, 3)}-{phoneNumber.Substring(6, 2)}-{phoneNumber.Substring(8, 2)}";
            }
            return value;
        }

        public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)
        {
            //// Para convertir el formato mostrado de vuelta al original.
            //if (value is string formattedPhone)
            //{
            //    return new string(formattedPhone.Where(char.IsDigit).ToArray());
            //}
            //return value;
            throw new NotImplementedException();

        }
    }
}
