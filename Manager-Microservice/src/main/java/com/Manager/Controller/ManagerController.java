package com.Manager.Controller;



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

import com.Manager.Models.ManagerInfo;
import com.Manager.Repo.ManagerRepo;
import com.Manager.SecurityConfig.ManagerAuthResponse;
import com.Manager.SecurityConfig.ManagerService;


@RestController
@RequestMapping("/manager")
public class ManagerController {
	@Autowired
	private ManagerService managerService;
	@Autowired
	private ManagerRepo managerRepo;
	@Autowired
	private AuthenticationManager authenticationManager;

//Creating post mapping to add manager Details
	
	@PostMapping("/addManager")
	private ResponseEntity<?> saveOwnerInfo(@RequestBody ManagerInfo managerInfo) {
		String email = managerInfo.getEmail();
		String password = managerInfo.getPassword();
		ManagerInfo manager1 = new ManagerInfo();
		manager1.setEmail(email);
		manager1.setPassword(password);
		try {

			managerRepo.save(managerInfo);
		} catch (Exception e) {
			return ResponseEntity.ok(new  ManagerAuthResponse("Error creating Manager" + email));
		}
		return ResponseEntity.ok(new ManagerAuthResponse("Successfully created Manager " + email));
	}

//authenticating manager
	@PostMapping("/auth")
	private ResponseEntity<?> authManager(@RequestBody ManagerInfo managerInfo) {
		String email = managerInfo.getEmail();
		String password = managerInfo.getPassword();
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ManagerAuthResponse("Login Failed") );
		}
		return ResponseEntity.ok(new ManagerAuthResponse("Successfully Authenticated Manager" + email));
	}

//Reading all manager
	@GetMapping("/manager")
	public List<ManagerInfo> findAllManager() {
		return managerService.getManagerInfos();
	}

}
