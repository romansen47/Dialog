package guiElements.MainObjects.Windows.MainWindow;

public class MainPanelExitButton extends MainWindowPanelButton{
	
	public MainPanelExitButton() {
		super(0,0,"Exit");
	}
	
	@Override
	public void ifClicked(){ 
		this.getDlg().exit();
		System.exit(0);
	}
	
}