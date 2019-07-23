package olivia;

public class Role {
	private IGun gun = null;
	private String name = null;
	
	Role(String name){
		this.name = name;
	}
	
	public IGun getGun() {
		return gun;
	}
 
	public void setGun(IGun gun) {
		this.gun = gun;
	}
	
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public void shoot() {
		this.gun.shoot();
	}
}