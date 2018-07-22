package guiElements.Buttons;

import dialog.Dialog;
import guiElements.GeneralObjects.GuiElement;
import guiElements.MainObjects.Windows.Windows.Panel;
import guiElements.MainObjects.Windows.Windows.Window;
import interfaces.Interaction;
import processing.core.PApplet;

public class Button extends GuiElement implements Interaction{

	private String Body; 
	private Window wnd;
	private boolean isClicked;
	
	public Button(int posy, int posx, int height, int width,String body) {
		super(posy, posx, height, width);
		this.setBody(body);
	}
	/**
	 * 
	 * @return Body
	 */
	public String getBody() {
		return Body;
	}
	/**
	 * Setter for Body
	 * @param body
	 */
	public void setBody(String body) {
		this.Body = body;
	}
	
	@Override
	public void draw(Dialog dlg) {
		if (this.isFocussed(dlg)) {
			if (dlg.mousePressed) {
				for (Window win:dlg.getWindows()){
					for (GuiElement el:win.getElements()){
						if (win==dlg.Toplevel ) {
							if( (GuiElement)this==el){
								el.ifClicked();
							}
							for (GuiElement el2:el.getElements()) {
								if ((GuiElement)this==el2) {
									el2.ifClicked();
								}
							}
						}
					}
				}
			}
			dlg.fill(255);
		}
		else {
			dlg.fill(220);
		}
		dlg.rect(this.getPosX(),
				   this.getPosY(),
				   this.getWidth(),
				   this.getHeight(),
				   0);
		dlg.fill(0);
		dlg.text(this.Body,
				 this.getPosX()+(int)(0.2*this.getWidth()),
				 this.getPosY()+(int)(0.5*this.getHeight()));
	}
	
	@Override
	public boolean isFocussed(Dialog dlg) {
		if (	dlg.mouseX>this.getPosX() &&
				dlg.mouseX<(this.getPosX()+this.getWidth()) &&
				dlg.mouseY>this.getPosY() &&
				dlg.mouseY<(this.getPosY()+this.getHeight())
				) {
			return true;
			}
		else {return false;}
	}
	public boolean getIsClicked() {
		return isClicked;
	}
	public void setClicked(boolean isClicked) {
		this.isClicked = isClicked;
	}
	public void setWnd(Window wnd) {
		this.wnd=wnd;
	}
	public Window getWnd() {
		return wnd;
	}
}
