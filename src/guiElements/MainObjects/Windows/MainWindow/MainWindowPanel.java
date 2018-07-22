package guiElements.MainObjects.Windows.MainWindow;

import guiElements.MainObjects.Windows.Windows.Minimizer;
import guiElements.MainObjects.Windows.Windows.Panel;

public class MainWindowPanel extends Panel{

	private Minimizer Min;
	
	public MainWindowPanel(int posy, int posx, int Width) {
		super(posy, posx, Width);
		System.out.println(this.getElements().length);
		//this.remove(0);
		this.setExitButton(new MainPanelExitButton());
		this.getExitButton().setPosX(Width-Panel.Height);
		setMin(new Minimizer());
		Min.setPosX(posx+this.getWidth()-2*Height);
		Min.setPosY(posy);
		Min.setWidth(Height);
		Min.setPnl(this);
		this.add(this.getExitButton());
		//this.getWnd().add(this.getExitButton());
	}


	public Minimizer getMin() {
		return Min;
	}

	public void setMin(Minimizer min) {
		Min = min;
	}
}
