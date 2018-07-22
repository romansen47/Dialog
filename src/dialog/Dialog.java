package dialog;

import buchhaltung.Store;
import buchhaltung.defs.enums.Wochentag;
import buchhaltung.classes.Date;
import guiElements.MainObjects.Windows.MainWindow.MainWindow;
import guiElements.MainObjects.Windows.Windows.Panel;
import guiElements.MainObjects.Windows.Windows.Window;
import processingTemplate.Gui;

public class Dialog extends Gui{

	Panel pnl;
	private MainWindow main;
	public Window Toplevel;
	private Window[] Windows=new Window[0];
	public int[] pressedPos2=new int[2];

	public int clicked;
	public int pressed;
	
	private Store store=new Store(new Date(Wochentag.Donnerstag,19,1,1985));
	
	public final int ButtonStandardHeight=100,ButtonStandardWidth=300;
	
	@Override
	public void settings(){
		fullScreen(1);//
		//size(500,500);
	} 
	
	public Window[] getWindows() {
		if (Windows==null){
			return(new Window[0]);
		}
		return Windows;
	}

	public void setWindows(Window[] windows) {
		Windows = windows;
	}
	
	public void add(Window tmp){
		Window[] tmpElements=new Window[this.Windows.length+1];
		for (int i=0;i<this.Windows.length;i++){
			tmpElements[i]=this.getWindows()[i];
		}
		tmpElements[this.getWindows().length]=tmp;
		this.setWindows(tmpElements);
	}
	
	public void dropLast(){
		Window[] tmpElements=new Window[this.Windows.length-1];
		for (int i=0;i<this.Windows.length-1;i++){
			tmpElements[i]=this.getWindows()[i];
		}
		this.setWindows(tmpElements);
	}
	
	public int getIndex(Window window){
		for(int i=0;i<Windows.length;i++){
			if (Windows[i]==window){
				return i;
			}
		}
		return(-1);
	}
	
	public void remove(int pos){
		Window[] tmpElements=new Window[this.Windows.length-1];
		for (int i=0;i<pos;i++){
			tmpElements[i]=this.getWindows()[i];
		}
		for (int i=pos;i<this.Windows.length-1;i++){
			tmpElements[i]=this.getWindows()[i+1];
		}
		this.setWindows(tmpElements);
	}
	
	@Override
	public void setup() {

		frameRate(40);
		surface.setResizable(true);
		surface.setLocation(displayWidth-width >> 1, displayHeight-height >> 1);
		Panel.Height=displayHeight/25;
		main=new MainWindow(this);
		
		}

	public Window Toplevel(){
		Window tmpToplevel=null;
		for (Window wn:Windows) {
			if (wn.isToplevel()) {
				tmpToplevel=wn;
			}
		}
		if (tmpToplevel==null) {
			if (Windows.length>0){
				tmpToplevel=Windows[0];
			}
		}
		for (Window lvl:Windows) {
			lvl.setToplevel(false);
			if (lvl.isFocussed(this)) {
					tmpToplevel=lvl;
			}
		}
		if (tmpToplevel!=null){
			tmpToplevel.setToplevel(true);
			remove(getIndex(tmpToplevel));
			add(tmpToplevel);
		}
		if (mousePressed && Toplevel==null) {
			return Toplevel;
		}
		return(tmpToplevel);
	}
	
	@Override
	public void draw() {
		
		background(235);
		clicked=clicked();
		pressed=pressed();
		Toplevel=Toplevel();
		main.draw(this);
		for (Window lvl:Windows) {
			if(lvl!=Toplevel) {
				if (lvl.isVisible()) {
					lvl.draw(this);
				}
			}
		}
		if (Toplevel!=null && Toplevel.isVisible()){
			Toplevel.draw(this);
		}
		if (pressedPos2[0]==0 || pressedPos2[1]==0) {
			pressedPos2[0]=pressedPos[0];
			pressedPos2[1]=pressedPos[1];
		}
		pressedPos[0]=mouseY;
		pressedPos[1]=mouseX;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
	public MainWindow getMain() {
		return main;
	}

}
