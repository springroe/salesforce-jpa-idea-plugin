/*******************************************************************************
 * @project: JAutoCompleteComboBox
 * @package: test
 * @file: JAutoCompleteComboBox.java
 * @author: zhangpei
 * @created: 2019-4-18
 * @purpose:
 * 
 * @version: 1.0
 * 
 * Revision History at the end of file.
 * 
 * Copyright 2019 esoon-tech All rights reserved.
 ******************************************************************************/
 
/**   
 * @Title: JAutoCompleteComboBox.java 
 * @Package test 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Burns[张沛]   
 * @date 2019-4-18 上午11:45:57 
 * @version V1.0   
 */
package io.github.springroe.intellij.salesforce.ui.widget;
 
/** 
 * @ClassName: JAutoCompleteComboBox 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Burns[张沛] 
 * @date 2019-4-18 上午11:45:57 
 *  
 */
 
import java.awt.event.ItemEvent;
 
import java.awt.event.ItemListener;
 
import java.awt.event.KeyEvent;
 
import java.awt.event.KeyListener;
 
import java.util.List;
 
import java.util.Vector;
 
import javax.swing.ComboBoxModel;
 
import javax.swing.DefaultComboBoxModel;
 
import javax.swing.JComboBox;
 
import javax.swing.JFrame;
 
import javax.swing.JTextField;
 
public class JAutoCompleteComboBox extends JComboBox {
 
	private AutoCompleter completer;
 
	public JAutoCompleteComboBox() {
		super();
		addCompleter();
	}
 
	public JAutoCompleteComboBox(ComboBoxModel cm) {
		super(cm);
		addCompleter();
	}
 
	public JAutoCompleteComboBox(Object[] items) {
		super(items);
		addCompleter();
	}
 
	public JAutoCompleteComboBox(List v) {
		super((Vector) v);
		addCompleter();
	}
 
	private void addCompleter() {
		setEditable(true);
		completer = new AutoCompleter(this);
	}
 
	public void autoComplete(String str) {
		this.completer.autoComplete(str, str.length());
	}
 
	public String getText() {
		return ((JTextField) getEditor().getEditorComponent()).getText();
	}
 
	public void setText(String text) {
		((JTextField) getEditor().getEditorComponent()).setText(text);
	}
 
	public boolean containsItem(String itemString) {
		for (int i = 0; i < this.getModel().getSize(); i++) {
			String _item = " " + this.getModel().getElementAt(i);
			if (_item.equals(itemString))
				return true;
		}
		return false;
	}
 
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Object[] items = new Object[] { "", "abc ", "aab ", "aba ", "hpp ",
				"pp ", "hlp " };
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		JComboBox cmb = new JAutoCompleteComboBox(model);
		model.addElement("");
		model.addElement("abc ");
		model.addElement("aab ");
		model.addElement("aba ");
		model.addElement("hpp ");
		model.addElement("pp ");
		model.addElement("hlp ");
		frame.getContentPane().add(cmb);
		frame.setSize(400, 80);
		frame.setVisible(true);
	}
}
 
/**
 * /****************************************************************************
 * *** <B>Revision History</B><BR>
 * [type 'revision' and press Alt + / to insert revision block]<BR>
 * 
 * 
 * 
 * Copyright 2019 esoon-tech All rights reserved.
 ******************************************************************************/