package guiElements.MainObjects.Windows.StaffManagement;

import buchhaltung.classes.Mitarbeiter;
import dialog.Dialog;
import guiElements.Buttons.Button;
import guiElements.GeneralObjects.GuiElement;
import guiElements.MainObjects.Windows.Windows.Minimizer;
import guiElements.MainObjects.Windows.Windows.Panel;
import guiElements.MainObjects.Windows.Windows.Window;

public class EditStaffWindow extends Window{

	CreateStaffButton Staff;
	private EditParticularStaffButton[] Personal;
	
	public EditStaffWindow(Dialog dlg) {
		
		super(dlg,Panel.Height,dlg.getMain().getWidth()-500,dlg.getMain().getHeight()-2*Panel.Height,500);
		
		this.Staff = new CreateStaffButton(this,this.getPosY()+Panel.Height+20,this.getPosX()+50,50,100);
		this.Staff.setDlg(dlg);
		this.Staff.setWnd(this);
		
		this.add((this.getPnl()));
		
		this.getPnl().add(this.Staff);
		setPersonal(new EditParticularStaffButton[0]);
	}
	public void add(EditParticularStaffButton tmp){
		
		boolean alreadyThere=false;
		for (int i=0;i<this.getPersonal().length;i++){
			if (tmp==this.getPersonal()[i]) {
				alreadyThere=true;
			}
		}
		if (alreadyThere==false) {
			EditParticularStaffButton[] tmpPersonal=new EditParticularStaffButton[this.getElements().length+1];
			for (int i=0;i<this.getPersonal().length;i++){
				tmpPersonal[i]=this.getPersonal()[i];
			}
			tmpPersonal[this.getPersonal().length]=tmp;
			this.setPersonal(tmpPersonal);
		}
	}
	
	public void dropLast(){
		EditParticularStaffButton[] tmpPersonal=new EditParticularStaffButton[this.getPersonal().length-1];
		for (int i=0;i<this.getPersonal().length-1;i++){
			tmpPersonal[i]=this.getPersonal()[i];
		}
		this.setPersonal(tmpPersonal);
	}
	
	public int getIndex(EditParticularStaffButton element){
		for(int i=0;i<getPersonal().length;i++){
			if (getPersonal()[i]==element){
				return i;
			}
		}
		return(-1);
	}
	
	public void remove(int pos){
		if (this.getPersonal().length>0 && pos>=0){
			EditParticularStaffButton[] tmpPersonal=new EditParticularStaffButton[this.getPersonal().length-1];
			this.getDlg().delay(100);
			for (int i=0;i<pos;i++){
				tmpPersonal[i]=this.getPersonal()[i];
			}
			for (int i=pos;i<this.getPersonal().length-1;i++){
				tmpPersonal[i]=this.getPersonal()[i+1];
			}
			this.setPersonal(tmpPersonal);
			getDlg().delay(100);
		}
	}
	public void remove(EditParticularStaffButton btn) {
		remove(getIndex(btn));		
	}
	
	@Override
	public void ifClicked() {
		for (EditParticularStaffButton btn:this.getPersonal()){
			if (btn.isFocussed(this.getDlg())) {
				btn.ifClicked();
			}
		}
		super.ifClicked();
	}
	
	@Override
	public void draw(Dialog dlg) {

		super.draw(dlg);
		Personal=new EditParticularStaffButton[0];
		int i=0;
		for (Mitarbeiter staff:this.getDlg().getStore().getPersonal()) {
			new EditParticularStaffButton(this,staff,this.Staff.getPosY()+100+i*Panel.Height,this.Staff.getPosX(),Panel.Height,300).draw(dlg);
			i+=1;
		}
	}
	public EditParticularStaffButton[] getPersonal() {
		return Personal;
	}
	public void setPersonal(EditParticularStaffButton[] personal) {
		Personal = personal;
	}
}
