//package app.project.content.user.domain.entity;
//
//import app.project.content.role.domain.entity.Role;
//import jakarta.persistence.*;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Size;
//import lombok.*;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
//@Entity
//@Table(name = "users",
//    uniqueConstraints = {
//      @UniqueConstraint(columnNames = "username"),
//      @UniqueConstraint(columnNames = "email")
//    })
//public class User {
//
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @Column(name = "id_user")
//  private Long id;
//
//  @NotBlank
//  @Size(max = 20)
//  @Column(name = "username", nullable = false, length = 50, unique = true)
//  private String username;
//
//  @NotBlank
//  @Size(max = 50)
//  @Email
//  @Column(name = "email", nullable = false, length = 50, unique = true)
//  private String email;
//
//  @NotBlank
//  @Size(max = 120)
//  @Column(name = "password", nullable = false)
//  private String password;
//
//  @ManyToMany(fetch = FetchType.LAZY)
//  @JoinTable(
//          name = "user_roles",
//          joinColumns = @JoinColumn(name = "user_id"),
//          inverseJoinColumns = @JoinColumn(name = "role_id")
//  )
//  @Column(name = "roles")
//  private Set<Role> roles = new HashSet<>();
//
//  public User(String username, String email, String password) {
//    this.username = username;
//    this.email = email;
//    this.password = password;
//  }
//
//
//  public void addRole(Role role) {
//    this.roles.add(role);
//  }
//  public void removeRole(Role role) {
//    this.roles.remove(role);
//  }
//}


package app.project.content.user.domain.entity;

import app.project.content.role.domain.entity.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @NotBlank
  @Size(max = 20)
  @Column(name = "username")
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  @Column(name = "email")
  private String email;

  @NotBlank
  @Size(max = 120)
  @Column(name = "password")
  private String password;

  @NotBlank
  @Column(name = "photo")
  private String photo;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(  name = "user_roles",
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  public User(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }
  public User(String username, String email, String password, String photo) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.photo = photo;
  }

  public void addRole(Role role) {
    this.roles.add(role);
  }
  public void removeRole(Role role) {
    this.roles.remove(role);
  }
}
