package com.gateway.app.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.*;
import java.util.stream.Collectors;

public class JwtConverterImpl implements Converter<Jwt, Collection<GrantedAuthority>>{

    @Override
    public Collection<GrantedAuthority> convert(Jwt source) {
        Map<String, List<String>> resourceAccess = source.getClaim("realm_access");
        List<String> roles = resourceAccess.get("roles");
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_"+role))
                .collect(Collectors.toList());

    }
}
