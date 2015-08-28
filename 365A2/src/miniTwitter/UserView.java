package miniTwitter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.JList;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserView {

	JFrame frame;
	private JTextField userIdField;
	private JTextField messageField;
	private JButton btnNewButton_1;
	private JList followingList;
	private JList tweetList;
	private IUser user;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public UserView() {
		initialize();
	}
	
	public void attachUser(IUser u){
		this.user = u;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 450);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		userIdField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, userIdField, 11, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, userIdField, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(userIdField);
		userIdField.setColumns(10);
		
		JButton btnNewButton = new JButton("Follow User");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!userIdField.getText().equals("")){
					user.follow(userIdField.getText());
					followingList.setListData(user.getFollowers().toArray());

				}
				else{
					JOptionPane.showMessageDialog(null, "Cannot follow this user");
				}
			}
		});
		springLayout.putConstraint(SpringLayout.EAST, userIdField, -10, SpringLayout.WEST, btnNewButton);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 218, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnNewButton);
		
		messageField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, messageField, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, messageField, -200, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, messageField, -105, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(messageField);
		messageField.setColumns(10);
		
		btnNewButton_1 = new JButton("Tweet");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!messageField.getText().equals("")){
					user.post(messageField.getText());
					tweetList.setListData(user.getMessages().toArray());

				}
				else{
					JOptionPane.showMessageDialog(null, "Cannot post nothing");
				}
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 6, SpringLayout.EAST, messageField);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, 0, SpringLayout.EAST, btnNewButton);
		frame.getContentPane().add(btnNewButton_1);
		
		followingList = new JList<String>();
		springLayout.putConstraint(SpringLayout.NORTH, followingList, 6, SpringLayout.SOUTH, userIdField);
		springLayout.putConstraint(SpringLayout.WEST, followingList, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, followingList, -6, SpringLayout.NORTH, messageField);
		springLayout.putConstraint(SpringLayout.EAST, followingList, 0, SpringLayout.EAST, btnNewButton);
		frame.getContentPane().add(followingList);
		
		tweetList = new JList();
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -4, SpringLayout.NORTH, tweetList);
		springLayout.putConstraint(SpringLayout.NORTH, tweetList, 217, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, tweetList, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, tweetList, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, tweetList, 424, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(tweetList);
	}
	
	public void updateFollowingList(){
		followingList.setListData(user.getFollowers().toArray());

	}
	
	public void updateTweetList(){
		tweetList.setListData(user.getMessages().toArray());

	}
}
