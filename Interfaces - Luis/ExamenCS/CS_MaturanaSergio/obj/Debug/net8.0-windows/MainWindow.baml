   M S B A M L   `   `   `  ����L  HCS_MaturanaSergio, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null5clr-namespace:CS_MaturanaSergioCS_MaturanaSergio  5   	   "    CS_MaturanaSergio.MainWindow   5   	   W SPresentationCore, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   1localclr-namespace:CS_MaturanaSergio     5   	     � Title$  
MainWindow��5   	   $	��450��6   $	��800��6)   .��5	      � ���	#FFF2A722 � 	Resources 5   
      PlantillaBotonRedondo �� 
TargetType��%�   &	        �� 5      " ��6<   .R�5      � .+�5      A� $��3q�6   
��� ���
�������$��3��6E   $��45��6Y   $��45��6e   (� 5      .��5      �� $��5q�6)   #��z��64   5      5      5      5       � ColumnDefinitions 5   
   �� 5      $��* �6   �� 5      $��* �6   �� 5      $��2* �6    � RowDefinitions 5   
   �� 5      $��* �6   �� 5      $��* �6   �� 5      $��* �6   �� 5      $��* �6   �� 5       $��* �6   .+�5"   
   �� -   5        $��textBoxPrecio��5#      $��Stretch=�5"      $��10q�60    �� 
IsReadOnly$
 True��5#   '   $��2��69   $��18(�6I   $��Stretch=�6W    �� TextAlignment$ Center=�6s   $��Center=�6�   �� 5$   
   -   5        $��textBoxImporte��5%      $��Stretch=�5$      $��6q�60   $
 True��5%   (   $��24(�6:   $��Stretch=�6H   $ Center=�6d   $��Center=�6{   $��2��6�   �� 5&   
   -   5        $��textBoxLitros��5'      $��Stretch=�5&      $��10q�60   $
 True��5'   '   $��1��69   $��24(�6F   $��Stretch=�6T   $ Center=�6p   $��Center=�6�   $��2��6�   �� 5(   
   -   5        $��buttonMas10��5*      #��[  5(      $	��+10��5)      $��2��5*   $   5+      �� 5,   
   -   5        $��
buttonMas1��5.      #��[  5,      $��+1��5-      $��2��5.   $   $��1��61   5/      �� 50   
   -   5        $��buttonIniciar��51      $��Iniciar��50      $��Stretch=�6#   $��5q�6A   $��2��51   '   $��2��64   ���	#FFE24B4B
�������$��18(�6�   d� 52   
   -   5        $��buttonDesColgar��53      $��	Descolgar��52      $��3��6+   $��10q�6?   $��3��53   )   $��18(�6~   �� 54   
   -   5        $��buttonSurtir��55      $��Surtir��54      $��3��6(   $��10q�6=    �� Delay$	 500��6I    �� Interval$ 1��6U   $��4��55   &   $��18(�63   6A   56      58      