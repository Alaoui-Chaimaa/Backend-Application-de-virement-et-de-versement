package ma.octo.assignement.domain.util;

public enum Gender {
	
	 F("Femelle"),
	 M("Mâle");

	private String gender;

	Gender(String gender) {
	      this.gender = gender;
	 }

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
    

}
