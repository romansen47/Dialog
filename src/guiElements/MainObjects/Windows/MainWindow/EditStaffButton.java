package guiElements.MainObjects.Windows.MainWindow;

import guiElements.MainObjects.Windows.StaffManagement.EditStaffWindow;

public class EditStaffButton extends MainWindowPanelButton{
	
	public EditStaffButton() {
		super(0,0, "Staff");
	}
	
	@Override
	public void ifClicked(){
		@SuppressWarnings("unused")
		EditStaffWindow Staff = new EditStaffWindow(this.getDlg());
	}
	
}
