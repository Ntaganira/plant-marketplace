package rw.ntaganira.auth.service;

import rw.ntaganira.auth.dto.AuthResponse;
import rw.ntaganira.auth.dto.LoginRequest;
import rw.ntaganira.auth.dto.RegisterRequest;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : AuthService.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Handles authentication operations
 * --------------------------------------------------------------------
 */

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);

}