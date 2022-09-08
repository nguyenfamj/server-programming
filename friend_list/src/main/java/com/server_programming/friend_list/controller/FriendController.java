package com.server_programming.friend_list.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.server_programming.friend_list.domain.Friend;

@Controller
public class FriendController {
	ArrayList<Friend> friendArray = new ArrayList<Friend>();

	@GetMapping("/index")
	public String friends(@RequestParam(name = "firstName", required = false) String firstName,
			@RequestParam(name = "lastName", required = false) String lastName, @ModelAttribute Friend friend,
			Model model) {

		model.addAttribute("friends", friendArray);
		model.addAttribute("friend", friend);

		return "index";
	}

	@PostMapping("/index")
	public String createFriend(@RequestParam(name = "firstName", required = false) String firstName,
			@RequestParam(name = "lastName", required = false) String lastName) {
		friendArray.add(new Friend(firstName, lastName));
		return "redirect:index";
	}
}
