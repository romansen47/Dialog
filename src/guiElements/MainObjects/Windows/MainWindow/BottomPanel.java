package guiElements.MainObjects.Windows.MainWindow;

import dialog.Dialog;
import guiElements.Buttons.PanelButton;
import guiElements.GeneralObjects.GuiElement;
import guiElements.MainObjects.Windows.Windows.Panel;
import guiElements.MainObjects.Windows.Windows.Window;

public class BottomPanel extends MainWindowPanel{

	private Window[] Icons;
	
	public BottomPanel(int posy, int posx, int Width) {
		super(posy, posx, Width);
		this.setElements(new GuiElement[0]);
		Icons=new Window[0];
	}
	
	@Override
	public void draw(Dialog dlg) {
		int i=0;
		PanelButton tmp;
		for (Window wnd:this.getIcons()) {
			if (!wnd.getPnl().getWnd().isVisible()) {
				tmp=new BottomPanelIcon(this.getPosY(),this.getPosX()+i*Panel.Height,Panel.Height,Panel.Height,"", this.getWnd());
				this.add(tmp);
				i+=1;
				if (dlg.clicked==1 && this.isFocussed(dlg)) {
					wnd.setVisible(true);
					dlg.delay(100);
				}
			}
		}
		super.draw(dlg);
	}
	
	public Window[] getIcons() {
		return Icons;
	}

	public void add(Window btn) {
		Window[] tmpIcons=new Window[Icons.length+1];
		for (int i=0;i<Icons.length;i++) {
			tmpIcons[i]=Icons[i];
		}
		tmpIcons[Icons.length]=btn;
		this.Icons=tmpIcons;
	}
	
	public void remove(int m) {
		if ( Icons!=null && m>=0 && Icons.length>m) {
			Window[] tmpIcons=new Window[Icons.length-1];
			for (int i=0;i<m;i++) {
				tmpIcons[i]=Icons[i];
			}
			for (int i=m;i<tmpIcons.length;i++) {
				tmpIcons[i]=Icons[i+1];
			}
			this.Icons=tmpIcons;
			this.getDlg().delay(100);
		}
	}
	
	public int getIndex(Window btn) {
		for (int i=0;i<this.Icons.length;i++) {
			if (Icons[i]==btn) {
				return(i);
			}
		}
		return -1;
	}
	
	public void remove(Window btn) {
		this.remove(this.getIndex(btn));
	}

}
