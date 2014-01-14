package data;

import javax.jdo.annotations.PersistenceCapable;


@PersistenceCapable(detachable = "true")
public class DBItem {
	
	protected int id;
	
	public DBItem(int id){
		this.id=id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
