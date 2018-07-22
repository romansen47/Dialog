package guiElements.MainObjects.Windows.Windows;

public class Minimizer extends CloseButton{

	public Minimizer() {
		super();
		this.setPosX(this.getPosX()-Panel.Height);
		this.setBody("    __");
	}

	@Override
	public void ifClicked() {
		this.getPnl().getWnd().setVisible(false);
		//this.getDlg().getMain().getBottomPanel().add(new PanelButton());
	}

}
