package com.example.ronildevelops.SecureLogin.Service;

import com.example.ronildevelops.SecureLogin.DTO.AuthResponse;
import com.example.ronildevelops.SecureLogin.DTO.LoginRequest;
import com.example.ronildevelops.SecureLogin.DTO.RegisterRequest;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}