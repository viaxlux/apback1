
package com.pil.grim.logindao;
import com.pil.grim.loginentity.user;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface logindao extends CrudRepository<user,Integer>{
    user findByUsername(String usermail); 
    user findByUsernameAndPassword(String usermail,String Password); 
}

