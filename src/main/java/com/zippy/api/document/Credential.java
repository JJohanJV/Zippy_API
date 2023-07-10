package com.zippy.api.document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zippy.api.constants.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@Document
@Data
public class Credential implements UserDetails {
    @Id
    ObjectId id;
    @Indexed(unique = true)
    @NonNull
    private String username;
    @Indexed(unique = true)
    @NonNull
    private String email;
    @JsonIgnore
    @NonNull
    private String password;
    @NonNull
    private Roles roles;
    @NotNull
    private ObjectId userId;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Aquí debes devolver una lista de GrantedAuthority basada en los roles del usuario
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Roles role : roles.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.name()));
        }
        // Agrega más roles según la lógica de tu aplicación
        return authorities;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}