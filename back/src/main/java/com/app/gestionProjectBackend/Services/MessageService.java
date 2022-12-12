package com.app.gestionProjectBackend.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.gestionProjectBackend.Repository.MessageRepository;
import com.app.gestionProjectBackend.models.Message;
import com.app.gestionProjectBackend.models.User;


@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private UserService userService;
	
	public Optional<Message> findById(Long id) {
		return messageRepository.findById(id);
	}
	
	@Transactional
	public Message add(Message message) {
		Message newMessage = messageRepository.save(message);
		return newMessage;
	}
	
	@Transactional
	public Message update(Long id, Message message) {
		message.setId(id);
		return messageRepository.save(message);
	}
	
	public Iterable<Message> findAll() {
		return messageRepository.findAll();
	}
	
	public ArrayList<Message> findMessageBetweenTwo(Long idSender, Long idReceiver){
		return messageRepository.findMessageBetweenTwo(idSender,idReceiver).get();
	}
	
	public ArrayList<User> findListOfContactedUsers(Long idSender){
		ArrayList<Long> list = messageRepository.findListOfContactedUsers(idSender).get();
		ArrayList<User> userList = new ArrayList<>();
		for (Long userId : list) {
			userList.add(userService.findById(userId).get());
		}
		return userList;
	}
}
