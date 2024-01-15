package com.Receptionist.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Receptionist.Models.ReceptionistInfo;
import com.Receptionist.Repo.ReceptionistRepo;
import com.Receptionist.SecurityConfig.ReceptionistAuthResponse;
import com.Receptionist.SecurityConfig.ReceptionistService;


@RestController
@RequestMapping("/receptionist")
public class ReceptionistController {
	@Autowired
	private ReceptionistService receptionistService;
	@Autowired
	private ReceptionistRepo receptionistRepo;
	@Autowired
	private AuthenticationManager authenticationManager;

//Creating/Adding Receptionist
	
	@PostMapping("/addReceptionist")
	private ResponseEntity<?> saveOwnerInfo(@RequestBody ReceptionistInfo receptionistInfo) {
		String email = receptionistInfo.getEmail();
		String password = receptionistInfo.getPassword();
		ReceptionistInfo receptionist1 = new ReceptionistInfo();
		receptionist1.setEmail(email);
		receptionist1.setPassword(password);
		try {

			receptionistRepo.save(receptionistInfo);
		} catch (Exception e) {
			return ResponseEntity.ok(new  ReceptionistAuthResponse("Error creating Receptionist" + email));
		}
		return ResponseEntity.ok(new ReceptionistAuthResponse("Successfully created Receptionist " + email));
	}

//authenticating receptionist
	@PostMapping("/auth")
	private ResponseEntity<?> authReceptionist(@RequestBody ReceptionistInfo receptionistInfo) {
		String email = receptionistInfo.getEmail();
		String password = receptionistInfo.getPassword();
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ReceptionistAuthResponse("Login Failed") );
		}
		return ResponseEntity.ok(new ReceptionistAuthResponse("Successfully Authenticated Receptionist" + email));
	}

//Reading all receptionist
	@GetMapping("/receptionist")
	public List<ReceptionistInfo> findAllReceptionist() {
		return receptionistService.getReceptionistInfos();
	}

}
