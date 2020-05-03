package datastructures;

public class shoppingList {
	
	private String article;
	private String amount;
	public shoppingList(String article, String amount) {
		super();
		this.article = article;
		this.amount = amount;
	}
	public String getArticle() {
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	

}
