   M S B A M L   `   `   `  ����P  LWpfAppPlantillaListas, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null=#clr-namespace:WpfAppPlantillaListasWpfAppPlantillaListas  5   	   &     WpfAppPlantillaListas.MainWindow   5   	   W SPresentationCore, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   5local#clr-namespace:WpfAppPlantillaListas     5   	     � Title$  
MainWindow��5   	   $	��450��6   $	��800��6)    � DataContext 5	      /   )WpfAppPlantillaListas.MainWindowViewModel  5
   
    � 	Resources 5         ct1 �� 
TargetType �� CornerRadius K� IsItemsHost  estiloListBoxItem �� 
TargetType �� Property �� Value	 ��Name
 �� Padding �� Triggers P� Property P� Value �� 
TargetName3  -System.Windows.Media.Effects.DropShadowEffect   
BlurRadius   ShadowDepth��%G  &	        &	 �     �� 5   
   " ��6&   .R�5      �� 
��� ���$ 20��6)   $��3q�6;   
�������._�5      �� $��10q�6   $
��Auto=�6+   .��5      �� $��0q�6!   $
 True��6,   5      5      5      �� 5   
   " ��6*   .�5      ��  � �� 5      �� 5      " ��6&   .R�5      �� $	 borde��6!   $��Stretch=�60   $��2q�5   !   $
 10q�5   !   
������$ 6��5   !   ._�5      �� 5       5      P� 5        �@J�IsMouseOver$
 True��6=   . �5!   "   �� $ borde��6)    � ��
 ��ح�6R   5"      P� 5#       �@��
IsSelected$
 True��6<   . �5$   "   �� $ borde��6)    �@J�Effect 5%   &     5&   *   $ 7Q�6;   $ 3Q�6J   5(   #   �� 5)   "   $ borde��6)    � ��
 ��ح�6R   5*      5,      5.      5/      50      .��51      �  � ColumnDefinitions 52   
   �� 53      $��* �6   �� 54      $��* �6   .+�56   
   �� -   5         ��Name$ 	imageFoto��56      $
��None=�6#   ��57      ��  �� ElementName$ listBoxPersonas�� �� Path$ SelectedItem.Foto��� 58   
   -   5         ��Name$ listBoxPersonas��58      $��1��5;      $��10q�6"   #��[  5<      #��[ 5=      
����ح���59      �� *
Personas+��5@      �� 5A      .R�5B      ��  �� Orientation$ 
Horizontal=�6!   .+�5D      A� $��64��6"   $��64��6-   $��Center=�5E   "   $��Center=�5F   "   
�������$��3��5G   0   ��5H      �� 5I   "    �� ImageSource 6-   �� *Foto+5K      �� 5L      $��Center=�6$   $��12q�6?   
���  ����5N   ,   �� *Nombre+ J� Effect 5O        5P   "   $ 3Q�63   $ 1Q�6B   5R      5S      5T      5V      �� 5W   
   $��Bottom=�6   $��Right=�6,   $��24(�5X      $
��10,5q�6   $��20q�6.   $��1��5Z      
������$��+��5[      ��5Y      �� *
AddCommand+5[      5\      5]      