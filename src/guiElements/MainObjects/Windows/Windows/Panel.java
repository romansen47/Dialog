package guiElements.MainObjects.Windows.Windows;

import dialog.Dialog;
import guiElements.GeneralObjects.GuiElement;
import guiElements.MainObjects.Windows.MainWindow.MainPanelExitButton;

public class Panel extends GuiElement {
	
	public static int Height=50;
	private MainPanelExitButton ExitButton;
	private Window wnd;
	
	public Panel(int posy, int posx,int width) {
		
		super(posy,posx,Height,width);
		ExitButton=new CloseButton();
		ExitButton.setPosX(posx+width-Height);
		ExitButton.setPosY(posy);
		ExitButton.setPnl(this);
		
		this.add(ExitButton);
	}
	
	public MainPanelExitButton getExitButton() {
		return this.ExitButton;
	}
	public void setExitButton(MainPanelExitButton exit) {
		this.ExitButton=exit;
	}
	
	@Override
	public boolean isFocussed(Dialog dlg) {
		if (	dlg.mouseY<this.getPosY()+Height && 
				dlg.mouseX<this.getPosX()+this.getWidth() && 
				dlg.mouseY>=this.getPosY() &&
				dlg.mouseX>=this.getPosX() ) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public void ifClicked() {
	}
	
	@Override
	public void draw(Dialog dlg) {
		if (isFocussed(dlg)) {
			dlg.fill(100);
		}
		else {
			dlg.fill(180);
		}
		dlg.rect(this.getPosX(),this.getPosY(),this.getWidth(),this.getHeight());
		super.draw(dlg);
	}

	@Override
	public void setDlg(Dialog dlg) {
		super.setDlg(dlg);
		for (GuiElement el:this.getElements()) {
			el.setDlg(dlg);
		}
	}
	
	public Window getWnd() {
		return wnd;
	}

	public void setWnd(Window wnd) {
		this.wnd=wnd;
	}

}
