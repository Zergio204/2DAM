   M S B A M L   `   `   `  ����P  LWpfAppPlantillaListas, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null=#clr-namespace:WpfAppPlantillaListasWpfAppPlantillaListas  5   	   &     WpfAppPlantillaListas.MainWindow   5   	   W SPresentationCore, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   5local#clr-namespace:WpfAppPlantillaListas     5   	     � Title$  
MainWindow��5   	   $	��450��6   $	��800��6)    � 	Resources 5	         ct1 �� 
TargetType �� CornerRadius K� IsItemsHost  estiloListBoxItem �� 
TargetType �� Property �� Value ��Name	 �� Padding
 �� Triggers P� Property P� Value �� 
TargetName3  -System.Windows.Media.Effects.DropShadowEffect   
BlurRadius   ShadowDepth��%G  &	        &	 �     �� 5
   
   " ��6&   .R�5      �� 
��� ���$ 20��6)   $��3q�6;   
�������._�5      �� $��10q�6   $
��Auto=�6+   .��5      �� $��0q�6!   $
 True��6,   5      5      5      �� 5   
   " ��6*   .�5      ��  � �� 5      �� 5      " ��6&   .R�5      �� $ borde��6!   $��Stretch=�60   $��2q�5   !   $	 10q�5   !   
������$ 6��5   !   ._�5      �� 5      
 5      P� 5       �@J�IsMouseOver$
 True��6=   . �5   "   �� $ borde��6)    � ��
 ��ح�6R   5      P� 5        �@��
IsSelected$
 True��6<   . �5!   "   �� $ borde��6)    �@J�Effect 5"   &     5#   *   $ 7Q�6;   $ 3Q�6J   5%   #   �� 5&   "   $ borde��6)    � ��
 ��ح�6R   5'      5)      5+      5,      5-      .��5.      �  � ColumnDefinitions 5/   
   �� 50      $��* �6   �� 51      $��* �6   .+�53   
   �� -   5         ��Name$ 	imageFoto��53      $
��None=�6#   ��54      ��  �� ElementName$ listBoxPersonas�� �� Path$ SelectedItem.Foto��� 55   
   -   5         ��Name$ listBoxPersonas��55      $��1��58      $��10q�6"   #��[  59      #��[ 5:      
����ح���56      �� *
Personas+��5=      �� 5>      .R�5?      ��  �� Orientation$ 
Horizontal=�6!   .+�5A      A� $��64��6"   $��64��6-   $��Center=�5B   "   $��Center=�5C   "   
�������$��3��5D   0   ��5E      �� 5F   "    �� ImageSource 6-   �� *Foto+5H      �� 5I      $��Center=�6$   $��12q�6?   
���  ����5K   ,   �� *Nombre+ J� Effect 5L        5M   "   $ 3Q�63   $ 1Q�6B   5O      5P      5Q      5S      �� 5T   
   $��Bottom=�6   $��Right=�6,   $��24(�5U      $
��10,5q�6   $��20q�6.   $��1��5W      
������$��+��5X      ��5V      �� *
AddCommand+5X      5Y      5Z      