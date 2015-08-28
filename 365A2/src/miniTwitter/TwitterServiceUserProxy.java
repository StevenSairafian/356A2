package miniTwitter;

public class TwitterServiceUserProxy implements ITwitterServiceUserProxy {

	private static ITwitterService t;
	private static ITwitterServiceUserProxy tSUP = null;
	
	private TwitterServiceUserProxy(ITwitterService ts){
		this.t = ts;
	}
	
	public static ITwitterServiceUserProxy getInstance(ITwitterService ts){
		if(tSUP == null){
			tSUP = new TwitterServiceUserProxy(ts);
		}
		return tSUP;
	}
	
	/* (non-Javadoc)
	 * @see miniTwitter.ITwitterServiceUserProxy#getUserById(java.lang.String)
	 */
	@Override
	public IUser getUserById(String id){
		return t.getUserByID(id);
	}
	
	/* (non-Javadoc)
	 * @see miniTwitter.ITwitterServiceUserProxy#notifyNewMessage(java.lang.String)
	 */
	@Override
	public void notifyNewMessage(String userId){
		t.notifyNewMessage(userId);
	}
	
}
