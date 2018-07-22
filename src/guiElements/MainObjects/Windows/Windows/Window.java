package guiElements.MainObjects.Windows.Windows;

import dialog.Dialog;
import guiElements.GeneralObjects.GuiElement;
import interfaces.Interaction;
import processing.core.PConstants;

public class Window extends GuiElement{

	private boolean toplevel=true;
	private Panel pnl;
	private boolean visible=true;
	
	public Window(Dialog dlg,int posy,int posx,int height,int width) {
		
		super(posy,posx,height,width);
		
		setElements(new GuiElement[0]);
		dlg.add(this);
		
		this.setPnl(new Panel(posy,posx,width));
		
		this.setDlg(dlg);
		this.getPnl().setDlg(dlg);
		
		this.add(getPnl());
		this.getPnl().setWnd(this);
		
		Minimizer min=new Minimizer();
		min.setPosY(posy);
		min.setPosX(posx+width-2*Panel.Height);
		min.setWidth(Panel.Height);
		min.setHeight(Panel.Height);
		min.setDlg(dlg);
		min.setWnd(this);
		min.setPnl(getPnl());
		getPnl().add(min);
		if (this.getDlg().getMain() != null) {
			this.getDlg().getMain().getBottomPanel().add(this);
		}
		
	}
	
	@Override
	public boolean isFocussed(Dialog dlg) {
		if (dlg.mouseX>=this.getPosX() && dlg.mouseX<this.getPosX()+this.getWidth() &&
				dlg.mouseY>=this.getPosY() && dlg.mouseY<this.getPosY()+this.getHeight() ) {
			return true;
		}
		return false;
	}

	@Override
	public void ifClicked() {
		for (GuiElement el:this.getElements()) {
			if (el.isFocussed(this.getDlg())) {
				el.ifClicked();
			}
		}
		if (getDlg().mouseButton==PConstants.LEFT) {
			if(this.getPnl().getExitButton().isFocussed(this.getDlg())){
				getDlg().remove(getDlg().getIndex(this));
			}
			else if (this.getPnl().isFocussed(getDlg())){
				getDlg().pressedPos[0]=getDlg().mouseY;
			}
		}
		else if(getDlg().mouseButton==PConstants.RIGHT) {
			int deltaX=(int)((this.getDlg().mouseX-getDlg().pressedPos[1])*1.1);
			int deltaY=(int)((this.getDlg().mouseY-getDlg().pressedPos[0])*1.1);
			this.setPosX(this.getPosX()+deltaX);
			this.setPosY(this.getPosY()+deltaY);
		}
		
	}
	
	@Override
	public void draw(Dialog dlg) {
		dlg.fill (255);
		if (dlg.mousePressed){
			if (this.isFocussed(dlg) && this.getDlg().Toplevel==this) {
				this.ifClicked();
			}
		}
		dlg.rect(this.getPosX(),this.getPosY(),this.getWidth(),this.getHeight());
		super.draw(dlg);
	}


	public Panel getPnl() {
		return pnl;
	}

	public void setPnl(Panel pnl) {
		this.pnl = pnl;
	}


	public boolean isToplevel() {
		return toplevel;
	}


	public void setToplevel(boolean toplevel) {
		this.toplevel = toplevel;
	}


	public boolean isVisible() {
		return visible;
	}


	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void remove(guiElements.GeneralObjects.GuiElement guiElement) {
		super.remove(guiElement);
		
	}
	
}
