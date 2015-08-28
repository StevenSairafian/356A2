package miniTwitter;

import java.util.List;

public interface IAdmin {

	public abstract void addUser(String userId);

	public abstract void addUserGroup(String groupId);

	public abstract void attachTwitterService(ITwitterService ts);

	public abstract void setTwitterServiceUserProxy(ITwitterServiceUserProxy tsp);

	public abstract int getUserCount();

	public abstract int getGroupCount();

	public abstract int getMessageCount();

	public abstract List<User> getUsers();

}