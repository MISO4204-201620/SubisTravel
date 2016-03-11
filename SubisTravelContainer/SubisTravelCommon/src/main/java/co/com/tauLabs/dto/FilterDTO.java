package co.com.tauLabs.dto;

import java.io.Serializable;
import java.util.List;

public class FilterDTO implements	Serializable {

	private static final long serialVersionUID = -3192090127016165648L;

	private String name;
	private String page;
	private Double minValue;
	private Double maxValue;
	private Long pages;
	private Long type;
	
	private List<String> providers;
	private List<String> clasifications;
	
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public List<String> getProviders() {
		return providers;
	}
	public void setProviders(List<String> providers) {
		this.providers = providers;
	}
	public List<String> getClasifications() {
		return clasifications;
	}
	public void setClasifications(List<String> clasifications) {
		this.clasifications = clasifications;
	}
	public Double getMinValue() {
		return minValue;
	}
	public void setMinValue(Double minValue) {
		this.minValue = minValue;
	}
	public Double getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(Double maxValue) {
		this.maxValue = maxValue;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPages() {
		return pages;
	}
	public void setPages(Long pages) {
		this.pages = pages;
	}
	public Long getType() {
		return type;
	}
	public void setType(Long type) {
		this.type = type;
	}
	
}
