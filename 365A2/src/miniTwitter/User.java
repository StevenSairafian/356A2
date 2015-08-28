package miniTwitter;

import java.util.List;

public class User implements IUser {

	private String userId;
	private List<String> following;
	private List<String> followers;
	private List<Message> messages;
	private ITwitterServiceUserProxy tsup;
	private UserView userView = null;

	public User(String uid, ITwitterServiceUserProxy tsup, UserView uv){
		this.userId = uid;
		this.tsup = tsup;
		this.userView = uv;
	}
	
	/* (non-Javadoc)
	 * @see miniTwitter.IUser#getUserId()
	 */
	@Override
	public String getUserId() {
		return userId;
	}

	/* (non-Javadoc)
	 * @see miniTwitter.IUser#getFollowing()
	 */
	@Override
	public List<String> getFollowing() {
		return following;
	}
	public void setFollowing(List<String> following) {
		this.following = following;
	}
	/* (non-Javadoc)
	 * @see miniTwitter.IUser#getFollowers()
	 */
	@Override
	public List<String> getFollowers() {
		return followers;
	}
	public void setFollowers(List<String> followers) {
		this.followers = followers;
	}
	/* (non-Javadoc)
	 * @see miniTwitter.IUser#getMessages()
	 */
	@Override
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	/* (non-Javadoc)
	 * @see miniTwitter.IUser#post(java.lang.String)
	 */
	@Override
	public void post(String message){
		messages.add(new Message(this.userId, message));
		tsup.notifyNewMessage(this.userId);
		
	}
	
	/* (non-Javadoc)
	 * @see miniTwitter.IUser#addMessage(miniTwitter.Message)
	 */
	@Override
	public void addMessage(Message m){
		messages.add(m);
	}
	
	/* (non-Javadoc)
	 * @see miniTwitter.IUser#follow(java.lang.String)
	 */
	@Override
	public void follow(String idToFollow){
		following.add(idToFollow);
	}
	
	public void displayUserView(){
		
	}
	
}
