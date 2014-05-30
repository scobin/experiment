/**
 * 
 */
package mytaobao.dao.biz;

import mytaobao.dao.IUserService;
import mytaobao.daompl.UserService;
import mytaobao.model.User;

/**
 * @author kawachi
 *
 */
public class UserManager {
	private IUserService dao = null;
	
	public UserManager() {
		dao = new UserService();
	}
	
	/**
	 * Login. If succeeded, return the user instance, else return null. 
	 * @param userId
	 * @param password
	 * @return
	 */
	public User login(String userId, String password) {
		User user = dao.getUserById(userId);
		if (user != null) {
			return user.getPassword().equals(password) ? user : null;
		}
		return null;
	}
	
	/**
	 * Register. If succeeded, return the user instance, else return null.
	 * @param user
	 * @return
	 */
	public User Register(User user) {
		try {
			this.dao.insert(user);
			return user;
		} catch (Exception ex) {
			return null;
		}
		
	}

}
