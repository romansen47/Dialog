package guiElements.MainObjects.Windows.StaffManagement;

import buchhaltung.classes.Mitarbeiter;
import dialog.Dialog;
import guiElements.Buttons.DeleteButton;
import guiElements.MainObjects.Windows.Windows.InfoWindow;

public class EditParticularStaffWindow extends CreateStaffWindow{
	
	private Mitarbeiter Staff;
	DeleteButton Delete;
	
	public EditParticularStaffWindow(Dialog dlg,Mitarbeiter staff) {
		super(dlg);
		this.setStaff(staff);
		this.Vorname.setEntry(staff.getVorname());
		this.Nachname.setEntry(staff.getNachname());
		Delete=new DeleteButton(this.Ok.getPosY(),this.Ok.getPosX()+this.Ok.getWidth()+50, 
				this.Ok.getHeight(),this.Ok.getWidth(), staff);
		Delete.setDlg(this.getDlg());
		Delete.setWnd(this);
		this.add(Delete);
		
	}
	public Mitarbeiter getStaff() {
		return Staff;
	}
	public void setStaff(Mitarbeiter staff) {
		Staff = staff;
	}
	@Override
	public void ifClicked(){
		if (Ok.isFocussed(this.getDlg())){
			if (Vorname.getEntry()=="" || Nachname.getEntry()=="" ){
				new InfoWindow(this,"You should enter something into both fields...");
			}
			else{
				boolean alreadyThere=false;
				for (Mitarbeiter x:getDlg().getStore().getPersonal()){
					if (x.getVorname().equals(Vorname.getEntry()) && x.getNachname().equals(Nachname.getEntry())){
						alreadyThere=true;
					}
				}
				if (!alreadyThere){
					this.Staff.setVorname(Vorname.getEntry());
					this.Staff.setNachname(Nachname.getEntry());
				}
				this.getDlg().remove(getDlg().getIndex(this));
			}
			getDlg().delay(100);
		}
		else{super.ifClicked();}
	}
}
