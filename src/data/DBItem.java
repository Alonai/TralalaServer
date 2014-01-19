package data;

import javax.jdo.annotations.PersistenceCapable;


@PersistenceCapable(detachable = "true")
public class DBItem {
	
	protected String id;
	
	public DBItem(String id){
		this.id=id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
