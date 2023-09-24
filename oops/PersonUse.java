package oops;

public class PersonUse {
	
	public static void main(String[] args) {
		Professor p = new Professor();
		p.name = "Carl Newport";
		p.nationality = "USA";
		p.age = 40;
		p.collegeName = "Oxford University";
		p.print();
		p.getCollege();
		
		Politician poli = new Politician();
		poli.name = "Rahul Gandhi";
		poli.age = 53;
		poli.nationality = "India";
		poli.partyName = "Congress";
		poli.print();
		poli.getPartyName();
	}
	
}
