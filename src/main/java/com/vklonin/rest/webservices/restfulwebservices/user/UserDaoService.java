package com.vklonin.rest.webservices.restfulwebservices.user;

import com.vklonin.rest.webservices.restfulwebservices.exception.InsufficientDataException;
import com.vklonin.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 3;
    static {
        users.add(new User(1, "Adam", new Date()));
        users.add(new User(2, "Eve", new Date()));
        users.add(new User(3, "Jack", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user){
//        if(user.getBirthDate()==null || user.getName().equals("") ) {
//            throw new InsufficientDataException("insufficient data ubd or name");
//        }
        if(user.getId()==null){
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }
    public User findOne(int id){
        List<User> usersList = UserDaoService.users.stream().filter(user -> user.getId() == id).collect(Collectors.toList());
         if(usersList.isEmpty()){
             throw new UserNotFoundException("id-" + id);
         }else{return usersList.get(0);}
    }

    public String deleteOne(int id) {
        List<User> usersList = UserDaoService.users.stream().filter(user -> user.getId() == id).collect(Collectors.toList());
        if(usersList.isEmpty()){
            throw new UserNotFoundException("id-" + id);
        }else{
            users.remove(id-1);
            return "User deleted id-"+id;
        }

    }
}
