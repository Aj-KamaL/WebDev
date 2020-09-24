
package com.Natwest.UserAuthenticationService.controller;

import com.Natwest.UserAuthenticationService.exception.UserNullException;
import com.Natwest.UserAuthenticationService.model.User;
import com.Natwest.UserAuthenticationService.service.UserAuthenticationService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/auth/")
@CrossOrigin
//@EnableFeignClients
public class UserAuthenticationController {


	private UserAuthenticationService userAuthenticationService;
	private ResponseEntity responseEntity;
	private Map<String,String> map = new HashMap<>();
	public UserAuthenticationController(UserAuthenticationService authenticationService) {
		this.userAuthenticationService=authenticationService;
	}


	@PostMapping("/register")
	public ResponseEntity userRegister(@RequestBody User user){
		try {
			Boolean isUserRegistered = userAuthenticationService.saveUser(user);
			responseEntity = new ResponseEntity(isUserRegistered, HttpStatus.CREATED);
		} catch (UserNullException exception) {
			responseEntity = new ResponseEntity("error", HttpStatus.CONFLICT);
		}
		return responseEntity;
	}


	@PostMapping("/login")
	public ResponseEntity userLogin(@RequestParam(value="userName", required=true) String userName,
									@RequestParam(value="userPassword", required=true) String userPassword){

		try {
			ArrayList<String> array = getToken(userName,userPassword);
			map.put("message" , "User successfully logged in");
			map.put("token",array.get(0));
			map.put("userId",array.get(1));
		} catch (Exception e) {
			e.printStackTrace();
			map.put("message",e.getMessage());
			map.put("token",null);
			map.put("userId",null);
			return new ResponseEntity(map, HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity(map,HttpStatus.OK);
	}

	public ArrayList<String> getToken(String userName, String userPassword) throws Exception {
		ArrayList<String> array=new ArrayList<>();
		String jwtToken="";
		if(userName == null || userPassword == null){
			throw new Exception("Please send valid userName or userPassword");
		}
		User user =  userAuthenticationService.findByUserNameAndUserPassword(userName,userPassword);
		if(user==null){
			throw new Exception("Invalid credentials");
		}
		else
		{
			jwtToken = Jwts.builder()
					.setSubject(userName)
					.setIssuedAt(new Date())
					.setExpiration(new Date(System.currentTimeMillis() + 900000))
					.signWith(SignatureAlgorithm.HS256,"secretkey")
					.compact();
			array.add(jwtToken);
			array.add(""+user.getUserId());
		}
		return array;
	}
}

//@RequestMapping("/hello/{id}")    public String getDetails(@PathVariable(value="id") String id,
//														   @RequestParam(value="param1", required=true) String param1,
//														   @RequestParam(value="param2", required=false) String param2){}


//{
//"userName":"AJ",
//"userPassword":"password",
//"userLocation":"India"
//}

//http://localhost:8084/api/v1/auth/register
//http://localhost:8084/api/v1/auth/login?userName=AJ&userPassword=password