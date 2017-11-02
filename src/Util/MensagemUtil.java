package Util;

import java.awt.Component;

import javax.swing.JOptionPane;

public class MensagemUtil {
	
	public static void addMsg(Component component, String msg){
		JOptionPane.showMessageDialog(component, msg);
	}

}
