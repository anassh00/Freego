package com.app.gestionProjectBackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.gestionProjectBackend.Dto.Request.MessageRequestDto;
import com.app.gestionProjectBackend.Security.Payload.Response.MessageResponse;
import com.app.gestionProjectBackend.Security.Services.UserDetailsImpl;
import com.app.gestionProjectBackend.Services.MessageService;
import com.app.gestionProjectBackend.Services.UserService;
import com.app.gestionProjectBackend.models.Category;
import com.app.gestionProjectBackend.models.Message;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/api/message")
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/saveMessage", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> saveMessage(@RequestBody MessageRequestDto messageDto) {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();	
			Message message = new Message();
			message.setMessageRead("false");
			message.setMessageText(messageDto.getText());
			message.setUserSender(userService.findById(userDetails.getId()).get());
			message.setUserReceiver(userService.findById(messageDto.getUserReceiverId()).get());
			messageService.add(message);
			return ResponseEntity.ok(new MessageResponse("Message registered successfully!"));
		}catch(Exception e){
	        e.printStackTrace(); 
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: An internal error has occurred");
		}
	}
	
	@RequestMapping(value = "/getMessage", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getMessage(@RequestParam Long id) {
		try {
			Message message = messageService.findById(id).get();
			return new ResponseEntity<Message>(message, HttpStatus.OK);
		}catch(Exception e){
	        e.printStackTrace(); 
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: An internal error has occurred");
		}
	}
}
