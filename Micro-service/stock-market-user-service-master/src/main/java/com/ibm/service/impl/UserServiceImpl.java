package com.ibm.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ibm.exception.ResourceNotFoundException;
import com.ibm.exception.UserError;
import com.ibm.model.User;
import com.ibm.repository.UserRepository;
import com.ibm.service.MailService;
import com.ibm.service.UserService;
import com.ibm.utils.UUIDUtils;


@Service(value = "userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	 @Autowired
	MailService mailService;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Invalid username or password."));
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isActive(), true, true, true, getRoles(user)); 
	}

	@Override
	public User findOne(String username) {
		return userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
	}

	private List<GrantedAuthority> getRoles(User user) {
    	return Arrays.asList(new SimpleGrantedAuthority("ROLE_" + user.getUserType()));
	}
	
	@Override
	public boolean isConfirmed(String username) {
		User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Invalid username or password."));
		return user.getConfirmed()==0?true:false;
		
	}

	@Override
	public void register(User user) {
		String code = user.getCode();
		String subject = "It is an active email from StockMarket";
		String context ="<a href=\"/checkCode?code="+code+"\">please click:"+code+"</a>";
		mailService.sendHtmlMail (user.getEmail(),subject,context);
	}
	

    /**
     * 根据激活码code进行查询用户，之后再进行修改状态
     * @param code
     * @return
     */
    @Override
    public User checkCode(String code) {
    	User user = userRepository.findByCode(code).orElseThrow(() -> new UsernameNotFoundException("Invalid code."));
        return user;
    }
 
    /**
     * 激活账户，修改用户状态
     * @param user
     */
    @Override
    public void updateUserStatus(User user) {
    	userRepository.updateConfirmed(user.getUsername(),user.getPassword(),user.getConfirmed());
    }

	@Override
	public User loginUser(User user) {
		 User user1 = userRepository.loginUser(user.getUsername(),user.getPassword(),user.getConfirmed()).orElseThrow(() -> new UsernameNotFoundException("Invalid username or password or not confirmed."));
	        
		return user1;
	}

	
}

