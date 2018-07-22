package guiElements.MainObjects.Windows.Windows;

import guiElements.GeneralObjects.PureText;

public class InfoWindow extends Window{
	public InfoWindow(Window wnd,String text) {
		super(wnd.getDlg(),  
				(int)(wnd.getDlg().getMain().getHeight()*0.2),
				(int)(wnd.getDlg().getMain().getWidth()*0.2), 
				(int)(wnd.getDlg().getMain().getHeight()*0.2),
				(int)(wnd.getDlg().getMain().getWidth()*0.2));
		this.add(new PureText(this.getPosY(), this.getPosX(), this.getWidth(), this.getHeight(), text));
		this.getDlg().add(this);
		wnd.getDlg().delay(100);
	}

}
