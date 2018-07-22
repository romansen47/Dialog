package guiElements.GeneralObjects;

import dialog.Dialog;
import guiElements.MainObjects.Windows.Windows.Window;
import interfaces.Interaction;
import processing.core.PConstants;

public class TextEntry extends GuiElement implements Interaction{

	private Dialog dlg;
	private String Entry;
	PureText Text;
	
	public TextEntry(int posy, int posx, int height, int width,String text) {
		super(posy, posx, height, width);
		this.Text=new PureText(posy, posx,height,(int)(width*0.5),text);
		this.setEntry("");
	}

	@Override
	public boolean isFocussed(Dialog dlg) {
		if (	dlg.mouseX>this.getPosX() &&
				dlg.mouseX<(this.getPosX()+this.getWidth()) &&
				dlg.mouseY>this.getPosY() &&
				dlg.mouseY<(this.getPosY()+this.getHeight())
				) {
			if (dlg.pressed>0) {
				for (Window win:dlg.getWindows()){
					for (GuiElement el:win.getElements()){
						if ((GuiElement)this==el && win==dlg.Toplevel){
							if (dlg.key==PConstants.BACKSPACE){
								if (this.getEntry().length()>0) {
									this.setEntry(this.getEntry().replace(
											this.getEntry().substring(this.getEntry().length()-1), ""));
								}
							}
							else {
								if (dlg.keyCode!=PConstants.SHIFT){
									if (this.getEntry().length()==0) {
										this.setEntry(String.valueOf(dlg.key).toUpperCase());
									}
									else {
										this.setEntry(this.getEntry() + dlg.key);
									}
								}
							}
						}
					}
				}
			}
			return true;
		}
		else {return false;}
	}

	@Override
	public void draw(Dialog dlg) {
		if (isFocussed(dlg)) {
			dlg.fill(230);
			dlg.rect(this.getPosX(),
					   this.getPosY(),
					   this.getWidth(),
					   this.getHeight(),
					   5);
		}
		this.Text.draw(dlg);
		dlg.fill(255);
		dlg.rect(this.getPosX()+(int)(0.33*this.getWidth()),
				   (int)(this.getPosY()+0.25*this.getHeight()),
				   (int)(0.6*this.getWidth()),
				   (int)(0.5*this.getHeight()),
				   5);
		dlg.fill(0);
		dlg.text(this.getEntry(),
				 this.getPosX()+(int)(0.35*this.getWidth()),
				 this.getPosY()+(int)(0.5*this.getHeight()));
	}

	public String getEntry() {
		return Entry;
	}

	public void setEntry(String entry) {
		Entry = entry;
	}

	public Dialog getDlg() {
		return this.dlg;
	}

	public void setDlg(Dialog dlg) {
		this.dlg = dlg;
	}

	@Override
	public void setPosY(int posy){
		super.setPosY(posy);
		Text.setPosY(posy);
	}
	@Override
	public void setPosX(int posx){
		super.setPosX(posx);
		Text.setPosX(posx);
	}
}
