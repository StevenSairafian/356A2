package miniTwitter;

public class Message implements IMessage {
	private String messageText;
	private String userID;
	
	public Message(String id, String text){
		this.setMessageText(text);
		this.setUserID(id);
	}

	/* (non-Javadoc)
	 * @see miniTwitter.IMessage#getMessageText()
	 */
	@Override
	public String getMessageText() {
		return messageText;
	}

	private void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	/* (non-Javadoc)
	 * @see miniTwitter.IMessage#getUserID()
	 */
	@Override
	public String getUserID() {
		return userID;
	}

	private void setUserID(String userID) {
		this.userID = userID;
	}
}
