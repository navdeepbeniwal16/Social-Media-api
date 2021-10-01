package com.denin.socialmediaapp.models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> userList = new ArrayList<User>();
    private static Integer usersCount = 3;
    static {
        userList.add(new User(1,"navdeep", new Date()));
        userList.add(new User(2,"denin", new Date()));
        userList.add(new User(3,"aditaya", new Date()));
    }

    public List<User> findAll(){
        return userList;
    }

    public User findOne(Integer id){
        for(User user: userList){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public User save(User user){
        if(user.getId() == null){
            user.setId(++usersCount);
        }
        userList.add(user);
        return user;
    }

    public User deleteById(Integer id){
        Iterator<User> iterator = userList.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();
            if(user.getId() == id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
