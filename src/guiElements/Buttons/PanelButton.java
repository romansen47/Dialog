package guiElements.Buttons;

import guiElements.MainObjects.Windows.Windows.Panel;
import guiElements.MainObjects.Windows.Windows.Window;

public class PanelButton extends Button{

	public PanelButton(int posy, int posx, int height, int width, String body) {
		super(posy, posx, height, width, body);
	}
	
	private Panel pnl;
	
	public Panel getPnl() {
		return pnl;
	}
	public void setPnl(Panel pnl) {
		this.pnl=pnl;
	}
}
