package com.hlv.bean;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class AbstractBean<E> extends MessageBean {
	@Valid
	protected E entity;
	protected int limit = 10;
	protected int start = 0;
	protected int total = 0;
	protected String sort;
	protected String dir;
	protected List<E> listResult;
	protected String action;
	protected String crudaction;
	protected int page = 1;
	protected int maxPage=5;
	protected List<Long> ids;
	
	protected boolean error;
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public List<E> getListResult() {
		return listResult;
	}
	public void setListResult(List<E> listResult) {
		this.listResult = listResult;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getCrudaction() {
		return crudaction;
	}
	public void setCrudaction(String crudaction) {
		this.crudaction = crudaction;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public E getEntity() {
		return entity;
	}
	public void setEntity(E entity) {
		this.entity = entity;
	}
	public List<Long> getIds() {
		return ids;
	}
	public void setIds(List<Long> ids) {
		this.ids = ids;
	}
	
	public Integer getTotalPage(){
		if(total==0) return 0;
		else {
			if(total%limit!=0) return ((int)total/limit)+1;
			else return (int)total/limit;
		}
	}
	
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public List<Integer> getListPage(){
		if(page==0) return new ArrayList<Integer>();
		else {
			Integer count=(Integer)page/maxPage;
			int begin=1;
			int end=maxPage-1;
			if(count==0) {
				begin=1;
				end=maxPage-1;
			}
			else {
				begin=count*maxPage;
				end=(count+1)*maxPage-1;
			}
			if(end>getTotalPage()) end=getTotalPage();
			
			List<Integer> result=new ArrayList<Integer>();
			for( int i=begin;i<=end;i++) {
				result.add(i);
			}
			return result;
		}
	}
	public void injectBindingResult(BindingResult bindingResult){
		if(messages==null) messages=new ArrayList<Message>();
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		for(FieldError fieldError:fieldErrors){
			messages.add(new Message(Message.ERROR,fieldError.getField(),fieldError.getDefaultMessage()));
		}
	}
}
