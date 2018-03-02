package com.learn.spring.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.learn.spring.model.User;

@Service
public class UserServiceImpl implements UserService {

    static Map<String, User> users = new HashMap<String, User>();

    static {
			    users.put("1", new User("1", "User-1"));
			    users.put("2", new User("2", "User-2"));
			    users.put("3", new User("3", "User-3"));
			    users.put("4", new User("4", "User-4"));
			    users.put("5", new User("5", "User-5"));
			    users.put("6", new User("6", "User-6"));
    }

    @Override
    public List<User> getAll() {
    	List<User> usersList = new ArrayList<User>();
    	Set keySet = users.keySet();
    	Iterator<User> it = keySet.iterator();
    	while (it.hasNext()) {
    		usersList.add(users.get(it.next()));
    	}
        return usersList;
    }

    @Override
    public User findById(String id) {
    	Set keySet = users.keySet();
    	Iterator<User> it = keySet.iterator();
    	while (it.hasNext()) {
    		User user = users.get(it.next());
            if (user != null && user.getId().equals(id)){
                return user;
            }
    	}
        return null;
    }

    @Override
    public User findByName(String name) {
    	Set keySet = users.keySet();
    	Iterator<User> it = keySet.iterator();
    	while (it.hasNext()) {
    		User user = it.next();
            if (user.getName().equals(name)){
                return user;
            }
    	}
        return null;
    }

    @Override
    public void create(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public void update(User user) {
    	Set keySet = users.keySet();
    	Iterator<User> it = keySet.iterator();
    	while (it.hasNext()) {
    		User userIt = users.get(it.next());
            if (userIt.getId().equals(user.getId())){
                //users.put(user.getId(), user);
            	break;
            }
    	}
        users.put(user.getId(), user);
    }

    @Override
    public void delete(String id) {        
        users.remove(id);
    }

    @Override
    public boolean exists(User user) {
        return findByName(user.getName()) != null;
    }
}