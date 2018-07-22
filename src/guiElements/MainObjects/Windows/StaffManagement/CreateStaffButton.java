package guiElements.MainObjects.Windows.StaffManagement;

import dialog.Dialog;
import guiElements.Buttons.Button;
import guiElements.MainObjects.Windows.Windows.Window;

public class CreateStaffButton extends Button{
	public CreateStaffButton(Window wnd, int posy, int posx, int height, int width) {
		super(posy, posx, height, width, "Add staff");
	}
	
	@Override
	public void ifClicked(){
		CreateStaffWindow StaffWnd=new CreateStaffWindow(this.getDlg());
		this.getDlg().delay(200);
	}
	
}
