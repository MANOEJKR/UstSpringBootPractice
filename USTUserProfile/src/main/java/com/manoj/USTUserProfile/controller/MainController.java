package com.manoj.USTUserProfile.controller;


import com.manoj.USTUserProfile.model.Profile;
import com.manoj.USTUserProfile.model.Users;
import com.manoj.USTUserProfile.repository.ProfileRepository;
import com.manoj.USTUserProfile.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MainController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProfileRepository profileRepository;

    @PostMapping("/user")
    public ResponseEntity<Users>createUser(@RequestBody Users user)
    {
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }

    @GetMapping("/user/{name}")
    public ResponseEntity<Users> getUser(@PathVariable String name)
    {
        return new ResponseEntity<>(userRepository.findByNameCustom(name),HttpStatus.OK);
    }

    @PostMapping("/profile/{uid}")
    public ResponseEntity<Profile>createProfile(@RequestBody Profile profile,@PathVariable Long uid)
    {
        Users returnuser = userRepository.findByCustosmId(uid);
        profile.setUser(returnuser);
        return new ResponseEntity<>(profileRepository.save(profile), HttpStatus.CREATED);
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<Profile> getprofile(@PathVariable Long id)
    {
        return new ResponseEntity<>(profileRepository.findByIdCustom(id),HttpStatus.FOUND);
    }

//    @GetMapping("/profile/{pid}/user/{uid}")
//    public ResponseEntity<Profile> makeonetoone(@PathVariable Long pid, @PathVariable Long uid)
//    {
//        Users returnuser = userRepository.findByCustosmId(uid);
//        Profile returnprofile = profileRepository.findByIdCustom(pid);
//
//        returnprofile.setUser(returnuser);
//        return new ResponseEntity<>(profileRepository.save(returnprofile),HttpStatus.CREATED);
//    }


}
