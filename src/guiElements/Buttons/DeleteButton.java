package guiElements.Buttons;

import buchhaltung.classes.Mitarbeiter;

public class DeleteButton extends Button{

	private Mitarbeiter Staff;
	public DeleteButton(int posy, int posx, int height, int width, Mitarbeiter staff) {
		super(posy, posx, height, width,"Delete "+staff.getVorname()+" "+staff.getNachname()+"?");
		Staff=staff;
	}
	
	@Override
	public void ifClicked() {
		this.getDlg().getStore().getPersonal().remove(Staff);
		this.getDlg().delay(100);
		this.getDlg().remove(getDlg().getIndex(this.getWnd()));
	}
	
	public Mitarbeiter getStaff() {
		return Staff;
	}
	public void setStaff(Mitarbeiter staff) {
		Staff = staff;
	}


}
