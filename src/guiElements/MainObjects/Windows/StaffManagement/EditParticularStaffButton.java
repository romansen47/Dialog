package guiElements.MainObjects.Windows.StaffManagement;

import buchhaltung.classes.Mitarbeiter;
import dialog.Dialog;
import guiElements.Buttons.Button;
import guiElements.MainObjects.Windows.Windows.Window;

public class EditParticularStaffButton extends Button{
	private Mitarbeiter staff;
	public EditParticularStaffButton(Window wnd, Mitarbeiter staff, int posy, int posx, int height, int width) {
		super(posy, posx, height, width, staff.getVorname()+" "+staff.getNachname());
		this.setStaff(staff);
		this.setDlg(wnd.getDlg());
	}
	public Mitarbeiter getStaff() {
		return staff;
	}
	public void setStaff(Mitarbeiter staff) {
		this.staff = staff;
	}
	@Override
	public void ifClicked() {
		EditParticularStaffWindow tmp=new EditParticularStaffWindow(getDlg(),staff);
	}
	
	@Override
	public void draw(Dialog dlg) {
		super.draw(dlg);
		if (this.isFocussed(dlg) && this.getDlg().clicked>0) {
			this.ifClicked();
		}
	}
}
