   M S B A M L   `   `   `  ����M  IWpfApp_ListaLibros, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null7 clr-namespace:WpfApp_ListaLibrosWpfApp_ListaLibros  5   	   #    WpfApp_ListaLibros.MainWindow   5   	   W SPresentationCore, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   2local clr-namespace:WpfApp_ListaLibros     5   	     � Title$  
MainWindow��5   	   $	��450��6   $	��800��6)   .��5	      � .+�5
   
   �� -   5        $��lvResultados��5
      
������ �� View 5      �� 5      .P�5      �� $
��ISBN��6%    �� Width$
 Auto��63    �� DisplayMemberBinding 5   %   �� *ISBN+�� 5      $��Título��6%   $
 Auto��65    5   %   �� *Titulo+�� 5      $��Autor��6%   $
 Auto��64    5   %   �� *Autor+�� 5      $��Precio��6%   $
 Auto��65    5   %   �� *Precio+ �� StringFormat$ {0:C}�� �� ConverterCulture$ es-ES��5       �� 
GroupStyle 5      (  "System.Windows.Controls.GroupStyle  5         HeaderTemplate 5      �� 5      .R�5      �� $
��Bold"�6(   $��14(�6:   ��6H   �� *Name+5      5      5       5#      5$      