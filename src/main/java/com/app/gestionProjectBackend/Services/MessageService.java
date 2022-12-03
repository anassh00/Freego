package com.app.gestionProjectBackend.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.gestionProjectBackend.Repository.MessageRepository;
import com.app.gestionProjectBackend.models.Message;


@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;
	
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
}
