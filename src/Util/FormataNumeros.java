
package Util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;


public class FormataNumeros extends PlainDocument{

    @Override
    public void insertString(int i, String string, AttributeSet a) throws BadLocationException {
        
        super.insertString(i, string.replaceAll("[^0-9]", ""), a); //To change body of generated methods, choose Tools | Templates.
    }
           
}
