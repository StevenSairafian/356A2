package miniTwitter;

import java.util.List;

public interface IUserGroup {

	public abstract String getGroupId();

	public abstract List<User> getMembers();

	public abstract List<UserGroup> getSubGroups();

}