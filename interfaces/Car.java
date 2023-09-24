package interfaces;

public class Car extends Vehicle implements VehicleInterface, CarInterface{
	
	public boolean isMotorized() {
		return true;
	}

	@Override
	public int numGears() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public String getCompany() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
