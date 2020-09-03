package br.com.fsrocha.fiisexplorer.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author Filipe Rocha
 */
@Entity
@Data
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    UUID id;

    @Column(name = "fullname")
    String fullName;

    @Column(name = "username")
    String username;

    @Column(name = "email")
    String email;

    @JsonIgnore
    @Column(name = "password")
    String password;

    @JsonIgnore
    @Column(name = "confirm_email")
    Boolean confirmEmail = true;

    @Column(name = "change_password")
    Boolean changePassword = false;

}
