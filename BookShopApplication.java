package projectBookShop;
/*created by JKinahan 25/03/17*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BookShopApplication extends JFrame {
	
	JTabbedPane front= new JTabbedPane();
	JPanel displayJP, updateJP, insertJP, deleteJP = new JPanel();
	JTextArea JText1= new JTextArea(10,35);
	JTextArea JText2= new JTextArea(10,35);
	JTextArea JText3= new JTextArea(10,35);
	JTextArea JText4 = new JTextArea(10,35);
	JButton button1 = new JButton("Display All Books");
	JButton button2 = new JButton("Update Price");
	JButton button3 = new JButton("Insert Book");
	JButton button4 = new JButton("Delete");
	
	JLabel labelNameUpdate= new JLabel("Enter the Name of the Book:");
	JLabel labelPriceUpdate=new JLabel("Enter the new Price:");
	JLabel labelNameInsert= new JLabel("Enter the Name of the Book:");
	JLabel labelAuthorInsert= new JLabel("Enter the Author of the Book:");
	JLabel labelNameNewBook= new JLabel("Enter the Name of the New Book:");
	JLabel labelAuthorNewBook= new JLabel("Enter the Author of the Book:");
	JLabel labelPriceNewBook= new JLabel("Enter the Price");
	JLabel labelDeleteBook= new JLabel("Enter the name of the Book to be Deleted");
	JTextField nameUpdate= new JTextField(25);
	JTextField priceUpdate= new JTextField(10);
	JTextField nameNewBook= new JTextField(20);
	JTextField authorNewBook= new JTextField(20);
	JTextField priceNewBook= new JTextField(10);
	JTextField bookToDelete= new JTextField(20);
	
	
	public BookShopApplication(){
		super("My Bookshop application");
		this.add(front);
		displayJP= new JPanel();
		displayJP.add(button1);
		displayJP.add(JText1); 
		front.addTab("Display All Books", displayJP);
		/******************************************************************/
		updateJP= new JPanel(); 
		updateJP.add(labelNameUpdate); updateJP.add(nameUpdate);
		updateJP.add(labelPriceUpdate); updateJP.add(priceUpdate);
		updateJP.add(button2);
		updateJP.add(JText2);
		front.addTab("Update Price Of Book", updateJP);
		/****************************************************************/
		insertJP = new JPanel();
		insertJP.add(labelNameNewBook);insertJP.add(nameNewBook);
		insertJP.add(labelAuthorNewBook); insertJP.add(authorNewBook);
		insertJP.add(labelPriceNewBook); insertJP.add(priceNewBook);
		insertJP.add(button3); 
		insertJP.add(JText3);
		front.addTab("Insert A New Book", insertJP);
		/********************************************************************/
		deleteJP= new JPanel();
		deleteJP.add(labelDeleteBook); deleteJP.add(bookToDelete);
		deleteJP.add(button4); deleteJP.add(JText4);
		front.addTab("Delete a Book", deleteJP);
		
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				JText1.setText(null);
				BookQueries.selectAllFromDB(JText1);
			}
		});
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				BookQueries.updatePrice(nameUpdate.getText(), priceUpdate.getText(), JText2);
				nameUpdate.setText(null);priceUpdate.setText(null);
			}
		});
		button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				BookQueries.insertNewBook(nameNewBook.getText(), authorNewBook.getText()
						, priceNewBook.getText(), JText3);
				nameNewBook.setText(null);authorNewBook.setText(null);priceNewBook.setText(null);
			}
		});
		button4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				BookQueries.deleteBook(bookToDelete.getText(), JText4);
				bookToDelete.setText(null);
			}
		});
	}
	
	public static void main(String[] args) {
		BookShopApplication booky= new BookShopApplication();
		booky.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		booky.setVisible(true);
		booky.setSize(850, 580);
	}
	
}
