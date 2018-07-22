package guiElements.GeneralObjects;

import dialog.Dialog;
import interfaces.Interaction;

public class GuiElement implements Interaction{
	
	public GuiElement(int posy, int posx,int height,int width) {
		this.PosX=posx;
		this.PosY=posy;
		this.Width=width;
		this.Height=height;
		this.setElements(new GuiElement[0]);
	}
	
	private Dialog dlg;
	/**
	 *  Coordinates for the top left corner of the button
	 */
	private int PosX,PosY;
	/**
	 * Width and height for the button
	 */
	private int Width,Height;
	/**
	 * Getter for PosX
	 * @return PosX
	 */
	public int getPosX() {
		return PosX;
	}
	/**
	 * Setter for PosX
	 * @param posX
	 */
	public void setPosX(int posX) {
		for (GuiElement el:this.getElements()) {
			el.setPosX(el.getPosX()+posX-this.getPosX());
		}
		PosX = posX;
	}
	/**
	 * Getter for PosX
	 * @return PosY
	 */
	public int getPosY() {
		return PosY;
	}
	/**
	 * Setter for PosY
	 * @param posY
	 */
	public void setPosY(int posY) {
		for (GuiElement el:this.getElements()) {
			el.setPosY(el.getPosY()+posY-this.getPosY());
		}
		PosY = posY;
	}
	/**
	 * 
	 * @return Height of the Button
	 */
	public int getHeight() {
		return Height;
	}
	/***
	 * Setter for ButtonHeight
	 * @param boxHeight
	 */
	public void setHeight(int boxHeight) {
		Height = boxHeight;
	}
	/**
	 * 
	 * @return width of the Button
	 */
	public int getWidth() {
		return Width;
	}
	/**
	 * Setter for ButtonWidth
	 * @param boxWidth
	 */
	public void setWidth(int boxWidth) {
		Width = boxWidth;
	}

	private GuiElement[] elements;
	
	public void add(GuiElement tmp){
		
		boolean alreadyThere=false;
		for (int i=0;i<this.getElements().length;i++){
			if (tmp==this.getElements()[i]) {
				alreadyThere=true;
			}
		}
		if (alreadyThere==false) {
			GuiElement[] tmpElements=new GuiElement[this.getElements().length+1];
			for (int i=0;i<this.getElements().length;i++){
				tmpElements[i]=this.getElements()[i];
			}
			tmpElements[this.getElements().length]=tmp;
			this.setElements(tmpElements);
		}
	}
	
	public void dropLast(){
		GuiElement[] tmpElements=new GuiElement[this.getElements().length-1];
		for (int i=0;i<this.getElements().length-1;i++){
			tmpElements[i]=this.getElements()[i];
		}
		this.setElements(tmpElements);
	}
	
	public int getIndex(GuiElement element){
		for(int i=0;i<getElements().length;i++){
			if (getElements()[i]==element){
				return i;
			}
		}
		return(-1);
	}
	
	public void remove(int pos){
		if (this.getElements().length>0 && pos>=0){
			GuiElement[] tmpElements=new GuiElement[this.getElements().length-1];
			//this.getDlg().delay(100);
			for (int i=0;i<pos;i++){
				tmpElements[i]=this.getElements()[i];
			}
			for (int i=pos;i<this.getElements().length-1;i++){
				tmpElements[i]=this.getElements()[i+1];
			}
			this.setElements(tmpElements);
			//getDlg().delay(100);
		}
	}
	public void remove(GuiElement guiElement) {
		remove(getIndex(guiElement));		
	}
	/**
	 * 
	 * @return true if is focussed
	 */
	@Override
	public boolean isFocussed(Dialog dlg) {
		return false;
	}
	@Override
	public void ifClicked() {
		for (GuiElement el:this.getElements()) {
			if (el.isFocussed(this.getDlg())) {
				el.ifClicked();
			}
		}
	}
	
	@Override
	public void draw(Dialog dlg) {
		for (GuiElement el:this.getElements()) {
			el.draw(dlg);
		}
	}
	public GuiElement[] getElements() {
		return elements;
	}
	public void setElements(GuiElement[] elements) {
		this.elements = elements;
	}
	public Dialog getDlg() {
		return dlg;
	}
	public void setDlg(Dialog dlg) {
		this.dlg = dlg;
	}
}
