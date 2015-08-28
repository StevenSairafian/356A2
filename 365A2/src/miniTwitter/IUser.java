package miniTwitter;

import java.util.List;

public interface IUser {

	public abstract String getUserId();

	public abstract List<String> getFollowing();

	public abstract List<String> getFollowers();

	public abstract List<Message> getMessages();

	public abstract void post(String message);

	public abstract void addMessage(Message m);

	public abstract void follow(String idToFollow);

}