package com.app.gestionProjectBackend.Repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.gestionProjectBackend.models.Message;
import com.app.gestionProjectBackend.models.User;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long>{
	
	@Query(value="SELECT * FROM messaging m where m.user_sender_id = :idSender AND m.user_receiver_id = :idReceiver", nativeQuery = true)
	public Optional<ArrayList<Message>> findMessageBetweenTwo(Long idSender, Long idReceiver);

	@Query(value="SELECT DISTINCT m.user_receiver_id FROM messaging m where m.user_sender_id = :idSender", nativeQuery = true)
	public Optional<ArrayList<Long>> findListOfContactedUsers(Long idSender);
	
}
