package chap18.controller;

import java.awt.List;

import chap18.model.MovieModel;

public class MovieController {
	
	MovieModel movieModel;
	
	public MovieController() {
		movieModel = new MovieModel();
	}
	
	// 선택 기능 요청
	public void selectTitles() {
		movieModel.selectTitles();
	}
	
	// 추가 기능 요청
	public void addTitle(String mTitle, List movieList) {
		movieModel.addTitle(mTitle, movieList);
	}
	
	// 저장 기능 요청
	public void saveTitles(List movieList) {
		movieModel.saveTitles(movieList);
	}
	
	// 삭제 기능 요청
	public void delTitles(String mTitle, List movieList) {
		movieModel.delTitles(mTitle, movieList);
	}
	
	// 종료 기능 요청
	public void exitTitles() {
		movieModel.exitTitles();
	}
}
