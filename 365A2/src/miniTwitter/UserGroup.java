package miniTwitter;

import java.util.List;

public class UserGroup implements IUserGroup {

	private String groupId;
	private List<User> members;
	private List<UserGroup> subGroups;

	/* (non-Javadoc)
	 * @see miniTwitter.IUserGroup#getGroupId()
	 */
	@Override
	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	/* (non-Javadoc)
	 * @see miniTwitter.IUserGroup#getMembers()
	 */
	@Override
	public List<User> getMembers() {
		return members;
	}

	public void setMembers(List<User> members) {
		this.members = members;
	}

	/* (non-Javadoc)
	 * @see miniTwitter.IUserGroup#getSubGroups()
	 */
	@Override
	public List<UserGroup> getSubGroups() {
		return subGroups;
	}

	public void setSubGroups(List<UserGroup> subGroups) {
		this.subGroups = subGroups;
	}
}
