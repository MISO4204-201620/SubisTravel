package co.com.tauLabs.dto;

import java.io.Serializable;
import java.util.List;

public class PaginateDTO implements Serializable {
	
	private static final long serialVersionUID = 3694139591062023083L;

	private Long pages;
	
	private Long elements;
	
	private List<Object> lstElements;
	
	public Long getPages() {
		return pages;
	}
	public void setPages(Long pages) {
		this.pages = pages;
	}
	public List<Object> getLstElements() {
		return lstElements;
	}
	public void setLstElements(List<Object> lstElements) {
		this.lstElements = lstElements;
	}
	public Long getElements() {
		return elements;
	}
	public void setElements(Long elements) {
		this.elements = elements;
	}
	
}
