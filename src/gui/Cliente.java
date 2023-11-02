package gui;

import Interfaz.AbstractInterfaceFactory;
import Libro.PlatformFactory;

public class Cliente {
	private AbstractInterfaceFactory aif;
	private PlatformFactory pf;
	
	
	
	public AbstractInterfaceFactory getAif() {
		return aif;
	}
	public void setAif(AbstractInterfaceFactory aif) {
		this.aif = aif;
	}
	public PlatformFactory getPf() {
		return pf;
	}
	public void setPf(PlatformFactory pf) {
		this.pf = pf;
	}
	
	
}
