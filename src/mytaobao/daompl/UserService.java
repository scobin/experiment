package mytaobao.daompl;

import java.util.HashMap;
import java.util.Map;

import mytaobao.dao.IUserService;
import mytaobao.model.User;

public class UserService implements IUserService {
	//user data for demo.
	private Map<String, User> users = null;

	public UserService() {
		users = new HashMap<String, User> ();
		User user = new User("admin","admin"); 
		this.insert(user);
	}
	
	@Override
	public void insert(User user) {
		users.put(user.getUserId(), user);

	}

	@Override
	public User getUserById(String userId) {
		return users.get(userId);
	}

}
