/*******************************************************************************
 * @project: JAutoCompleteComboBox
 * @package: test
 * @file: AutoCompleter.java
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
 * @Title: AutoCompleter.java 
 * @Package test 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Burns[张沛]   
 * @date 2019-4-18 上午11:47:00 
 * @version V1.0   
 */
package io.github.springroe.intellij.salesforce.ui.widget;
 
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Vector;
 
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
 
/** 
 * @ClassName: AutoCompleter 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Burns[张沛] 
 * @date 2019-4-18 上午11:47:00 
 *  
 */
/**
 * 自动完成器。自动找到最匹配的项目，并排在列表的最前面。
 * 
 * @author Turbo Chen
 */
class AutoCompleter implements KeyListener, ItemListener {
 
	private JComboBox owner = null;
	private JTextField editor = null;
	private ComboBoxModel model = null;
 
	public AutoCompleter(JComboBox comboBox) {
		owner = comboBox;
		editor = (JTextField) comboBox.getEditor().getEditorComponent();
		editor.addKeyListener(this);
		model = comboBox.getModel();
 
		owner.addItemListener(this);
	}
 
	public void keyTyped(KeyEvent e) {
	}
 
	public void keyPressed(KeyEvent e) {
	}
 
	public void keyReleased(KeyEvent e) {
		char ch = e.getKeyChar();
		if (ch == KeyEvent.CHAR_UNDEFINED || Character.isISOControl(ch)
				|| ch == KeyEvent.VK_DELETE)
			return;
 
		int caretPosition = editor.getCaretPosition();
		String str = editor.getText();
		if (str.length() == 0)
			return;
		autoComplete(str, caretPosition);
	}
 
	/**
	 * 自动完成。根据输入的内容，在列表中找到相似的项目.
	 */
	protected void autoComplete(String strf, int caretPosition) {
		Object[] opts;
		opts = getMatchingOptions(strf.substring(0, caretPosition));
		if (owner != null) {
			model = new DefaultComboBoxModel(opts);
			owner.setModel(model);
		}
		if (opts.length > 0) {
			String str = opts[0].toString();
			editor.setCaretPosition(caretPosition);
			if (owner != null) {
				try {
					owner.showPopup();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
 
	/**
	 * 
	 * 找到相似的项目, 并且将之排列到数组的最前面。
	 * 
	 * @param str
	 * @return 返回所有项目的列表。
	 */
	protected Object[] getMatchingOptions(String str) {
		List v = new Vector();
		List v1 = new Vector();
 
		for (int k = 0; k < model.getSize(); k++) {
			Object itemObj = model.getElementAt(k);
			if (itemObj != null) {
				String item = itemObj.toString().toLowerCase();
				if (item.startsWith(str.toLowerCase()))
					v.add(model.getElementAt(k));
				else
					v1.add(model.getElementAt(k));
			} else
				v1.add(model.getElementAt(k));
		}
		for (int i = 0; i < v1.size(); i++) {
			v.add(v1.get(i));
		}
		if (v.isEmpty())
			v.add(str);
		return v.toArray();
	}
 
	public void itemStateChanged(ItemEvent event) {
		if (event.getStateChange() == ItemEvent.SELECTED) {
			int caretPosition = editor.getCaretPosition();
			if (caretPosition != -1) {
				try {
					editor.moveCaretPosition(caretPosition);
				} catch (IllegalArgumentException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}
 
/*******************************************************************************
 * <B>Revision History</B><BR>
 * [type 'revision' and press Alt + / to insert revision block]<BR>
 * 
 * 
 * 
 * Copyright 2019 esoon-tech All rights reserved.
 ******************************************************************************/