package mytaobao.dao;

import mytaobao.model.User;

/**
 * User interface
 * @author kawachi
 *
 */
public interface IUserService {
	public void insert(User user);
	public User getUserById(String userId);

}
