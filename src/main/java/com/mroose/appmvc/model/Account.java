package com.mroose.appmvc.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@IdClass(com.mroose.appmvc.model.AccountId.class)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Account {
    @Id
    @Column(name = "username")
    @NonNull
    private String username;

    @Column(name = "password")
    @NonNull
    private String password;

    @Column(name = "role")
    @NonNull
    private String role;
}
