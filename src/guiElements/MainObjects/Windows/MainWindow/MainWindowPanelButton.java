package guiElements.MainObjects.Windows.MainWindow;

import dialog.Dialog;
import guiElements.Buttons.PanelButton;
import guiElements.MainObjects.Windows.Windows.Panel;

public class MainWindowPanelButton extends PanelButton{

	public MainWindowPanelButton(int posy, int posx, String body) {
		super(posy, posx, Panel.Height,Panel.Height, body);
	}

	@Override
	public void draw(Dialog dlg) {
		dlg.fill(255);
		dlg.triangle(this.getPosX(),this.getPosY(),
				 this.getPosX(),this.getPosY()+this.getHeight(),
				 this.getPosX()+this.getWidth(),this.getPosY());
		dlg.fill(200);
		dlg.triangle(this.getPosX()+this.getWidth(),this.getPosY()+this.getHeight(),
				 this.getPosX(),this.getPosY()+this.getHeight(),
				 this.getPosX()+this.getWidth(),this.getPosY());
		if (this.isFocussed(dlg)) {
			dlg.fill(220);
			if (dlg.clicked>0){
				this.ifClicked();
			}
		}
		else {
			dlg.fill(250);
		}
		dlg.rect(this.getPosX()+5,this.getPosY()+5,this.getWidth()-10,this.getHeight()-10);
		dlg.fill(0);
		dlg.text(this.getBody(),
				this.getPosX()+(int)(0.2*(this.getHeight())),
				this.getPosY()+(int)(0.6*this.getWidth()));
	}


}
