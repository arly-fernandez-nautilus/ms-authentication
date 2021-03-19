package nautilus.authorization.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "users")
public class User {

	@Id
	private Integer id;
	
	private String name;
	
	private String email;
	
	private String phone;
	
	private String password;
	
}
