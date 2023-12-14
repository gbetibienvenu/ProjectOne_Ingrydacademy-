package com.example.LibraryBook.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "library_mini")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Pattern(regexp = "^[a-zA-Z\\d_+&*-]+(?:\\.[a-zA-Z\\d_+&*-]+)@(?:[a-zA-Z\\d-]+\\.)+[a-zA-Z]{2,7}$", message = "Invalid email address")
    @Email(message = "Email field is required")
    private String email;

    @NotBlank(message = "Full name field is require")
    @Column(name = "full_name")
    @Length(min = 6, max = 15)
    private String fullName;

    @Column(name = "age_of")
    @NotBlank(message = "age field must not be blank")
    @Length(min = 18, max = 70)
    private Integer age;

    @NotBlank(message = "address field  is required")
    @Column(name = "address_of")
    private String address;

    public UserModel(long id, String email, String fullname, Integer age, String address) {
        this.id = id;
        this.email = email;
        this.fullName = fullname;
        this.age = age;
        this.address = address;
    }
}
