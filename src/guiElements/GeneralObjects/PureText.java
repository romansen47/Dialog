package guiElements.GeneralObjects;

import dialog.Dialog;
import guiElements.Buttons.Button;
import guiElements.MainObjects.Windows.Windows.Window;

public class PureText extends Button{

	public PureText(int posy,int posx,int height,int width,String body) {
		super(posy, posx, height, width, body);
	}
	
	@Override
	public void draw(Dialog dlg) {
		dlg.fill(0);
		dlg.text(this.getBody(),
				 this.getPosX()+(int)(0.1*this.getWidth()),
				 this.getPosY()+(int)(0.5*this.getHeight()));
	}
	
	@Override
	public void ifClicked() {
	}

}
