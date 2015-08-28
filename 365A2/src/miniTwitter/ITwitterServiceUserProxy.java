package miniTwitter;

public interface ITwitterServiceUserProxy {

	public abstract IUser getUserById(String id);

	public abstract void notifyNewMessage(String userId);

}