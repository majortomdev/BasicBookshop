package projectBookShop;
/*created by JKinahan 25/02/17*/
public class Book {
	String bookName;
	String authorName;
	double price;
	
	public Book(String book, String name, Double cost){
		this.bookName= book;
		this.authorName= name;
		this.price= cost;
	}
	
	public void setBook(String book){
		this.bookName= book;
	}
	public String getBook(){
		return this.bookName;
	}
	public void setAuthor(String writer){
		this.authorName= writer;
	}
	public String getAuthor(){
		return this.authorName;
	}
	public void setPrice(Double price){
		this.price= price;
	}
	public double getPrice(){
		return this.price;
	}
	
	public String toString(){
		StringBuilder bookTag = new StringBuilder();
		bookTag.append("Book name: "+this.bookName+". "
				+ "Written by: "+this.authorName+". Cost: $"+this.price);
		return bookTag.toString();
	}
}
