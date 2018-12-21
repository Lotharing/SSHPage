package top.lothar.bean;
/**
 * 图书实体类
 * @author Lothar
 *
 */
public class Book {
	
	private long id;
	
	private String name;
	
	public Book(){
		super();
	}

	public Book(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
