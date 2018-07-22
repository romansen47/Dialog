package guiElements.MainObjects.Windows.Windows;

import dialog.Dialog;
import guiElements.GeneralObjects.GuiElement;
import guiElements.MainObjects.Windows.MainWindow.MainPanelExitButton;

public class CloseButton extends MainPanelExitButton{

	public CloseButton() {
		super();
	}
	
	@Override
	public void ifClicked() {
		this.getDlg().getMain().remove((GuiElement)(this.getPnl().getWnd()));
		this.getDlg().getMain().getBottomPanel().remove(this.getWnd());
	}

	@Override
	public void draw(Dialog dlg) {
		if (this.isFocussed(dlg)) {
			dlg.fill(220);
			if (dlg.clicked>0){
				this.ifClicked();
			}
		}
		else {
			dlg.fill(250);
		}
		dlg.rect(this.getPosX(),this.getPosY(),this.getWidth(),this.getHeight(),20);
		dlg.fill(0);
		dlg.text(this.getBody(),
				this.getPosX()+(int)(0.2*(this.getHeight())),
				this.getPosY()+(int)(0.6*this.getWidth()));
	}
}