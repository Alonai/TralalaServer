package data.dao;

@PersistenceCapable
public class MemberDAO {

	@PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
	int id;
	
	String name;
	String nick;
	Set<PlayDAO> plays;
	
	public MemberDAO(data.Member member){
		
	}
	
}
