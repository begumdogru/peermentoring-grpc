package io.reflectoring.user_service.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String role;
    private Integer birthday;
    private String school;
    private String department;

    //Builder Pattern
    private User(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phone = builder.phone;
        this.role = builder.role;
        this.birthday = builder.birthday;
        this.school = builder.school;
        this.department = builder.department;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String username;
        private String password;
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private String role;
        private Integer birthday;
        private String school;
        private String department;

        private Builder(){}
        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder username(String username) {
            this.username = username;
            return this;
        }
        public Builder password(String password) {
            this.password = password;
            return this;
        }
        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public Builder email(String email) {
            this.email = email;
            return this;
        }
        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }
        public Builder role(String role) {
            this.role = role;
            return this;
        }
        public Builder birthday(Integer birthday) {
            this.birthday = birthday;
            return this;
        }
        public Builder school(String school) {
            this.school = school;
            return this;
        }
        public Builder department(String department) {
            this.department = department;
            return this;
        }
        public User build() {
            return new User(this);
        }

    }




}
