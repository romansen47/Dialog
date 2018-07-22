package guiElements.MainObjects.Windows.MainWindow;

import dialog.Dialog;
import guiElements.GeneralObjects.GuiElement;
import guiElements.MainObjects.Windows.Windows.Panel;
import guiElements.MainObjects.Windows.Windows.Window;
import interfaces.Interaction;
import processing.core.PConstants;

public class MainWindow extends Window{

	private EditStaffButton editStaff;
	private BottomPanel bottomPanel;
	public MainWindow(Dialog dlg) {
		
		super(dlg,0,0,dlg.displayHeight, dlg.displayWidth);
		this.getDlg().remove(0);
		
		this.setPnl(new MainWindowPanel(this.getPosY(),this.getPosX(),this.getWidth()));
		this.getPnl().setWnd(this);
		this.getPnl().setDlg(dlg);
		this.add(this.getPnl());
		
		this.setBottomPanel(new BottomPanel(this.getHeight()-Panel.Height,this.getPosX(),this.getWidth()));
		this.getBottomPanel().setWnd(this);
		this.getBottomPanel().setDlg(dlg);
		
		this.getPnl().getExitButton().setDlg(dlg);
		this.getPnl().getExitButton().setWnd(this);
		this.getPnl().getExitButton().setPnl(this.getPnl());		
		
		editStaff=new EditStaffButton();
		editStaff.setDlg(dlg);
		editStaff.setWnd(this);
		editStaff.setPnl(this.getPnl());
		this.add(this.getEditStaff());
	}
	

	public EditStaffButton getEditStaff() {
		return editStaff;
	}
	
	public void setEditStaff(EditStaffButton editStaff) {
		this.editStaff = editStaff;
	}
	
	@Override
	public void ifClicked() {
		if (this.getPnl().getExitButton().isFocussed(getDlg())) {
			this.getPnl().getExitButton().ifClicked();
		}
	}
	
	@Override
	public void draw(Dialog dlg) {
		dlg.fill (255);
		dlg.rect(this.getPosX(),this.getPosY(),this.getWidth(),this.getHeight());
		this.getPnl().draw(dlg);
		this.getBottomPanel().draw(dlg);
		for (Interaction inter:this.getElements()) {
			inter.draw(dlg);
		}
		if (this.getPnl().isFocussed(dlg) && dlg.clicked>0 && dlg.mouseButton==PConstants.LEFT){
			this.ifClicked();
		}
	}
	
	public BottomPanel getBottomPanel() {
		return bottomPanel;
	}
	
	public void setBottomPanel(BottomPanel bottomPanel) {
		this.bottomPanel = bottomPanel;
	}
	
}
