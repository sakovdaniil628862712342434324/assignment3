package sait.sll.problemdomain;

import java.io.Serializable;

// Represents a user
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String email;

	// 'transient' keyword prevents the password from being serialized
	private transient String password;

	public User(int id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}

	public boolean isCorrectPassword(String password) {
		if (this.password == null && password == null)
			return true;
		else if (this.password == null || password == null)
			return false;
		else
			return this.password.equals(password);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof User))
			return false;

		User other = (User) obj;

		return this.id == other.id && this.name.equals(other.name) && this.email.equals(other.email);
	}
}