package miniTwitter;

import java.util.List;

public class Admin implements IAdmin {
	
	private ITwitterService ts;
	private ITwitterServiceUserProxy tsp;
	
	/* (non-Javadoc)
	 * @see miniTwitter.IAdmin#addUser(java.lang.String)
	 */
	@Override
	public void addUser(String userId){
		ts.addUser(new User(userId, tsp, new UserView()));
	}
	
	/* (non-Javadoc)
	 * @see miniTwitter.IAdmin#addUserGroup(java.lang.String)
	 */
	@Override
	public void addUserGroup(String groupId){
		UserGroup ug = new UserGroup();
		ug.setGroupId(groupId);
	}
	
	/* (non-Javadoc)
	 * @see miniTwitter.IAdmin#attachTwitterService(miniTwitter.TwitterService)
	 */
	@Override
	public void attachTwitterService(ITwitterService ts){
		this.ts = ts;
	}
	
	/* (non-Javadoc)
	 * @see miniTwitter.IAdmin#setTwitterServiceUserProxy(miniTwitter.TwitterServiceUserProxy)
	 */
	@Override
	public void setTwitterServiceUserProxy(ITwitterServiceUserProxy tsp){
		this.tsp = tsp;
	}
	
	/* (non-Javadoc)
	 * @see miniTwitter.IAdmin#getUserCount()
	 */
	@Override
	public int getUserCount(){
		return ts.getUserCount();
	}
	
	/* (non-Javadoc)
	 * @see miniTwitter.IAdmin#getGroupCount()
	 */
	@Override
	public int getGroupCount(){
		return ts.getGroupCount();
	}
	
	/* (non-Javadoc)
	 * @see miniTwitter.IAdmin#getMessageCount()
	 */
	@Override
	public int getMessageCount(){
		return ts.getMessageCount();
	}
	
	/* (non-Javadoc)
	 * @see miniTwitter.IAdmin#getUsers()
	 */
	@Override
	public List<User> getUsers(){
		return ts.getUsers();
	}
	
}
