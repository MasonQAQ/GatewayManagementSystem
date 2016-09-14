package gateway.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Represents an User for this web application.
 */
@Entity
@Table(name = "users")
public class User {

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @NotNull
  private String username;

  @NotNull
  private String password;

  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  public User() { }

  public User(long id) { 
    this.id = id;
  }

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public long getId() {
    return id;
  }

  public void setId(long value) {
    this.id = value;
  }

  public String getPassword() {
    return password;
  }
  
  public void setPassword(String value) {
    this.password = value;
  }
  
  public String getUsername() {
    return username;
  }

  public void setUsername(String value) {
    this.username = value;
  }
  
} // class User
