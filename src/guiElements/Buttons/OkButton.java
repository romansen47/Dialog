package guiElements.Buttons;

import dialog.Dialog;
import guiElements.MainObjects.Windows.Windows.Window;

public class OkButton extends Button{
	public OkButton(Window wnd ,int posy, int posx, int height, int width) {
		super(posy, posx, height, width, "Ok");
	}
	@Override
	public void ifClicked() {}
	
	@Override
	public void draw(Dialog dlg) {
		super.draw(dlg);
	}
}