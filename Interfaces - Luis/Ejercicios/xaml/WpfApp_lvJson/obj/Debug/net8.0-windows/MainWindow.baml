   M S B A M L   `   `   `  ����H  DWpfApp_lvJson, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null-clr-namespace:WpfApp_lvJsonWpfApp_lvJson  5   	       WpfApp_lvJson.MainWindow   5   	   W SPresentationCore, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   -localclr-namespace:WpfApp_lvJson     5   	     � Title$  
MainWindow��5   	   $	��450��6   $	��800��6)    � DataContext 5	        WpfApp_lvJson.Datos  5
   
   .��5      �  � ColumnDefinitions 5   
   �� 5      $��* �6   �� 5      $��3* �6   .+�5   
   ��  6   ��  �� ElementName$ lvEquipo�� �� Path$ SelectedItem�.+�5      �� -   5         ��Name$ Nombre��5      ��6(   �� *Nombre+�� 5      -   5        $ Puesto��5      ��6(   �� *Puesto+5      �� 5   
   -   5         ��Name$ lvEquipo��5      $��1��6%   ��65   �� *
Personajes+ �� View 5      �� 5      .P�5      �� $
��Foto��6%    �� Width$	 100��63   	 �� CellTemplate	 5      �� 5      .R�5   "   �� $��2q�6)   
 �� CornerRadius$
 18��6=   
���   �._�5   &   �� $��8q�5   ,   $	��100��5   ,   $	��100��5    ,   ��5   ,   �� *Foto+5    ,   5!   #   5"      5$      �� 5%      $��Nombre��6%   	 5&      �� 5'      .R�5(   "   �� $��Center=�6,   $��12q�5)   ,   
����  ���5+   ,   �� *Nombre+ J� Effect 5,   &   3  -System.Windows.Media.Effects.DropShadowEffect  5-   *      
BlurRadius$ 3Q�6;      ShadowDepth$ 1Q�5.   ;   50   #   51      53      �� 54      $��Puesto��6%   	 55      �� 56      .R�57   "   �� $��Center=�6,   $��12q�58   ,   $��Italic$�5:   ,   ��59   ,   �� *Nombre+5;   #   5<      5>      5?      5A      5B      5C      