package miniTwitter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.JTree;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class AdminWindow {
	
	private static AdminWindow adminWindow = null;
	private JFrame frame;
	private JTextField userIdField;
	private JTextField groupField;
	private IAdmin admin = new Admin();
	private JTree tree;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminWindow window = new AdminWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public static AdminWindow getInstance(){
		if(adminWindow == null){
			adminWindow = new AdminWindow();
		}
		return adminWindow;
	}
	
	/**
	 * Create the application.
	 */
	private AdminWindow() {
		initialize();
	}
	
	public void attachAdmin(IAdmin a){
		admin = a;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ITwitterService ts = TwitterService.getInstance();
		admin.attachTwitterService(ts);

		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		tree = new JTree();

		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Root") {
				{
				}
			}
		));

		springLayout.putConstraint(SpringLayout.NORTH, tree, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, tree, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, tree, -10, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(tree);
		
		userIdField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, userIdField, 420, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, userIdField, -102, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, tree, -6, SpringLayout.WEST, userIdField);
		springLayout.putConstraint(SpringLayout.SOUTH, userIdField, -531, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(userIdField);
		userIdField.setColumns(10);
		
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!(userIdField.getText().equals("")) && (userIdField.getText() != null)){
					admin.addUser(userIdField.getText());
				}
				else{
					JOptionPane.showMessageDialog(null, "A user requires an ID");
				}
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnAddUser, 6, SpringLayout.EAST, userIdField);
		springLayout.putConstraint(SpringLayout.NORTH, btnAddUser, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnAddUser, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnAddUser);
		
		groupField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, groupField, 6, SpringLayout.EAST, tree);
		frame.getContentPane().add(groupField);
		groupField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Add Group");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String groupId = groupField.getText();
				if(!(groupId.equals("")) && (groupId != null)){
					admin.addUserGroup(groupId);
					updateTree();
					}
					else{
						JOptionPane.showMessageDialog(null, "A user group requires an ID");
					}
			}
		});
		springLayout.putConstraint(SpringLayout.EAST, groupField, -6, SpringLayout.WEST, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 3, SpringLayout.SOUTH, btnAddUser);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 0, SpringLayout.WEST, btnAddUser);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Open User View");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							UserView window = new UserView();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_2, 3, SpringLayout.SOUTH, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_2, 6, SpringLayout.EAST, tree);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_2, -10, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, groupField, -6, SpringLayout.NORTH, btnNewButton_2);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Show Total Messages");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, admin.getMessageCount());

			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_3, 6, SpringLayout.EAST, tree);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Show Percent Positive");
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_3, -14, SpringLayout.WEST, btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Show Total Users");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, admin.getUserCount());
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_5, -39, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_3, 6, SpringLayout.SOUTH, btnNewButton_5);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_5, 6, SpringLayout.EAST, tree);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_5, 176, SpringLayout.EAST, tree);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Show Total Groups");
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, admin.getGroupCount());
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_4, 6, SpringLayout.SOUTH, btnNewButton_6);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_4, 0, SpringLayout.WEST, btnNewButton_6);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_4, 0, SpringLayout.EAST, btnNewButton_6);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_6, -39, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_6, -180, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_6, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnNewButton_6);
	
		
	}
	
	public void updateTree(){
		List<User> ugl = admin.getUsers();
		DefaultTreeModel dtm = (DefaultTreeModel)tree.getModel();
		DefaultMutableTreeNode root = (DefaultMutableTreeNode)dtm.getRoot();
		for(IUser ug: ugl){
			root.add(new DefaultMutableTreeNode(ug.getUserId()));
		}
		dtm.reload();
	}
}
