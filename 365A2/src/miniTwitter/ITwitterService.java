package miniTwitter;

import java.util.List;

public interface ITwitterService {

	public abstract IUser getUserByID(String id);

	public abstract void addUser(User s);

	public abstract void addUserGroup(UserGroup ug);

	public abstract List<UserGroup> getUserGroups();

	public abstract int getUserCount();

	public abstract int getGroupCount();

	public abstract int getMessageCount();

	public abstract List<User> getUsers();

	public abstract void notifyNewMessage(String userId);

}