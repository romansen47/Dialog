package interfaces;

import dialog.Dialog;

public interface Interaction {

	boolean isFocussed(Dialog dlg);
	
	default void ifClicked(){
		System.out.println("Jetzt in Interfaces.Interaction...");
	};
	
	void draw(Dialog dlg);
	
}
