package com.stilus.calculator.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stilus.calculator.security.CalculatorUserDetailsService;
import com.stilus.calculator.security.jwt.JwtUtil;
import com.stilus.calculator.security.jwt.model.AuthRequest;
import com.stilus.calculator.security.jwt.model.AuthResponse;

@RestController
@RequestMapping("/")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CalculatorUserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/auth")
	public ResponseEntity<?> createAuthToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Username or password incorrect !");
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUserName());
		final String token = jwtUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthResponse(token));
	}
}
