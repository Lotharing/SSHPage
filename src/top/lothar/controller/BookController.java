package top.lothar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import top.lothar.bean.Book;
import top.lothar.bean.PageBean;
import top.lothar.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	private PageBean pageBean;
	
	@SuppressWarnings("unused")
	private List<Book> books = null;
	
	@RequestMapping(value = "page.spring")
	public String paging(int page , Model model){
		
		//这部分很不合理，应该直接获取总页数，便于下边else if 的判断，但是下边判断条件不能直接写，因为第一次执行时BeanPage中还没有数据
		int maxPage = 3;
	
		if(page<=0){
			page = 1 ;
			System.out.println(page+"----小于0的时候将page初始化为1");
			currentPage(page, model);
		}else if(page>maxPage){
			page = pageBean.getSumPages();
			System.out.println("当前page="+page+"----大于"+pageBean.getSumPages()+"的时候将page初始化为"+pageBean.getSumPages());
			currentPage(page, model);
		}else{
			System.out.println("page="+page+"在页码安全范围之内");
			currentPage(page, model);
		}
		return "page";
	}
	/**
	 * 通用分页查询功能
	 * 通用存储域功能
	 * @param page
	 * @param model
	 */
	public void currentPage(int page , Model model){
		this.pageBean = bookService.queryForPage(4, page);
		this.books = this.pageBean.getBooks();
		//存入model对象
		model.addAttribute("pageBean" , pageBean);
		model.addAttribute("page",page);
	}
}
