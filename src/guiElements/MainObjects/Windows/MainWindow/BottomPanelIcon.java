package guiElements.MainObjects.Windows.MainWindow;

import dialog.Dialog;
import guiElements.Buttons.PanelButton;
import guiElements.MainObjects.Windows.Windows.Window;

public class BottomPanelIcon extends PanelButton{

	private Window win;
	
	public BottomPanelIcon(int posy, int posx, int height, int width, String body,Window win) {
		super(posy, posx, height, width, body);
		this.setWin(win);
	}

	public Window getWin() {
		return win;
	}

	public void setWin(Window win) {
		this.win = win;
	}

	@Override
	public void ifClicked() {
		System.out.println("Jap");
		getWin().setVisible(true);
	}
	
	@Override
	public void draw(Dialog dlg) {
		super.draw(dlg);
		if (dlg.clicked>0 && this.isFocussed(dlg)) {
			this.ifClicked();
		}
	}

}
