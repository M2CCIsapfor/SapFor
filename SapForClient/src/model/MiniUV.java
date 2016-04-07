package model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * 
 * @author francoismoins
 *
 */
public class MiniUV implements Observable{
    
	private StringProperty intitule;
	private SimpleBooleanProperty check;
	
	public MiniUV(UV uv){
		this.intitule = new SimpleStringProperty(uv.getNom());
		check = new SimpleBooleanProperty(false);
	}
	
	public MiniUV(String str){
		this.intitule = new SimpleStringProperty(str);
		check = new SimpleBooleanProperty(false);
	}

	public SimpleBooleanProperty checkedProperty() {
		return this.check;
	}

	public java.lang.Boolean getChecked() {
		return this.checkedProperty().get();
	}

	public void setChecked(final java.lang.Boolean checked) {
		this.checkedProperty().set(checked);
	}
	
	public StringProperty getIntituleProperty(){
		return intitule;
	}

	@Override
	public void addListener(InvalidationListener listener) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeListener(InvalidationListener listener) {
		// TODO Auto-generated method stub
	}
	
}

