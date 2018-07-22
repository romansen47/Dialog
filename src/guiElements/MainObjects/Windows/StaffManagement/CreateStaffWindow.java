package guiElements.MainObjects.Windows.StaffManagement;

import buchhaltung.classes.Mitarbeiter;
import dialog.Dialog;
import guiElements.Buttons.DeleteButton;
import guiElements.Buttons.OkButton;
import guiElements.GeneralObjects.PureText;
import guiElements.GeneralObjects.TextEntry;
import guiElements.MainObjects.Windows.Windows.InfoWindow;
import guiElements.MainObjects.Windows.Windows.Window;

public class CreateStaffWindow extends Window{

	PureText Text=new PureText(this.getPosY()+50,this.getPosX()+50,this.getDlg().ButtonStandardHeight,this.getWidth()+this.getDlg().ButtonStandardWidth,"Mitarbeiter erstellen");
	public TextEntry Vorname =new TextEntry(this.getPosY()+150,this.getPosX()+50,this.getDlg().ButtonStandardHeight,this.getDlg().ButtonStandardWidth, "Vorname:  ");
	public TextEntry Nachname=new TextEntry(this.getPosY()+150,this.getPosX()+450,this.getDlg().ButtonStandardHeight,this.getDlg().ButtonStandardWidth, "Nachname: ");
	OkButton Ok=new OkButton(this,this.getPosY()+400,this.getPosX()+50,50,250);
	
	public CreateStaffWindow(Dialog dlg) {
		super(dlg,200,200,500,800);
		this.add(Text);
		this.add(Vorname);
		this.add(Nachname);
		this.add(Ok);
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
				if (alreadyThere){
					new InfoWindow(this,"Dieser Mitarbeiter ist schon angelegt...");
				}
				else{
					this.getDlg().getStore().getPersonal().add(new Mitarbeiter(Vorname.getEntry(),Nachname.getEntry()));
					this.getDlg().remove(getDlg().getIndex(this));
				}
			}
			getDlg().delay(100);
		}
		else{super.ifClicked();}
	}
	
	@Override
	public void draw(Dialog dlg){
		super.draw(dlg);
	}
}
