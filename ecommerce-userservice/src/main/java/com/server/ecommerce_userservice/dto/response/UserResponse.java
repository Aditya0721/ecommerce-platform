package com.server.ecommerce_userservice.dto.response;

//records create immutable class and skips the boilerplate
public record UserResponse(
        String userName,
        String email,
        String password
) {}
