   M S B A M L   `   `   `  ����O  KWpfApp_EstiloBotones, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null;"clr-namespace:WpfApp_EstiloBotonesWpfApp_EstiloBotones  5   	   %    WpfApp_EstiloBotones.MainWindow   5   	   W SPresentationCore, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   4local"clr-namespace:WpfApp_EstiloBotones     5   	     � Title$  
MainWindow��5   	   $	��450��6   $	��800��6)   .��5	      �  � Cursor$
 Hand��6   ��5
   
   
� 5      .��5      �  � Color$ Black��6    � Offset$ 0Q�6-   � 5      $ 	#FF38D8B7��6   $ 1Q�61   � 5      $ 	#FF436119��6   $ 0.277Q�61   � 5      $ 	#FF873D98��6   $ 0.663Q�61   5      .+�5   
   �� $��Botón 0��6   
������$��7q�5      $	��Top=�5      $��Center=�6)   �� 5   
   $��Botón 1��6   $	��100��6#   $��30��6/   ��5      �� 5       �� 
TargetType" ��6   .�5      ��  �� Property � �� �� Value
 �����63   �� 5       � ��
 �����64   �� 5       � ��
 �   �63   �� 5       � ��$ 1q�68   �� 5       � �� 5      �� 5       �� 
TargetType" ��6.   .R�5    "   �� #��z��5!   %   #��z��5"   %   #��z��5#   %    �� CornerRadius$ 6��5$   %   ._�5%   &   �� $��Center=�5&   )   $��Center=�5'   )   5(   #   5)      5+      	 �� Triggers	 5,      P� 5-      
 P� Property
 �@J�IsMouseOver P� Value$
 True��69   . �5.      ��  � ��
 �����6;   �� 5/       � ��
 �����6;   �� 50       � ��$ 3q�6@   �� 51       � ��
 � ���6<   �� 52       �@J�Effect 53   "   3  -System.Windows.Media.Effects.DropShadowEffect  54   &      
BlurRadius$ 50Q�67      	Direction$ 0Q�6G      Color$ LightYellow��6U   56      57      59      5;      �� 5<   
   $��Botón 2��6   $��Bottom=�5=      $��Right=�6,   $
 Hand��6H   ��5>      �� 5?      " ��6   .�5@      ��  � ��
 ��ح�63   �� 5A       � ��
 �����64   �� 5B       � ��
 �   �63   	 5C      P� 5D      
 �@J�IsMouseOver$
 True��69   . �5E      ��  � ��
 ����6;   �� 5F       � ��
 �����6;   �� 5G       � ��
 �  ��6<   �� 5H       � ��$ 3q�6@   5I      5K      5M      �� 5N   
   $��Botón 3��6   $
 Hand��5O      
�������
������  � OverridesDefaultStyle$
 True��5R      $��Center=�5S      $��Right=�6,   ��5T      �� 5U      " ��6"   .R�5V      �� $��3q�5W      #��z��5X      #��z��5Y      ._�5Z      �� $��Center=�5[      $��Center=�5\      5]      5^      5`      5a      5b      