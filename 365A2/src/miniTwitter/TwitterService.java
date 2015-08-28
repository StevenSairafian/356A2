package miniTwitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwitterService implements ITwitterService {
	
	private static ITwitterService tService = null;
	private Map<String, User> userTable;
	private List<UserGroup> groups;
	private IAdmin admin;
	private AdminWindow aWindow;
	private int messageCount = 0;
	private int positiveCount = 0;
	
	
	private TwitterService(){
		userTable = new HashMap<String, User>();
		groups = new ArrayList<UserGroup>();
		UserGroup root = new UserGroup();
		root.setGroupId("Root");
	}
	
	public static ITwitterService getInstance(){
		if(tService == null){
			tService = new TwitterService();
		}
		return tService;
	}
	
	/* (non-Javadoc)
	 * @see miniTwitter.ITwitterService#getUserByID(java.lang.String)
	 */
	@Override
	public IUser getUserByID(String id){
		return userTable.get(id);
	}
	
	/* (non-Javadoc)
	 * @see miniTwitter.ITwitterService#addUser(miniTwitter.User)
	 */
	@Override
	public void addUser(User s){
		userTable.put(s.getUserId(), s);
	}
	
	/* (non-Javadoc)
	 * @see miniTwitter.ITwitterService#addUserGroup(miniTwitter.UserGroup)
	 */
	@Override
	public void addUserGroup(UserGroup ug){
		groups.add(ug);
	}
	
	/* (non-Javadoc)
	 * @see miniTwitter.ITwitterService#getUserGroups()
	 */
	@Override
	public List<UserGroup> getUserGroups(){
		return groups;
	}
	
	/* (non-Javadoc)
	 * @see miniTwitter.ITwitterService#getUserCount()
	 */
	@Override
	public int getUserCount(){
		return userTable.size();
	}
	
	/* (non-Javadoc)
	 * @see miniTwitter.ITwitterService#getGroupCount()
	 */
	@Override
	public int getGroupCount(){
		return groups.size();
	}
	
	/* (non-Javadoc)
	 * @see miniTwitter.ITwitterService#getMessageCount()
	 */
	@Override
	public int getMessageCount(){
		return messageCount;
	}
	
	/* (non-Javadoc)
	 * @see miniTwitter.ITwitterService#getUsers()
	 */
	@Override
	public List<User> getUsers(){
		return new ArrayList<User>(userTable.values());
	}
	
	/* (non-Javadoc)
	 * @see miniTwitter.ITwitterService#notifyNewMessage(java.lang.String)
	 */
	@Override
	public void notifyNewMessage(String userId){
		messageCount++;
		IUser u = userTable.get(userId);
		Message m = u.getMessages().get(u.getMessages().size() - 1);
		if(m.getMessageText().contains("Good")){
			positiveCount++;
		}
		List<String> followers = u.getFollowers();
		
		for(String s : followers){
			userTable.get(s).addMessage(m);
		}
	}
	
	public double percentPositive(){
		return (double)positiveCount/(double)messageCount;
	}
	
}
